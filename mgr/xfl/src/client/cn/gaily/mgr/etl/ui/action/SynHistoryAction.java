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
		setBtnName("差异同步");
		setCode("synHistory");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		int isContinue = MessageDialog.showYesNoDlg(null, "提示", "数据量较大同步时间较长，是否继续？");
		if(isContinue==MessageDialog.ID_NO||isContinue==MessageDialog.ID_CANCEL){
			return;
		}
		
		final Object obj = model.getSelectedData();
		if(obj==null){
			MessageDialog.showHintDlg(null, "提示", "未选中数据");
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
//				progressMonitor.beginTask("正在同步数据...", IProgressMonitor.UNKNOWN_TOTAL_TASK);
//				progressMonitor.setProcessInfo("正在同步数据，请稍候.....");
//				actionEnable = false;
//				AggMgrInfoVO agg = (AggMgrInfoVO) obj;
//				MgrInfoVO pvo= (MgrInfoVO) agg.getParent();
//				service.synHistory(pvo);
//				actionEnable = true;
//				progressMonitor.setProcessInfo("完成数据同步！");
//				MessageDialog.showHintDlg(null, "提示", "完成数据同步");
//				progressMonitor.done();
//				return null;
//			}
//		}.execute();
	}
	
	@Override
	public boolean isActionEnable() {
		if(t1==null){
			setBtnName("差异同步");
			return true;
		}
		if(t1.isAlive()){
			setBtnName("正在同步");
			return false;
		}
		setBtnName("差异同步");
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
