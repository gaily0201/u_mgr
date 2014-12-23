package cn.gaily.bill.billtree;

import nc.ui.uif2.AppEventListener;
import nc.ui.uif2.components.AutoShowUpEventSource;
import nc.ui.uif2.components.IAutoShowUpComponent;
import nc.ui.uif2.components.IAutoShowUpEventListener;
import nc.ui.uif2.components.ITabbedPaneAwareComponent;
import nc.ui.uif2.components.ITabbedPaneAwareComponentListener;
import nc.ui.uif2.components.TabbedPaneAwareCompnonetDelegate;
import nc.ui.uif2.editor.BillForm;

public class ListBillForm extends BillForm implements IAutoShowUpComponent, ITabbedPaneAwareComponent, AppEventListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3477606094367986973L;

	private IAutoShowUpComponent autoShowUpComponent;

	private ITabbedPaneAwareComponent tabbedPaneAwareComponent;
	
	
	public ListBillForm(){
		autoShowUpComponent = new AutoShowUpEventSource(this);
		tabbedPaneAwareComponent = new TabbedPaneAwareCompnonetDelegate();
	}
	
	public boolean canBeHidden() {
		return tabbedPaneAwareComponent.canBeHidden();
	}

	public boolean isComponentVisible() {
		return tabbedPaneAwareComponent.isComponentVisible();
	}


	@Override
	public void setComponentVisible(boolean visible) {
		tabbedPaneAwareComponent.setComponentVisible(visible);
	}

	@Override
	public void addTabbedPaneAwareComponentListener(ITabbedPaneAwareComponentListener l) {
		tabbedPaneAwareComponent.addTabbedPaneAwareComponentListener(l);
	}

	@Override
	public void setAutoShowUpEventListener(IAutoShowUpEventListener l) {
		autoShowUpComponent.setAutoShowUpEventListener(l);
	}

	@Override
	public void showMeUp() {
		autoShowUpComponent.showMeUp();
	}

	public IAutoShowUpComponent getAutoShowUpComponent() {
		return autoShowUpComponent;
	}

	public void setAutoShowUpComponent(IAutoShowUpComponent autoShowUpComponent) {
		this.autoShowUpComponent = autoShowUpComponent;
	}

	public ITabbedPaneAwareComponent getTabbedPaneAwareComponent() {
		return tabbedPaneAwareComponent;
	}

	public void setTabbedPaneAwareComponent(
			ITabbedPaneAwareComponent tabbedPaneAwareComponent) {
		this.tabbedPaneAwareComponent = tabbedPaneAwareComponent;
	}

	
}
