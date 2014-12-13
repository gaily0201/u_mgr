package cn.gaily.mgr.etl;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;

@nc.vo.annotation.AggVoInfo(parentVO = "cn.gaily.mgr.etl.MgrInfoVO")
public class AggMgrInfoVO extends AbstractBill {

  @Override
  public IBillMeta getMetaData() {
    IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggMgrInfoVOMeta.class);
    return billMeta;
  }

  @Override
  public MgrInfoVO getParentVO() {
    return (MgrInfoVO) this.getParent();
  }
}