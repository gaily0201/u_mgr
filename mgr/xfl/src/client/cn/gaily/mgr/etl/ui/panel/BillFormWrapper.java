package cn.gaily.mgr.etl.ui.panel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import nc.ui.pub.beans.UITable;
import nc.ui.pubapp.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.vo.pub.bill.BillTabVO;
import cn.gaily.mgr.etl.AggMgrInfoVO;

public class BillFormWrapper extends ShowUpableBillForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8722775757589678660L;

	
	@Override
	protected void createBillCardPanel() {
		 this.billCardPanel = new BillCardPanel();
		 billCardPanel.setHeadScale(60);
		 if (this.billCardPanel instanceof nc.ui.pubapp.bill.BillCardPanel) {
		      ((nc.ui.pubapp.bill.BillCardPanel) this.billCardPanel).setBillForm(this);
		 }
//		super.createBillCardPanel();
	}
	
	/**
	 * <p>�������ƣ�setShowTotalLine</p>
	 * <p>��������������ʾ���ϼơ���</p>
	 * @param isShowTotalLine
	 * @author xiaoh
	 * @since 2014-11-23
	 */
//	@Override
//	public void setShowTotalLine(boolean isShowTotalLine) {
//		super.setShowTotalLine(false);
//	}
	
	@Override
	public void initUI() {
		super.initUI();
		
		BillTabVO vo = new BillTabVO();
		vo.setTabcode("log");
		vo.setTabname("��־��Ϣ");
		this.getBillCardPanel().getBodyTabbedPane().addScrollPane(vo, new CopyOfSynLogPanel((AggMgrInfoVO)getModel().getSelectedData()));

		UITable table =  this.getBillCardPanel().getBillTable();
		table.getColumn("����״̬").setCellRenderer(new DefaultTableCellRenderer(){
			
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {

				String v_value = (String) value;
				if("����".equals(v_value)){
					this.setBackground(Color.GREEN);
				}else if("ͣ��".equals(v_value)){
					this.setBackground(Color.RED);
				}else if("���".equals(v_value)){
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
