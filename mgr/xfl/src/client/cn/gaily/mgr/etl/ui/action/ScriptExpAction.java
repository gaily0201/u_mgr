package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.SwingWorker;
import javax.swing.filechooser.FileFilter;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIFileChooser;
import nc.ui.pub.beans.progress.IProgressMonitor;
import nc.ui.pub.beans.progress.NCProgresses;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.uif2.NCAction;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.MgrInfoVO;
import cn.gaily.mgr.etl.MgrItemVO;
import cn.gaily.pub.script.ScriptExporter;
import cn.gaily.pub.util.CommonUtils;
import cn.gaily.simplejdbc.SimpleDSMgr;

/**
 * <p>Title: ScriptExpAction</P>
 * <p>Description: 监控表数据导出</p>
 * <p>Copyright: 用友政务软件有限公司 Copyright (c) 2014</p>
 * @author xiaoh
 * @version 1.0
 * @since 2014-12-3
 */
public class ScriptExpAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2766033706414560466L;
	private BillManageModel model;
	private ShowUpableBillForm editor;
	
	public ScriptExpAction(){
		setBtnName("导出数据");
		setCode("exp");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		
		int isContinue = MessageDialog.showYesNoDlg(null, "提示", "导出完成后临时表数据将被删除，请慎重操作，你确定继续吗？");
		if(isContinue==MessageDialog.ID_NO||isContinue==MessageDialog.ID_CANCEL){
			return;
		}
		final SimpleDSMgr local = new SimpleDSMgr();
		
		AggMgrInfoVO agg = (AggMgrInfoVO) model.getSelectedData();
		MgrInfoVO vo = agg.getParentVO();
		String srcname = vo.getSrcname();
		String srcip = vo.getScrip();
		String srcuname = vo.getSrcusername();
		String srcpwd = vo.getSrcpassword();
		String srcport = vo.getSrcport();
		if(local.conns.size()<=0){
			if(CommonUtils.isNotEmpty(srcname)&&CommonUtils.isNotEmpty(srcip)&&CommonUtils.isNotEmpty(srcuname)&&
					CommonUtils.isNotEmpty(srcpwd)&&CommonUtils.isNotEmpty(srcport)){
				local.setInitSize(2);
				local.initDB(vo.getSrcname(), vo.getScrip(), vo.getSrcusername(), vo.getSrcpassword(), vo.getSrcport());
				local.init();
			}
		}
		
		final MgrItemVO[] vos = (MgrItemVO[]) agg.getAllChildrenVO();
		if(vos.length<0){
			return;
		}
		
		
		
		UIFileChooser c = new UIFileChooser();
		c.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return ".sql";
			}
			@Override
			public boolean accept(File f) {
				if(f.getName().endsWith(".sql")){
					return true;
				}
				return false;
			}
		});
		int result = c.showSaveDialog(null);
		File f = null;
		if(result==UIFileChooser.APPROVE_OPTION){
			f = c.getSelectedFile();
		}
		if(f==null){
			return ;
		}
		if(!f.getName().contains(".")){
			f = new File(f.getPath()+".sql");
		}
		if(!f.exists()){
			f.createNewFile();
		}
		
		final ScriptExporter exporter = new ScriptExporter();
		
		final File myfile = f;
		
		new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				IProgressMonitor progressMonitor = NCProgresses.createDialogProgressMonitor(null);
				progressMonitor.beginTask("正在导出数据...", IProgressMonitor.UNKNOWN_TOTAL_TASK);
				progressMonitor.setProcessInfo("正在导出数据，请稍候.....");
				for(MgrItemVO v: vos){
					if("监控".equals(v.getExeresult())){
						exporter.export(local, myfile.getPath(), false, v.getTablename());
					}
				}
				local.realRelease();
				progressMonitor.setProcessInfo("完成数据导出！");
				MessageDialog.showHintDlg(null, "提示", "完成数据导出");
				progressMonitor.done();
				return null;
			}
		}.execute();
		
		
		
	}

	
	@Override
	protected boolean isActionEnable() { //TODO 暂不提供该导出功能
//		AggSynInfoVO agg = (AggSynInfoVO) model.getSelectedData();
//		if(agg==null){
//			return false;
//		}
//		SyntableBodyVO[] vos = (SyntableBodyVO[]) agg.getAllChildrenVO();
//		
		boolean enable = false;
//		for(SyntableBodyVO vo: vos){
//			if("监控".equalsIgnoreCase(vo.getExeresult())){
//				enable = true;
//				break;
//			}else{
//				continue;
//			}
//		}
		return enable;
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
	
}
