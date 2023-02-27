package kr.co.ta9.pandora3.baro.member.model.dao;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import kr.co.ta9.pandora3.app.repository.BaseDao;
import kr.co.ta9.pandora3.app.servlet.ParameterMap;

@Repository
public class MemberDao extends BaseDao {

	public JSONObject memberList(ParameterMap parameterMap) throws Exception {
		return queryForGrid("Member.memberList", parameterMap);
	}

	
	public JSONObject memberTransport(ParameterMap parameterMap) throws Exception {
		return queryForGrid("Member.memberTransport", parameterMap);
	}
	
}
