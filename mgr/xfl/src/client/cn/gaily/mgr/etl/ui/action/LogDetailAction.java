package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;

import nc.ui.uap.sf.SFClientUtil2;
import nc.ui.uif2.NCAction;

public class LogDetailAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8559519834248462614L;

	public LogDetailAction(){
		setBtnName("œÍœ∏»’÷æ");
		setCode("logdetail");
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		SFClientUtil2.openFuncNodeInTabbedPane(null, "AS7008", null, null, true);
	}

}
