package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;
import nc.bs.framework.common.NCLocator;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.uif2.NCAction;
import nc.vo.pub.SuperVO;
import cn.gaily.base.service.IBaseService;
import cn.gaily.base.ui.component.IActionVisible;
import cn.gaily.base.ui.util.VOUtil;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.MgrInfoVO;
import cn.gaily.mgr.etl.MgrItemVO;
import cn.gaily.pub.trigger.AbstractETLTask;
import cn.gaily.pub.trigger.DefaultETLTask;
import cn.gaily.pub.util.CommonUtils;
import cn.gaily.simplejdbc.SimpleDSMgr;

public class EnableAction extends NCAction implements IActionVisible{

	
	private BillManageModel model;
	private ShowUpableBillForm editor;
	
	IBaseService service = NCLocator.getInstance().lookup(IBaseService.class);
	/**
	 * 启用按钮
	 */
	private static final long serialVersionUID = -3685400631563450934L;
	public EnableAction() {
		super();
		setBtnName("启用");
		setCode("enable");
	}
	
	@Override
	protected boolean isActionEnable() {
		
		int rowno = editor.getBillCardPanel().getBillTable().getSelectedRow();
		
		Object exeresult = editor.getBillCardPanel().getBodyValueAt(rowno, "exeresult");
		
		if (exeresult ==null) {
			return false;
		}
		if ("启用".equals(exeresult.toString())) {
			return false;
		}

		Object obj = model.getSelectedData();
		if(obj==null){
			return false;
		}
		
		AggMgrInfoVO aggvo = (AggMgrInfoVO) obj;
		MgrInfoVO vo = aggvo.getParentVO();
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
		
		if(CommonUtils.isEmpty(srcname)&&CommonUtils.isEmpty(srcip)&&CommonUtils.isEmpty(srcuname)&&
				CommonUtils.isEmpty(srcpwd)&&CommonUtils.isEmpty(srcport)){
			return false;
		}
		if(CommonUtils.isEmpty(tarname)&&CommonUtils.isEmpty(tarip)&&CommonUtils.isEmpty(taruname)&&
				CommonUtils.isEmpty(tarpwd)&&CommonUtils.isEmpty(tarport)){
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
			if("启用".equals(vos[rowno[i]].getExeresult())){
				continue;
			}
			if("监控".equals(vos[rowno[i]].getExeresult())){
				MessageDialog.showHintDlg(null, "提示", "监控状态下只能停用!");
				continue;
			}
			tableName = (String) editor.getBillCardPanel().getBillTable().getValueAt(rowno[i], 0);
			if(remote.conns.size()>0){
				task.enableTrigger(remote, tableName , 1);
			}
			if(local.conns.size()>0){
				task.enableTrigger(local,  tableName , 1);
			}
			vos[rowno[i]].setExeresult("启用");
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
