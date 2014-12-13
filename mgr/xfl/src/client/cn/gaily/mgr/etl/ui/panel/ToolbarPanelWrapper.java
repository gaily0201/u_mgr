package cn.gaily.mgr.etl.ui.panel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import nc.ui.pub.beans.ActionsBar.ActionsBarSeparator;
import nc.ui.pubapp.uif2app.actions.FileDocManageAction;
import nc.ui.pubapp.uif2app.actions.FirstLineAction;
import nc.ui.pubapp.uif2app.actions.LastLineAction;
import nc.ui.pubapp.uif2app.actions.NextLineAction;
import nc.ui.pubapp.uif2app.actions.PreLineAction;
import nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.model.AbstractUIAppModel;
import nc.ui.uif2.model.BillManageModel;


/**
 * <p>Title: ToolbarPanelWrapper</P>
 * <p>Description: 去除卡片界面"自由"，自由控制是否需要 附件按钮</p>
 * <p>Copyright: 用友政务软件有限公司 Copyright (c) 2014</p>
 * @author xiaoh
 * @version 1.0
 * @since 2014-12-4
 */
public class ToolbarPanelWrapper extends UECardLayoutToolbarPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8021805614190241619L;

	 private boolean needFileDocAction = true; //是否需要附件按钮，默认true, 不需要可在xml中注入该属性为false
		
		private FileDocManageAction docManageAction; 
		
		private FirstLineAction firstLineAction;

		private LastLineAction lastLineAction;

		private NextLineAction nextLineAction;

		private PreLineAction preLineAction;
		
		private String note;
		
		public ToolbarPanelWrapper(){
			 super();
			 this.initDefaultRightActions();
		}
		
		@Override
		public void handleEvent(AppEvent event) {
			super.handleEvent(event);
			if(note!=null){
				this.setRightText(note);
			}else{
				this.setRightText("");
			}
			
		}
		@Override
		public void setModel(AbstractUIAppModel model) {
			this.setActions(this.getDefaultRightActions());
			super.setModel(model);
			this.firstLineAction.setModel((BillManageModel) model);
			this.preLineAction.setModel((BillManageModel) model);
			this.nextLineAction.setModel((BillManageModel) model);
			this.lastLineAction.setModel((BillManageModel) model);
			if(needFileDocAction){
				 this.docManageAction.setModel(model);
			}
		}
		  
		  private void initDefaultRightActions() {
			    this.firstLineAction = new FirstLineAction();
			    this.firstLineAction.setEnabled(false);

			    this.preLineAction = new PreLineAction();
			    this.preLineAction.setEnabled(false);

			    this.nextLineAction = new NextLineAction();
			    this.nextLineAction.setEnabled(false);

			    this.lastLineAction = new LastLineAction();
			    this.lastLineAction.setEnabled(false);

			  }
		  
		private List<Action> getDefaultRightActions() {
		    List<Action> defaultActions = new ArrayList<Action>();
		    if(needFileDocAction){
		    	this.docManageAction = new FileDocManageAction();
			    this.docManageAction.setEnabled(false);
		    	defaultActions.add(this.docManageAction);
		    }
		    defaultActions.add(new ActionsBarSeparator());
		    defaultActions.add(this.firstLineAction);
		    defaultActions.add(this.preLineAction);
		    defaultActions.add(this.nextLineAction);
		    defaultActions.add(this.lastLineAction);
		    return defaultActions;
		  }

		public boolean isNeedFileDocAction() {
			return needFileDocAction;
		}

		public void setNeedFileDocAction(boolean needFileDocAction) {
			this.needFileDocAction = needFileDocAction;
		}
		
		public void setNote(String note) {
			this.note = note;
		}
		
		public String getNote() {
			return note;
		}
	
}
