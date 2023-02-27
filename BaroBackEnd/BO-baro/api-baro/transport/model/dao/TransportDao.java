package kr.co.ta9.pandora3.baro.transport.model.dao;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import kr.co.ta9.pandora3.app.repository.BaseDao;
import kr.co.ta9.pandora3.app.servlet.ParameterMap;

@Repository
public class TransportDao extends BaseDao {

	public JSONObject transportList(ParameterMap parameterMap) throws Exception {
		return queryForGrid("Transport.transportrList", parameterMap);
	}

	public ArrayList chart1() {
		return (ArrayList) getSqlSession().selectList("Transport.chart1");
	}

	public ArrayList chart2() {
		return (ArrayList) getSqlSession().selectList("Transport.chart2");
	}

}
