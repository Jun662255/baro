package kr.co.ta9.pandora3.baro.qna.model.manager;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.baro.qna.model.dao.QnaDao;
import kr.co.ta9.pandora3.pcommon.dto.TbLgapPgminfH;
import kr.co.ta9.pandora3.pcommon.dto.TsysPgmInf;

@Service
public class QnaMgr {
	
	@Autowired	private QnaDao qnafDao;

	public JSONObject qnaList(ParameterMap parameterMap) throws Exception {
		return qnafDao.qnaList(parameterMap);
	}


	public String qanSava(ParameterMap parameterMap) throws Exception {

		TsysPgmInf tsysPgmInf = (TsysPgmInf)parameterMap.populate(TsysPgmInf.class);
		TbLgapPgminfH tbLgapPgminfH = (TbLgapPgminfH)parameterMap.populate(TbLgapPgminfH.class);

		 int nResult =0 ;

			nResult = qnafDao.qnaSave(parameterMap);
			tbLgapPgminfH.setHist_stat_cd("30");
			tbLgapPgminfH.setHist_stat_nm("수정");
			//tbLgapPgminfHDaoTrx.insert(tbLgapPgminfH);
		
		return "저장되었습니다.";
	}
}