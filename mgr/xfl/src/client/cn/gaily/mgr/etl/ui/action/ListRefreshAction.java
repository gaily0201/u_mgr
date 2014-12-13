package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;

import nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction;
import cn.gaily.mgr.etl.ui.panel.ListSynLogPanel;

public class ListRefreshAction extends DefaultRefreshAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1466514856531050874L;

	private ListSynLogPanel logPanel;
	
	
	public ListRefreshAction(){
		setBtnName("Ë¢ÐÂ");
		setCode("lrefresh");
	}
	
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		super.doAction(e);
		logPanel.init();
	}
	
	@Override
	protected boolean isActionEnable() {
		return true;
	}
	
	public ListSynLogPanel getLogPanel() {
		return logPanel;
	}
	public void setLogPanel(ListSynLogPanel logPanel) {
		this.logPanel = logPanel;
	}
	
}
