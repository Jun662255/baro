package kr.co.ta9.pandora3.baro.notice.model.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.baro.notice.model.dao.NoticeDao;
import kr.co.ta9.pandora3.pcommon.dto.TbLgapPgminfH;
import kr.co.ta9.pandora3.pcommon.dto.TsysPgmInf;

@Service
public class NoticeMgr {

	@Autowired
	private NoticeDao noticeDao;
	
	public JSONObject noticeList(ParameterMap parameterMap) throws Exception {
		return noticeDao.noticeList(parameterMap);
	}

	public int saveGridNotice(ParameterMap parameterMap) throws Exception {
		TsysPgmInf tsysPgmInf = (TsysPgmInf) parameterMap.populate(TsysPgmInf.class);
		TbLgapPgminfH tbLgapPgminfH = (TbLgapPgminfH) parameterMap.populate(TbLgapPgminfH.class);

		int nResult = 0;

		nResult = noticeDao.saveGridNotice(parameterMap);

		return nResult;
	}

	public String updateNotice(ParameterMap parameterMap) throws Exception {

		TsysPgmInf tsysPgmInf = (TsysPgmInf) parameterMap.populate(TsysPgmInf.class);
		TbLgapPgminfH tbLgapPgminfH = (TbLgapPgminfH) parameterMap.populate(TbLgapPgminfH.class);

		int nResult = 0;

		nResult = noticeDao.updateNotice(parameterMap);
		tbLgapPgminfH.setHist_stat_cd("30");
		tbLgapPgminfH.setHist_stat_nm("수정");

		return "저장되었습니다.";
	}

	public Object insertNotice(ParameterMap parameterMap) throws Exception {

		TsysPgmInf tsysPgmInf = (TsysPgmInf) parameterMap.populate(TsysPgmInf.class);
		TbLgapPgminfH tbLgapPgminfH = (TbLgapPgminfH) parameterMap.populate(TbLgapPgminfH.class);

		int nResult = 0;

		nResult = noticeDao.noticeInsert(parameterMap);

		return "저장되었습니다.";
	}

}
