package cn.gaily.bill.billtree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillItemHyperlinkEvent;
import nc.ui.pub.bill.BillItemHyperlinkListener;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.components.AutoShowUpEventSource;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.components.IAutoShowUpEventListener;
import nc.ui.uif2.components.ITabbedPaneAwareComponent;
import nc.ui.uif2.components.ITabbedPaneAwareComponentListener;
import nc.ui.uif2.components.TabbedPaneAwareCompnonetDelegate;
import nc.ui.uif2.editor.BillTreeView;
import nc.ui.uif2.model.AppEventConst;

public class ListTreeView extends BillTreeView implements IAutoShowUpComponent, ITabbedPaneAwareComponent,BillItemHyperlinkListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7403211857210639288L;

	private ITabbedPaneAwareComponent tabbedPaneAwareComponent;
	
	private IAutoShowUpComponent autoShowUpComponent;
	
	public ListTreeView() {
		autoShowUpComponent = new AutoShowUpEventSource(this);
		tabbedPaneAwareComponent = new TabbedPaneAwareCompnonetDelegate();
	}
	
	@Override
	public void initUI() {
		super.initUI();
		setTreeMode(BillTreeView.COLUMNTREETABLEMODE);
		setTreeColumnName("id");
		BillItem codeItem = getBillItem("id");
		codeItem.setListHyperlink(true);
		codeItem.addBillItemHyperlinkListener(this);		
	}
	
	@Override
	public void hyperlink(BillItemHyperlinkEvent event) {
		AppEvent e = new AppEvent(AppEventConst.SHOW_EDITOR,getModel(),null);
		getModel().fireEvent(e);
	}
	
	private BillItem getBillItem(String itemKey){
		return getBillListPanel().getHeadItem(itemKey);
	}
	
	public void setAutoShowUpEventListener(IAutoShowUpEventListener l) {
		autoShowUpComponent.setAutoShowUpEventListener(l);
	}

	public void showMeUp() {
		autoShowUpComponent.showMeUp();
	}

	public void addTabbedPaneAwareComponentListener(ITabbedPaneAwareComponentListener l) {
		tabbedPaneAwareComponent.addTabbedPaneAwareComponentListener(l);
	}

	public boolean canBeHidden() {
		return true;
	}

	public boolean isComponentVisible() {
		return tabbedPaneAwareComponent.isComponentVisible();
	}

	public void setComponentVisible(boolean visible) {
		tabbedPaneAwareComponent.setComponentVisible(visible);
	}

	@Override
	public void handleEvent(AppEvent event) {
		super.handleEvent(event);
		billListPanel.getParentListPanel().getTable().removeMouseListener(handler);
		billListPanel.getParentListPanel().getTable().addMouseListener(handler);

//		if (event.getType() == OrgUnitAppEventConst.SHOW_ORGTREELIST) {
//			showMeUp();
//		} else if(AppEventConst.MODEL_INITIALIZED.equals(event.getType())) {
//			getBillListPanel().getParentListPanel().expandAllTree();
//		}
	}
	MouseHandler handler = new MouseHandler();
	class MouseHandler extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()>=2) {
				if(0 == billListPanel.getParentListPanel().getTable().columnAtPoint(e.getPoint())) {
				}
				else {
					AppEvent event = new AppEvent(AppEventConst.SHOW_EDITOR, this, null);
					getModel().fireEvent(event);
				}
			}
		}
	}
	
}
