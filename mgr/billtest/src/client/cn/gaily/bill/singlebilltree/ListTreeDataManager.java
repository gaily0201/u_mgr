package cn.gaily.bill.singlebilltree;

import nc.ui.pubapp.uif2app.model.BaseBillModelDataManager;

public class ListTreeDataManager extends BaseBillModelDataManager {

	    @Override
	    public void initModel() {
		    String sqlwhere = " where 1=1 ";
		    super.initModelBySqlWhere(sqlwhere);
	    }

}