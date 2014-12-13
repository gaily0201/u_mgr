package cn.gaily.mgr.etl.timer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import nc.bs.pub.pa.PreAlertObject;
import nc.bs.pub.taskcenter.BgWorkingContext;
import nc.bs.pub.taskcenter.IBackgroundWorkPlugin;
import nc.jdbc.framework.JdbcSession;
import nc.jdbc.framework.exception.DbException;
import nc.vo.pub.BusinessException;

/**
 * <p>Title: ClearETLLogTimer</P>
 * <p>Description: ��ʱ�������ͬ���ɹ���־</p>
 * <p>Copyright: ��������������޹�˾ Copyright (c) 2014</p>
 * @author xiaoh
 * @version 1.0
 * @since 2014-11-20
 */
public class ClearETLLogTimer implements IBackgroundWorkPlugin {

	Connection conn = null;
	
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BusinessException {
		
		String sql = "DELETE PUB_WORKINGTASKLOG A WHERE A.TASKNAME='����˫��ͬ������' AND A.WORKINGRESULT='Y'";
		
		JdbcSession session = null;
		Statement st = null;
		
		try {
			if(conn==null||conn.isClosed()){
				session = new JdbcSession();
				conn = session.getConnection();
			}
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate(sql);
			conn.commit();
		} catch (DbException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
