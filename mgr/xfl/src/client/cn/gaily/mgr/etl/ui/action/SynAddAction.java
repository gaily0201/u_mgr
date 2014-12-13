package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;

import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.UIState;

public class SynAddAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 851904462114654401L;

	
	private BillManageModel model;
	
	public SynAddAction(){
		this.setBtnName("ÐÂÔö");
		this.setCode("add");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		getModel().setUiState(UIState.ADD);
	}

	public BillManageModel getModel() {
		return model;
	}
	public void setModel(BillManageModel model) {
		this.model = model;
		model.addAppEventListener(this);
	}
}
