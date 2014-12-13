package cn.gaily.mgr.etl.itf;

import java.util.List;
import nc.vo.pub.BusinessException;
import cn.gaily.mgr.etl.MgrInfoVO;

public interface IMgrXflService {

	  public void changeState() throws BusinessException;

	  public void  synHistory(MgrInfoVO pvo);

	  public List<String> checkTabs(List<String> tabs);
	
}
