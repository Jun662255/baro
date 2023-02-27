package kr.co.ta9.pandora3.baro.qna.model.dao;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import kr.co.ta9.pandora3.app.repository.BaseDao;
import kr.co.ta9.pandora3.app.servlet.ParameterMap;

@Repository
public class QnaDao extends BaseDao {

	public JSONObject qnaList(ParameterMap parameterMap) throws Exception {
		return queryForGrid("qna.qnaList", parameterMap);
	}

	public <T> int qnaSave(ParameterMap parameterMap) throws Exception {
		return update("qna.qnaSave", parameterMap);
	}

}
