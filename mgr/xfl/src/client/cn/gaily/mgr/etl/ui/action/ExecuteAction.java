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
import cn.gaily.pub.trigger.TriggerManager;
import cn.gaily.pub.util.CommonUtils;
import cn.gaily.simplejdbc.SimpleDSMgr;

public class ExecuteAction extends NCAction implements IActionVisible{
	private static final long serialVersionUID = -4082703940167728523L;
	
	
	private BillManageModel model;
	private ShowUpableBillForm editor;
	
	
	IBaseService service = NCLocator.getInstance().lookup(IBaseService.class);
	
	public ExecuteAction() {
		super();
		setBtnName("��ʼ��");
		setCode("AS72Execute");
	}

	@Override
	protected boolean isActionEnable() {
		
		int rowno = editor.getBillCardPanel().getBillTable().getSelectedRow();
		
		Object exeresult = editor.getBillCardPanel().getBodyValueAt(rowno, "exeresult");
		
		if (exeresult ==null) {
			return true;
		}
		if ("".equals(exeresult.toString())) {
			return true;
		}

		return false;
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		SimpleDSMgr local = new SimpleDSMgr();
		SimpleDSMgr remote = new SimpleDSMgr();
		
		int isContinue = MessageDialog.showYesNoDlg(null, "��ʾ", "ִ�л�ɾ����ʱ���е����ݺ��������ɴ���������ȷ��������");
		if(isContinue==MessageDialog.ID_NO||isContinue==MessageDialog.ID_CANCEL){
			return;
		}
		
		Object obj = model.getSelectedData();
		if(obj==null){
			return ;
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
		
		/*1. ��������Դ*/
//		TaskExecutor.setRemote(remote);
//		TaskExecutor.setRemote(local);
		writeProp(vo.getPk(), remote, local);
		
		/*2. ��ʼ��ѡ���д�������Ϣ*/
		int[] rowno = editor.getBillCardPanel().getBillTable().getSelectedRows();
		
		if(rowno.length<=0){
			nc.vo.pubapp.pattern.exception.ExceptionUtils.marsh(new RuntimeException("��ѡ��һ�����ݣ�"));
			return;
		}
		
		MgrItemVO[] vos = (MgrItemVO[]) aggvo.getAllChildrenVO();
		if(vos.length<=0){
			return;
		}
		AbstractETLTask task = DefaultETLTask.getInstance();
		TriggerManager generator = new TriggerManager();
		String tableName = null;
		for(int i=0;i<rowno.length;i++){
//			if("����".equals(vos[rowno[i]].getExeresult())||"ͣ��".equals(vos[rowno[i]].getExeresult())){
//				continue;
//			}
			tableName = (String) editor.getBillCardPanel().getBillTable().getValueAt(rowno[i], 0);
			
			if(local.conns.size()>0){
				generator.setMgr(local);
				generator.generate(tableName, null, true);
				task.enableTrigger(local, tableName, 0);
			}
			if(remote.conns.size()>0){
				generator.setMgr(remote);
				generator.generate(tableName, null, true);
				task.enableTrigger(remote, tableName, 0);
			}
			vos[rowno[i]].setExeresult("ͣ��");
			service.update(new SuperVO[]{vos[rowno[i]]});
		}
		remote.realRelease();
		local.realRelease();
		VOUtil.refresh(model);
		MessageDialog.showHintDlg(null, "��ʾ", "������ʱ��ʹ������ɹ���");
	}

	/**
	 * <p>�������ƣ�writeProp</p>
	 * <p>����������д�����ļ�</p>
	 * @param remotee
	 * @param locall
	 * @author xiaoh
	 * @since  2014-11-5
	 * <p> history 2014-11-5 xiaoh  ����   <p>
	 */
	private void writeProp(String fileName ,SimpleDSMgr remotee, SimpleDSMgr locall) {
		CommonUtils common = new CommonUtils();
		common.setPropFilepath(fileName, 1);
		common.setProperty(fileName, "remote.dbname", remotee.getDbName());
		common.setProperty(fileName, "remote.username", remotee.getUserName());
		common.setProperty(fileName, "remote.password", remotee.getPassword());
		common.setProperty(fileName, "remote.ip", remotee.getIp());
		common.setProperty(fileName, "remote.port", remotee.getPort());
		common.setProperty(fileName, "local.dbname", locall.getDbName());
		common.setProperty(fileName, "local.username", locall.getUserName());
		common.setProperty(fileName, "local.password", locall.getPassword());
		common.setProperty(fileName, "local.ip", locall.getIp());
		common.setProperty(fileName, "local.port", locall.getPort());
	}


	
	public ShowUpableBillForm getEditor() {
		return editor;
	}
	public void setEditor(ShowUpableBillForm editor) {
		this.editor = editor;
	}
	public BillManageModel getModel() {
		return model;
	}
	public void setModel(BillManageModel model) {
		this.model = model;
		model.addAppEventListener(this);
	}

	@Override
	public boolean isActionVisible() {
		return isActionEnable();
	}
}
