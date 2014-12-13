package cn.gaily.mgr.etl.ui.action;


import java.awt.event.ActionEvent;

import nc.bs.framework.common.NCLocator;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.NCAction;
import cn.gaily.base.ui.component.IActionVisible;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.MgrInfoVO;
import cn.gaily.mgr.etl.itf.IMgrXflService;

public class SynHistoryAction extends NCAction implements IActionVisible{

	IMgrXflService service = NCLocator.getInstance().lookup(IMgrXflService.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -7221231765052092857L;

	private BillManageModel model;

	private boolean actionEnable = true;
	
	Thread t1 = null;
	
	public SynHistoryAction(){
		setBtnName("����ͬ��");
		setCode("synHistory");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		int isContinue = MessageDialog.showYesNoDlg(null, "��ʾ", "�������ϴ�ͬ��ʱ��ϳ����Ƿ������");
		if(isContinue==MessageDialog.ID_NO||isContinue==MessageDialog.ID_CANCEL){
			return;
		}
		
		final Object obj = model.getSelectedData();
		if(obj==null){
			MessageDialog.showHintDlg(null, "��ʾ", "δѡ������");
			return;
		}
		
		t1 = new Thread(new Runnable(){
			public void run(){
				AggMgrInfoVO agg = (AggMgrInfoVO) obj;
				MgrInfoVO pvo= (MgrInfoVO) agg.getParent();
				service.synHistory(pvo);
			}
		});
		
		if(t1!=null){
			t1.start();
		}
		
//		new SwingWorker<Void, Void>() {
//			@Override
//			protected Void doInBackground() throws Exception {
//				IProgressMonitor progressMonitor = NCProgresses.createDialogProgressMonitor(null);
//				progressMonitor.beginTask("����ͬ������...", IProgressMonitor.UNKNOWN_TOTAL_TASK);
//				progressMonitor.setProcessInfo("����ͬ�����ݣ����Ժ�.....");
//				actionEnable = false;
//				AggMgrInfoVO agg = (AggMgrInfoVO) obj;
//				MgrInfoVO pvo= (MgrInfoVO) agg.getParent();
//				service.synHistory(pvo);
//				actionEnable = true;
//				progressMonitor.setProcessInfo("�������ͬ����");
//				MessageDialog.showHintDlg(null, "��ʾ", "�������ͬ��");
//				progressMonitor.done();
//				return null;
//			}
//		}.execute();
	}
	
	@Override
	public boolean isActionEnable() {
		if(t1==null){
			setBtnName("����ͬ��");
			return true;
		}
		if(t1.isAlive()){
			setBtnName("����ͬ��");
			return false;
		}
		setBtnName("����ͬ��");
		return true;
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
