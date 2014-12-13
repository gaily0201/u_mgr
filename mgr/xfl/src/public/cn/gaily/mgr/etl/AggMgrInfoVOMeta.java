package cn.gaily.mgr.etl;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggMgrInfoVOMeta extends AbstractBillMeta {
  public AggMgrInfoVOMeta() {
    this.init();
  }
  private void init() {
    this.setParent(cn.gaily.mgr.etl.MgrInfoVO.class);
    this.addChildren(cn.gaily.mgr.etl.MgrItemVO.class);
  }
}