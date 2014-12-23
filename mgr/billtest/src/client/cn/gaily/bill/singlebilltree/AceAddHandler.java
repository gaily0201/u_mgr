package cn.gaily.bill.singlebilltree;

import nc.ui.pub.bill.BillItem;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.billform.AddEvent;
import nc.ui.uif2.UIState;
import nc.vo.mgr.singlebill.SingleBill;

public class AceAddHandler implements IAppEventHandler<AddEvent> {

	@Override
	public void handleAppEvent(AddEvent e) {
		initParentCode(e);
	}

	public void initParentCode(AddEvent e) {
		e.getBillForm().getBillCardPanel().addLine();
		BillItem parentCode = e.getBillForm().getBillCardPanel().getHeadItem("pid");
		if (e.getBillForm().getModel().getSelectedData() != null) {
			SingleBill vo = (SingleBill) e.getBillForm().getModel().getSelectedData();
			parentCode.setValue(vo.getPrimaryKey());
			parentCode.setEdit(false);
		} else {
			parentCode.setEdit(true);
		}
	}
}
