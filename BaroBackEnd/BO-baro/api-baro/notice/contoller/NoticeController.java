package kr.co.ta9.pandora3.baro.notice.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.app.servlet.controller.CommonActionController;
import kr.co.ta9.pandora3.baro.notice.model.service.NoticeMgr;
import kr.co.ta9.pandora3.common.conf.Const;
import kr.co.ta9.pandora3.common.util.ResponseUtil;
@Controller
public class NoticeController extends CommonActionController {
	@Autowired
	private NoticeMgr noticeMgr;
	// 공지 목록 조회
	@RequestMapping(value="/baro/board/notice/getNoticeList", method=RequestMethod.POST)
	public void getNoticeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ParameterMap 선언
		ParameterMap parameterMap = getParameterGridMap(request, response);
		// Result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// JSONObject 선언
		JSONObject json = new JSONObject();
		try {
			// 일반컨텐츠 : 게시글 목록 조회(그리드형)
			json = noticeMgr.noticeList(parameterMap);
		}catch(Exception e) {
			result = Const.BOOLEAN_FAIL;
		}
		// JSONObject 결과값 반환
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}
	

	
	// 공지 수정 저장
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/baro/board/notice/updateNotice", method = RequestMethod.POST)
	public void updateNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameterMap 선언
		ParameterMap parameterMap = getParameterMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			// 메뉴 권한 저장
			json.put("MSG", noticeMgr.updateNotice(parameterMap));
		}
		catch (Exception e) {
			// Exception 일 경우
			result = Const.BOOLEAN_FAIL;
		    
		}
		// json에 결과 담기
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}
	
	
	
	// 공지 행삭제
	@RequestMapping(value="/baro/board/notice/saveGridNotice", method=RequestMethod.POST)
	public void saveGridNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// parameterMap 선언
		ParameterMap parameterMap = getParameterMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			noticeMgr.saveGridNotice(parameterMap);
			
		} catch (Exception e) {
			// Exception일 경우
			result = Const.BOOLEAN_FAIL;
			// json에 MSG 담기
			json.put("MSG", "삭제되었습니다.");
			
			logger.error(e);
		}
		// json에 결과 담기
		json.put("RESULT", result);
		ResponseUtil.write(response, json.toJSONString());
	}
	
	// 공지 작성
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/baro/board/notice/inserteNotice", method = RequestMethod.POST)
	public void insertNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameterMap 선언
		ParameterMap parameterMap = getParameterMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			// 메뉴 권한 저장
			json.put("MSG", noticeMgr.insertNotice(parameterMap));
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
