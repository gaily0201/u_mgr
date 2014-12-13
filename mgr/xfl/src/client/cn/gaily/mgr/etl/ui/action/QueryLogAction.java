package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;
import nc.ui.uap.sf.SFClientUtil2;
import nc.ui.uif2.NCAction;

public class QueryLogAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5298745020266131492L;

	public QueryLogAction(){
		setBtnName("运行日志");
		setCode("showlog");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		SFClientUtil2.openFuncNodeInTabbedPane(null, "10200PATL");
	}

}
