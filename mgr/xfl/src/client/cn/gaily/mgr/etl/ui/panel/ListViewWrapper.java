package cn.gaily.mgr.etl.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import nc.ui.pub.beans.UITable;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;

public class ListViewWrapper extends ShowUpableBillListView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6458112770317400697L;

	@Override
	  protected void createListPanel() {
	    this.billListPanel = new nc.ui.pubapp.bill.BillListPanel();
	  }
	
	@Override
	public void initUI() {
		super.initUI();
		
		final UITable table = this.getBillListPanel().getBodyTable();
		table.getColumn("运行状态").setCellRenderer(new DefaultTableCellRenderer(){
			
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {

				String v_value = (String) value;
				if("启用".equals(v_value)){
					this.setBackground(Color.GREEN);
				}else if("停用".equals(v_value)){
					this.setBackground(Color.RED);
				}else if("监控".equals(v_value)){
					this.setBackground(Color.LIGHT_GRAY);
				}else {
					this.setBackground(Color.WHITE);
				}
				
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
						row, column);
			}
		});
	}
}
