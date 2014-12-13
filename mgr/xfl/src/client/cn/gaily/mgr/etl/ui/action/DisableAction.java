package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;

import nc.bs.framework.common.NCLocator;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.actions.IActionVisible;
import nc.vo.pub.SuperVO;
import cn.gaily.base.service.IBaseService;
import cn.gaily.base.ui.util.VOUtil;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.MgrInfoVO;
import cn.gaily.mgr.etl.MgrItemVO;
import cn.gaily.pub.trigger.AbstractETLTask;
import cn.gaily.pub.trigger.DefaultETLTask;
import cn.gaily.pub.util.CommonUtils;
import cn.gaily.simplejdbc.SimpleDSMgr;

public class DisableAction extends NCAction implements IActionVisible{

	private BillManageModel model;
	private ShowUpableBillForm editor;
	
	IBaseService service = NCLocator.getInstance().lookup(IBaseService.class);
	
	/**
	 * Õ£”√ ∞¥≈•
	 */
	private static final long serialVersionUID = -7965519936454015766L;

	public DisableAction() {
		super();
		setBtnName("Õ£”√");
		setCode("disable");
	}
	
	@Override
	protected boolean isActionEnable() {
		
		int rowno = editor.getBillCardPanel().getBillTable().getSelectedRow();
		
		Object exeresult = editor.getBillCardPanel().getBodyValueAt(rowno, "exeresult");
		if (exeresult ==null) {
			return false;
		}
		if ("Õ£”√".equals(exeresult.toString())) {
			return false;
		}
		return true;
	}
	@Override
	public void doAction(ActionEvent e) throws Exception {
		
		Object obj = model.getSelectedData();
		if(obj==null){
			return ;
		}
		
		int[] rowno = editor.getBillCardPanel().getBillTable().getSelectedRows();
		
		if(rowno.length<=0){
			return;
		}
		
		AggMgrInfoVO aggvo = (AggMgrInfoVO) obj;
		MgrInfoVO vo = aggvo.getParentVO();
		
		AbstractETLTask task = DefaultETLTask.getInstance();
		SimpleDSMgr local = new SimpleDSMgr();
		SimpleDSMgr remote = new SimpleDSMgr();
		
		String srcname = vo.getSrcname();
		String srcip = vo.getScrip();
		String srcuname = vo.getSrcusername();
		String srcpwd = vo.getSrcpassword();
		String srcport = vo.getSrcport();
		
		String tarname = vo.getTarname();
		String tarip = vo.getTarip();
		String taruname = vo.getTarusername();
		String tarpwd = vo.getTarpassword();
		String tarport = vo.getTarport();
		
		if(local.conns.size()<=0||remote.conns.size()<=0){
			if(CommonUtils.isNotEmpty(srcname)&&CommonUtils.isNotEmpty(srcip)&&CommonUtils.isNotEmpty(srcuname)&&
					CommonUtils.isNotEmpty(srcpwd)&&CommonUtils.isNotEmpty(srcport)){
				local.setInitSize(2);
				local.initDB(vo.getSrcname(), vo.getScrip(), vo.getSrcusername(), vo.getSrcpassword(), vo.getSrcport());
				local.init();
			}
			
			if(CommonUtils.isNotEmpty(tarname)&&CommonUtils.isNotEmpty(tarip)&&CommonUtils.isNotEmpty(taruname)&&
					CommonUtils.isNotEmpty(tarpwd)&&CommonUtils.isNotEmpty(tarport)){
				remote.setInitSize(2);
				remote.initDB(vo.getTarname(), vo.getTarip(), vo.getTarusername(), vo.getTarpassword(), vo.getTarport());
				remote.init();
			}
		}
		
		MgrItemVO[] vos = (MgrItemVO[]) aggvo.getAllChildrenVO();
		if(vos.length<=0){
			return;
		}
		String tableName = null;
		for(int i=0;i<rowno.length;i++){
			if("Õ£”√".equals(vos[rowno[i]].getExeresult())){
				continue;
			}
			tableName = (String) editor.getBillCardPanel().getBillTable().getValueAt(rowno[i], 0);
			
			if(remote.conns.size()>0){
				if("º‡øÿ".equals(vos[rowno[i]].getExeresult())){
					task.enableTrigger(remote, tableName , 3);
				}else{
					task.enableTrigger(remote, tableName , 0);
				}
			}
			if(local.conns.size()>0){
				if("º‡øÿ".equals(vos[rowno[i]].getExeresult())){
					task.enableTrigger(local,  tableName , 3);
				}else{
					task.enableTrigger(local, tableName , 0);
				}
			}
			vos[rowno[i]].setExeresult("Õ£”√");
			service.update(new SuperVO[]{vos[rowno[i]]});
		}
		remote.realRelease();
		local.realRelease();
		VOUtil.refresh(model);
		
	}

	public BillManageModel getModel() {
		return model;
	}
	public void setModel(BillManageModel model) {
		this.model = model;
		model.addAppEventListener(this);
	}
	
	public ShowUpableBillForm getEditor() {
		return editor;
	}
	public void setEditor(ShowUpableBillForm editor) {
		this.editor = editor;
	}

	@Override
	public boolean isActionVisible() {
		return isActionEnable();
	}
}
