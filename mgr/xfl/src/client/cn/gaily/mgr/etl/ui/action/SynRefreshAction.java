package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;

import nc.ui.pubapp.uif2app.actions.RefreshSingleAction;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.vo.pub.bill.BillTabVO;
import cn.gaily.base.ui.component.IActionVisible;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.ui.panel.CopyOfSynLogPanel;

public class SynRefreshAction extends RefreshSingleAction implements IActionVisible {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3136470809499754976L;
	private BillManageModel mmodel;
	private ShowUpableBillForm eeditor;
	
	public SynRefreshAction(){
		setBtnName("刷新");
		setCode("refresh");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		super.doAction(e);
		BillTabVO vo = new BillTabVO();
		vo.setTabcode("log");
		vo.setTabname("日志信息");
		CopyOfSynLogPanel pane = (CopyOfSynLogPanel) eeditor.getBillCardPanel().getTabbedPane(1).getScrollPane(vo);
		pane.onQuerySynLog((AggMgrInfoVO)mmodel.getSelectedData());
		eeditor.getBillCardPanel().getTabbedPane(1).setSelectedIndex(1);
	}

	public BillManageModel getMmodel() {
		return mmodel;
	}

	public void setMmodel(BillManageModel mmodel) {
		this.mmodel = mmodel;
	}

	public ShowUpableBillForm getEeditor() {
		return eeditor;
	}

	public void setEeditor(ShowUpableBillForm eeditor) {
		this.eeditor = eeditor;
	}

	@Override
	public boolean isActionVisible() {
		return isActionEnable();
	}
	
}
