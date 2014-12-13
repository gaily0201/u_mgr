package cn.gaily.mgr.etl.ui.action;

import java.awt.event.ActionEvent;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.NCAction;
import cn.gaily.mgr.etl.AggMgrInfoVO;
import cn.gaily.mgr.etl.MgrInfoVO;
import cn.gaily.pub.util.CommonUtils;
import cn.gaily.simplejdbc.SimpleJdbc;

public class TestConnAction extends NCAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2122289923702887135L;
	private BillManageModel model;
	
	public TestConnAction(){
		setBtnName("测试连接");
		setCode("testConn");
	}
	@Override
	public void doAction(ActionEvent e) throws Exception {
		Object obj = model.getSelectedData();
		if(obj==null){
			return ;
		}
		
		AggMgrInfoVO aggvo = (AggMgrInfoVO) obj;
		MgrInfoVO vo = aggvo.getParentVO();
		
		boolean canConn1 = SimpleJdbc.testConnection(vo.getSrcusername(), vo.getSrcpassword(), vo.getScrip(), vo.getSrcname(),vo.getSrcport()); 
		boolean canConn2 = false;
		if(CommonUtils.isNotEmpty(vo.getTarip())&&CommonUtils.isNotEmpty(vo.getTarusername())){
			canConn2 = SimpleJdbc.testConnection(vo.getTarusername(), vo.getTarpassword(), vo.getTarip(), vo.getTarname(), vo.getTarport()); 
		}
		
		StringBuilder sb  = new StringBuilder();
		if(canConn1){
			sb.append("源库连接成功！");
		}else{
			sb.append("源库连接失败！");
		}
		
		if(canConn2){
			sb.append("目标库连接成功！");
		}else{
			sb.append("目标库连接失败！");
		}
		MessageDialog.showHintDlg(null, "提示", sb.toString());
		
	}

	
	public BillManageModel getModel() {
		return model;
	}
	public void setModel(BillManageModel model) {
		this.model = model;
		model.addAppEventListener(this);
	}
	
}
