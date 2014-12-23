package cn.gaily.bill.singlebilltree;
import nc.ui.bd.ref.AbstractRefTreeModel;

public class ListTreeRefModel extends AbstractRefTreeModel{
	 public ListTreeRefModel() {
		    super();
		    this.reset();
		  }
	  @Override
	  public void reset() {
	    this.setFieldCode(new String[] {"value", "id"});
	    this.setFieldName(new String[] {"Ãû³Æ","±àÂë"});
	    this.setHiddenFieldCode(new String[] { "pk", "pid" });
	    this.setPkFieldCode("pk");
	    this.setRefCodeField("id");
	    this.setRefNameField("value");
	    this.setTableName("singlebill");
	    this.setFatherField("pid");
	    this.setChildField("pk");
	  }
	  
	  @Override
	    protected String getEnvWherePart() {
	    	String wherepart=super.getWherePart();
	    	if(null==wherepart||"".equals(wherepart)){
	    		wherepart="dr = '0'";
	    	}else{
	    		wherepart=" and dr='0'";
	    	}
	    return wherepart;
	    }
	  
}