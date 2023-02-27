package kr.co.ta9.pandora3.baro.transport.model.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.baro.transport.model.dao.TransportDao;

@Service
public class TransportMgr {

	@Autowired
	private TransportDao transportDao;

	public JSONObject transportList(ParameterMap parameterMap) throws Exception {
		parameterMap.getValue("crtr_id");
		return transportDao.transportList(parameterMap);
	}

	public ArrayList chart1() {
		return transportDao.chart1();
	}

	public ArrayList chart2() {
		return transportDao.chart2();
	}

}
