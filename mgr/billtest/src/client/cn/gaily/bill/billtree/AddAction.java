package cn.gaily.bill.billtree;

import java.awt.event.ActionEvent;

import nc.ui.pub.beans.UIRefPane;
import nc.ui.uif2.model.HierachicalDataAppModel;
import cn.gaily.bill.singlebilltree.ListTreeRefModel;


public class AddAction extends nc.ui.pubapp.uif2app.actions.AddAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9116557421581236648L;

	
	private HierachicalDataAppModel model;
	
	private ListBillForm editor;
	
	public AddAction(){
		setBtnName("ÐÂÔö");
		setCode("addaction");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		UIRefPane panel = (UIRefPane) editor.getBillCardPanel().getHeadItem("pid").getComponent();
		if(panel==null){
			super.doAction(e);
		}
		ListTreeRefModel model = (ListTreeRefModel) panel.m_refManage.getRefModel();
		model.reloadData();
		super.doAction(e);
	}
	
	@Override
	protected boolean isActionEnable() {
		return super.isActionEnable();
	}

	public HierachicalDataAppModel getModel() {
		return model;
	}

	public void setModel(HierachicalDataAppModel model) {
		this.model = model;
		model.addAppEventListener(this);
	}

	public ListBillForm getEditor() {
		return editor;
	}

	public void setEditor(ListBillForm editor) {
		this.editor = editor;
	}
	
	
	
	
}
