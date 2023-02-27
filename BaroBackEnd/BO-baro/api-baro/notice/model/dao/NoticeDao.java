package kr.co.ta9.pandora3.baro.notice.model.dao;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import kr.co.ta9.pandora3.app.repository.BaseDao;
import kr.co.ta9.pandora3.app.servlet.ParameterMap;

@Repository
public class NoticeDao extends BaseDao {

	public JSONObject noticeList(ParameterMap parameterMap) throws Exception {
		return queryForGrid("Notice.noticeList", parameterMap);
	}

	
	public <T> int updateNotice(ParameterMap parameterMap) throws Exception {
		return update("Notice.updateNotice", parameterMap);
	}

	public <T> int noticeInsert(ParameterMap parameterMap) throws Exception {
		return update("Notice.noticeInsert", parameterMap);
	}
	
	public int saveGridNotice(ParameterMap parameterMap) throws Exception {
		return delete("Notice.saveGridNotice", parameterMap);
	}
	
}
