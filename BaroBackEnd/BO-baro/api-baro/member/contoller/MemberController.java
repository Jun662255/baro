package kr.co.ta9.pandora3.baro.member.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.app.servlet.controller.CommonActionController;
import kr.co.ta9.pandora3.baro.member.model.service.MemberMgr;
import kr.co.ta9.pandora3.common.conf.Const;
import kr.co.ta9.pandora3.common.util.ResponseUtil;

@Controller
public class MemberController extends CommonActionController{

	@Autowired
	private MemberMgr memberMgr;

	// 회원 목록 조회
	@RequestMapping(value = "/baro/member/getmemberList", method = RequestMethod.POST)
	public void memberList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameterMap 선언
		ParameterMap parameterMap = getParameterGridMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			// 마스터코드 그리드 목록 조회
			json = memberMgr.memberList(parameterMap);
		} catch (Exception e) {
			// Exception 일 경우
			result = Const.BOOLEAN_FAIL;
		}
		// json에 결과 담기
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}
	
	// 회원별 배송정보 조회
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/baro/member/memberTransport", method = RequestMethod.POST)
	public void memberTransport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameterMap 선언
		ParameterMap parameterMap = getParameterGridMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			// 코드상세 그리드 목록 조회
			json = memberMgr.memberTransport(parameterMap);
		} catch (Exception e) {
			// Exception 일 경우
			result = Const.BOOLEAN_FAIL;
		}
		// json에 결과 담기
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}
	
	// 배송상태 변경
	@RequestMapping(value = "/baro/member/saveStatus", method = RequestMethod.POST)
	public void saveStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameterMap 선언
		ParameterMap parameterMap = getParameterMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			// 하위 메뉴 저장
			memberMgr.saveStatus(parameterMap);
			
		} catch (Exception e) {
			// Exception일 경우
			result = Const.BOOLEAN_FAIL;
			// json에 MSG 담기
			json.put("MSG", parameterMap.getValue("MSG"));
			
			logger.error(e);
		}
		// json에 결과 담기
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}
}
