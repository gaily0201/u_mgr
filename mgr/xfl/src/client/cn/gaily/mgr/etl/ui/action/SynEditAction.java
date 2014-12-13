package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;
import nc.ui.pubapp.pub.power.PowerCheckUtils;
import nc.ui.pubapp.uif2app.actions.EditAction;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.vo.pubapp.pub.power.PowerActionEnum;

public class SynEditAction extends EditAction {

  private static final long serialVersionUID = 1L;
  
  private String billType;
  
  private String billCodeName;
  
  private boolean powercheck;
  
  private ShowUpableBillForm editor;
  
  @Override
  public void doAction(ActionEvent e) throws Exception {
    if (this.isPowercheck()) {
      IBill bill = (IBill) this.getModel().getSelectedData();
      PowerCheckUtils.checkHasPermission(new IBill[] {
        bill
      }, this.getBillType(), PowerActionEnum.EDIT.getActioncode(),
          this.getBillCodeName());
    }
    editor.getBillCardPanel().getBillModel().getItemByKey("exeresult").setEdit(false);
    super.doAction(e);
  }
  
  public String getBillType() {
    return this.billType;
  }

  public void setBillType(String billType) {
    this.billType = billType;
  }

  public String getBillCodeName() {
    return this.billCodeName;
  }

  public void setBillCodeName(String billCodeName) {
    this.billCodeName = billCodeName;
  }

  public boolean isPowercheck() {
    return this.powercheck;
  }

  public void setPowercheck(boolean powercheck) {
    this.powercheck = powercheck;
  }

  public ShowUpableBillForm getEditor() {
		return editor;
	}
	public void setEditor(ShowUpableBillForm editor) {
		this.editor = editor;
	}
}
