package cn.gaily.mgr.etl.ui.panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.list.ListBillItemHyperlinkEvent;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.model.IAppModelEx;
import nc.ui.pubapp.uif2app.view.BillListView;
import nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.vo.pub.bill.BillTabVO;
import cn.gaily.mgr.etl.AggMgrInfoVO;

public class MouseClickShowPanelMediatorWrapper extends MouseClickShowPanelMediator {

	
	
	class ListHyperLinkListener implements IAppEventHandler<ListBillItemHyperlinkEvent> {

		@Override
		public void handleAppEvent(ListBillItemHyperlinkEvent e) {
			// 配置了多个MouseClickShowPanelMediator时，会多次进入此方法，需要加上事件源的比对，避免调用覆盖
			if (e.getItem().getKey().equals(MouseClickShowPanelMediatorWrapper.this.getHyperLinkColumn())
					&& e.getBillListPanel() == MouseClickShowPanelMediatorWrapper.this.getListView().getBillListPanel()) {
				MouseClickShowPanelMediatorWrapper.this.showUpComponent.showMeUp();
				MouseClickShowPanelMediatorWrapper.this.setCardSelectedTabedPaneFromList();
				MouseClickShowPanelMediatorWrapper.this.showSuccessInfo();
				refresh(1);
			}
		}
	}

	class MouseListenerHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() > 1) {
				MouseClickShowPanelMediatorWrapper.this.showUpComponent.showMeUp();
				MouseClickShowPanelMediatorWrapper.this.setCardSelectedTabedPaneFromList();
				MouseClickShowPanelMediatorWrapper.this.showSuccessInfo();
				refresh(1);
			}
		}
	}
	class BMouseListenerHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1){
				refresh(4);
			}else if (e.getClickCount() > 1) {
				MouseClickShowPanelMediatorWrapper.this.showUpComponent.showMeUp();
				MouseClickShowPanelMediatorWrapper.this.setCardSelectedTabedPaneFromList();
				MouseClickShowPanelMediatorWrapper.this.showSuccessInfo();
				refresh(2);
			}
		}
	}
	
	class LBMouseListenerHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() > 1) {
				MouseClickShowPanelMediatorWrapper.this.showSuccessInfo();
				refresh(3);
			}
		}
	}

	// 设置卡片界面表体选中页签为列表界面表体选中页签
	protected void setCardSelectedTabedPaneFromList() {
		int tabIndex = listView.getBillListPanel().getBodyTabbedPane().getSelectedIndex();
		if (showUpComponent instanceof nc.ui.uif2.editor.BillForm) {
			((nc.ui.uif2.editor.BillForm) showUpComponent).getBillCardPanel().getBodyTabbedPane().setSelectedIndex(tabIndex);
		}
	}

	public void refresh(int type){
		BillTabVO vo = new BillTabVO();
		vo.setTabcode("log");
		vo.setTabname("日志信息");
		CopyOfSynLogPanel pane = (CopyOfSynLogPanel) eeditor.getBillCardPanel().getTabbedPane(1).getScrollPane(vo);
		if(type==1){
			pane.onQuerySynLog((AggMgrInfoVO)mmodel.getSelectedData());
		}else if(type==2){
			int tabIndex = listView.getBillListPanel().getBodyTable().getSelectedRow(); //获取表体选中行
			String tabName =(String) eeditor.getBillCardPanel().getBillModel().getBodyRowValueByMetaData(tabIndex).get("tablename"); //获取选中行值
			pane.onQuerySynLog(tabName);
			eeditor.getBillCardPanel().getBodyTabbedPane().setSelectedIndex(1); //进入列表界面后显示日志信息列表
		}else if(type==3){
			int tabIndex = eeditor.getBillCardPanel().getBillTable().getSelectedRow();
			String tabName =(String) eeditor.getBillCardPanel().getBillModel().getBodyRowValueByMetaData(tabIndex).get("tablename"); //获取选中行值
			pane.onQuerySynLog(tabName);
			eeditor.getBillCardPanel().getBodyTabbedPane().setSelectedIndex(1); //进入列表界面后显示日志信息列表
		}else if(type==4){
			int tabIndex = listView.getBillListPanel().getBodyTable().getSelectedRow(); //获取表体选中行
			String tabName = (String)listView.getBillListPanel().getBodyTable().getValueAt(tabIndex, 0);
			MouseClickShowPanelMediatorWrapper.this.logPanel.init(tabName);
		}else{
			return;
		}
	}
	
	private BillManageModel mmodel;
	
	private ShowUpableBillForm eeditor;
	
	IAutoShowUpComponent showUpComponent;

	private String hyperLinkColumn;

	private BillListView listView;
	
	private ListSynLogPanel logPanel;
	
	public ListSynLogPanel getLogPanel() {
		return logPanel;
	}
	public void setLogPanel(ListSynLogPanel logPanel) {
		this.logPanel = logPanel;
	}
	
	public String getHyperLinkColumn() {
		return this.hyperLinkColumn;
	}

	public BillListView getListView() {
		return this.listView;
	}

	public IAutoShowUpComponent getShowUpComponent() {
		return this.showUpComponent;
	}

	public void setHyperLinkColumn(String hyperLinkColumn) {
		this.hyperLinkColumn = hyperLinkColumn;
	}

	public void setListView(BillListView listView) {
		this.listView = listView;
		this.match();
	}

	public void setShowUpComponent(IAutoShowUpComponent showUpComponent) {
		this.showUpComponent = showUpComponent;
		this.match();
	}

	/**
	 * 切换界面时清空状态栏提示信息
	 */
	void showSuccessInfo() {
		ShowStatusBarMsgUtil.showStatusBarMsg(null, this.listView.getModel()
				.getContext());
	}

	private void match() {
		if (null == this.listView || null == this.showUpComponent) {
			return;
		}
		MouseListenerHandler l = new MouseListenerHandler();
		BMouseListenerHandler ll = new BMouseListenerHandler();
		LBMouseListenerHandler lll = new LBMouseListenerHandler();
		this.listView.getBillListPanel().getHeadTable().addMouseListener(l);
		this.listView.getBillListPanel().getBodyTable().addMouseListener(ll);
//		this.eeditor.getBillCardPanel().getBodyPanel("SyntableBodyVO").addMouseListener(lll);
		((IAppModelEx) this.listView.getModel()).addAppEventListener(ListBillItemHyperlinkEvent.class, new ListHyperLinkListener());
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
	
}
