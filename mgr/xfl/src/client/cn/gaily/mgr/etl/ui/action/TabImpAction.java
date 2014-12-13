package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileFilter;
import nc.bs.framework.common.NCLocator;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIFileChooser;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.UIState;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.MgrItemVO;
import cn.gaily.mgr.etl.itf.IMgrXflService;
import cn.gaily.pub.util.ExcelUtil;

public class TabImpAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2562800117450788137L;
	IMgrXflService service = NCLocator.getInstance().lookup(IMgrXflService.class);
	
	private BillManageModel model;
	private ShowUpableBillForm editor;
	
	public TabImpAction(){
		setBtnName("导入表");
		setCode("imp");
	}
	@Override
	public void doAction(ActionEvent e) throws Exception {
		UIFileChooser c = new UIFileChooser();
		c.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return ".xls";
			}
			@Override
			public boolean accept(File f) {
				if(f.getName().endsWith(".xls")){
					return true;
				}
				return false;
			}
		});
		int result = c.showOpenDialog(null);
		File f = null;
		if(result==UIFileChooser.APPROVE_OPTION){
			f = c.getSelectedFile();
		}else{
			return;
		}
		if(!f.isFile()){
			return;
		}
		List<List<String>> list = ExcelUtil.doImport(f);
		List<String> tabs = new ArrayList<String>();
		List<String> tabList = list.get(0);
		if(tabList.size()<=0){
			return;
		}
		for(String tab: tabList){
			tabs.add(tab.trim().toUpperCase());
		}
		
		AggMgrInfoVO agg = (AggMgrInfoVO) model.getSelectedData();
		MgrItemVO[] vos = (MgrItemVO[]) agg.getChildrenVO();
		String t = null;
		List<String> exitsTabs = new ArrayList<String>();
		List<String> invalidTabs = new ArrayList<String>();
		if(vos!=null&&vos.length>0){
			for(MgrItemVO vo:vos){
				t = (String) vo.getAttributeValue("tablename");
				t = t.trim().toUpperCase();
				if(tabs.contains(t)){
					exitsTabs.add(t);
					tabs.remove(t);
				}
			}
		}
		
		List<String> validTabs  = service.checkTabs(tabs);
		for(String tab:tabs){
			if(!validTabs.contains(tab)){
				invalidTabs.add(tab);
			}
		}
		if(exitsTabs.size()==tabs.size()){
			MessageDialog.showHintDlg(null, "提示", "所有表都已存在，无需重复导入！");
			return;
		}
		model.setUiState(UIState.EDIT);
		String type = agg.getParentVO().getSyntype();
		for(int i=0;i<validTabs.size();i++){
			editor.getBillCardPanel().getBodyPanel().addLine();
			editor.getBillCardPanel().getBodyPanel().getTableModel().setValueAt(validTabs.get(i), vos.length+i, "tablename");
			editor.getBillCardPanel().getBodyPanel().getTableModel().setValueAt(type, vos.length+i, "syntype");
		}
		
		StringBuilder sb = new StringBuilder();
		if(!exitsTabs.isEmpty()){
			for(String v:exitsTabs){
				sb.append(v);
			}
			sb.append("已存在！");
			
		}
		if(!invalidTabs.isEmpty()){
			sb.append(invalidTabs.toArray().toString()).append("数据库中未找到该表！");
		}
		sb.append("导入完成！");
		
		MessageDialog.showHintDlg(null, "提示", sb.toString());
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
