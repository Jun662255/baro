package kr.co.ta9.pandora3.baro.qna.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.app.servlet.controller.CommonActionController;
import kr.co.ta9.pandora3.baro.qna.model.manager.QnaMgr;
import kr.co.ta9.pandora3.common.conf.Const;
import kr.co.ta9.pandora3.common.util.ResponseUtil;
@Controller
public class QnaController  extends CommonActionController {

	@Autowired
	private QnaMgr qnaMgr;
	
	// 문의 조회
	@RequestMapping(value="/baro/board/qna/getQanList", method=RequestMethod.POST)
	public void qnaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ParameterMap 선언
		ParameterMap parameterMap = getParameterGridMap(request, response);
		// Result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// JSONObject 선언
		JSONObject json = new JSONObject();
		try {
			// 일반컨텐츠 : 게시글 목록 조회(그리드형)
			json = qnaMgr.qnaList(parameterMap);
		}catch(Exception e) {
			result = Const.BOOLEAN_FAIL;
		}
		// JSONObject 결과값 반환
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}
	
	// 문의 답변저장
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/baro/board/qna/QanSava", method = RequestMethod.POST)
	public void QanSava(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameterMap 선언
		ParameterMap parameterMap = getParameterMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			// 메뉴 권한 저장
			json.put("MSG", qnaMgr.qanSava(parameterMap));
		}
		catch (Exception e) {
			// Exception 일 경우
			result = Const.BOOLEAN_FAIL;
		    
		}
		// json에 결과 담기
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}

}
