package cn.gaily.mgr.etl.ui.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.MapListProcessor;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIButton;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.beans.UIScrollPane;
import nc.ui.pub.beans.UITable;
import nc.ui.pub.beans.UITextField;
import nc.vo.pub.BusinessException;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.MgrItemVO;

public class CopyOfSynLogPanel extends UIScrollPane implements ActionListener{

	/**
	 * 数据交换日志 展示界面
	 */
	private static final long serialVersionUID = -6798481923872721090L;

	public UIPanel main_panel;
	public IUAPQueryBS iqs;
	
	public UIPanel top_panel_syn;
	public UIScrollPane usp_panel_syn;
	public UIPanel panel_syn;
	public UITable table_syn;
	
	public String[][] values_syn;
	public UITextField text_syn_srcip; 
	public UITextField text_syn_destip;
	public UITextField text_syn_tablename;
	public UITextField text_syn_type;
	public UIRefPane ref_syn_start ;
	public UIRefPane ref_syn_end ;
	public UIButton btn_query_syn;	
	
	public CopyOfSynLogPanel(){
		init();
	}
	
	public CopyOfSynLogPanel(AggMgrInfoVO vo){
		init(vo);
	}
	
	public void init() {
		try{
		iqs = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		initSynLog();
		onQuerySynLog();
		}catch (Exception e) {
			MessageDialog.showHintDlg(this, "提示", e.getMessage());
			return ;
		}
	}
	public void init(AggMgrInfoVO vo) {
		try{
			iqs = NCLocator.getInstance().lookup(IUAPQueryBS.class);
			initSynLog();
			if(vo==null||vo.getAllChildrenVO().length<=0){
				return;
			}
			List<String> list = null;
			for(MgrItemVO v: (MgrItemVO[])vo.getAllChildrenVO()){
				list = new ArrayList<String>();
				list.add(v.getTablename().trim().toUpperCase());
			}
			onQuerySynLog(list);
		}catch (Exception e) {
			MessageDialog.showHintDlg(this, "提示", e.getMessage());
			return ;
		}
	}

	private void initSynLog()  throws BusinessException {
		usp_panel_syn = new UIScrollPane();
		panel_syn = new UIPanel();
		panel_syn.setLayout(new BorderLayout());
		panel_syn.add(usp_panel_syn,BorderLayout.CENTER);
		this.add(panel_syn);
		initTable_syn();
		this.setViewportView(table_syn);
	}


	private void initTable_syn() throws BusinessException {
		table_syn = new UITable();
		String sql = "select * from (select h.ts ts,h.starttime starttime,h.endtime endtime, h.srcip srcip, "+
					 "h.destip destip, "+
					 "h.tablename tabname , "+
					 "h.type type, "+
					 "h.result result," +
					 "h.srcusername  srcusername, " +
					 "h.destusername destusername "+
					 "from etl_synlog h order by endtime desc ) where rownum<1000 ";
		List returnlist = (List) iqs.executeQuery(sql, new MapListProcessor());
		values_syn = null;
		if(returnlist != null && returnlist.size()>0){
			int size = returnlist.size();
			values_syn = new String[size][11];
			HashMap map;
			for(int i = 0;i<size;i++){
				map = (HashMap) returnlist.get(i);
				values_syn[i][0] = (i+1)+"";
				values_syn[i][1] = nvlNull(map.get("srcip"));
				values_syn[i][2] = nvlNull(map.get("srcusername"));
				values_syn[i][3] = nvlNull(map.get("destip"));
				values_syn[i][4] = nvlNull(map.get("destusername"));
				values_syn[i][5] = nvlNull(map.get("tabname"));
				values_syn[i][6] = nvlNull(map.get("type"));
				values_syn[i][7] = nvlNull(map.get("result"));
				values_syn[i][8] = nvlNull(map.get("starttme"));
				values_syn[i][9] = nvlNull(map.get("endtime"));
				values_syn[i][10] = nvlNull(map.get("ts"));
			}
		}
		String[] titles = new String[]{"序号","源数据库ip","源数据库用户","目标数据库ip","目标数据库用户","表名","同步类型","数量（条）","开始时间","结束时间","记录时间"};
		DefaultTableModel model = new DefaultTableModel(values_syn,titles){
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};		
		table_syn.setModel(model);
		this.setViewportView(table_syn);
	}


	public String getTitle() {
		return null;
	}
	
	private void onQuerySynLog() {
		onQuerySynLog("");
	}

	public void onQuerySynLog(AggMgrInfoVO vo) {
		List<String> list = list = new ArrayList<String>();
		for(MgrItemVO v: (MgrItemVO[])vo.getAllChildrenVO()){
			list.add(v.getTablename().trim().toUpperCase());
		}
		onQuerySynLog(list);
	}

	
	public void onQuerySynLog(String table){
		List<String> list = new ArrayList<String>();
		if(table!=null&&!"".equals(table.trim())){
			list.add(table);
		}
		onQuerySynLog(list);
	}
	
	public void onQuerySynLog(List<String> tables) {
		try{
			StringBuilder wsql = new StringBuilder(" where 1=1 ");

			if(tables!=null&&tables.size()>0){
				wsql.append("and tablename in('");
				for(String v: tables){
					wsql.append(v.trim().toUpperCase());
					wsql.append("','");
				}
				wsql.deleteCharAt(wsql.length()-1);
				wsql.deleteCharAt(wsql.length()-1);
				wsql.append(")");
			}

			table_syn = new UITable();
			String sql = " select * from ( select h.ts ts,h.starttime starttime,h.endtime endtime, h.srcip srcip, "+
					 "h.destip destip, "+
					 "h.tablename tabname , "+
					 "h.type type, "+
					 "h.result result, "+
					 "h.srcusername  srcusername, " +
					 "h.destusername destusername "+
					 "from etl_synlog h ";
			sql = sql + wsql +" order by endtime desc ) where rownum<1000";  
			List returnlist = (List) iqs.executeQuery(sql, new MapListProcessor());
			values_syn = null;
			if(returnlist != null && returnlist.size()>0){
				int size = returnlist.size();
				values_syn = new String[size][11];
				HashMap map;
				for(int i = 0;i<size;i++){
					map = (HashMap) returnlist.get(i);
					values_syn[i][0] = (i+1)+"";
					values_syn[i][1] = nvlNull(map.get("srcip"));
					values_syn[i][2] = nvlNull(map.get("srcusername"));
					values_syn[i][3] = nvlNull(map.get("destip"));
					values_syn[i][4] = nvlNull(map.get("destusername"));
					values_syn[i][5] = nvlNull(map.get("tabname"));
					values_syn[i][6] = nvlNull(map.get("type"));
					values_syn[i][7] = nvlNull(map.get("result"));
					values_syn[i][8] = nvlNull(map.get("starttime"));
					values_syn[i][9] = nvlNull(map.get("endtime"));
					values_syn[i][10] = nvlNull(map.get("ts"));
				}
			}
			String[] titles = new String[]{"序号","源数据库ip","源数据库用户","目标数据库ip","目标数据库用户","表名","同步类型","数量（条）","开始时间","结束时间","记录时间"};
			
			DefaultTableModel model = new DefaultTableModel(values_syn,titles){
				public boolean isCellEditable(int row, int column) {
					return false;
				};
			};		
			table_syn.setModel(model);
			this.setViewportView(table_syn);
		}catch(Exception e){
			MessageDialog.showHintDlg(this, "提示", e.getMessage());
			return ;
		}
	}

	
	public String nvlNull(Object o){
		if(o == null){
			return "";
		}else{
			return o.toString();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
