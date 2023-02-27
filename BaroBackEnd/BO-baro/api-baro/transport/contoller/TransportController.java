package kr.co.ta9.pandora3.baro.transport.contoller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.app.servlet.controller.CommonActionController;
import kr.co.ta9.pandora3.baro.transport.model.service.TransportMgr;
import kr.co.ta9.pandora3.baro.transport.model.vo.Transport;
import kr.co.ta9.pandora3.common.conf.Const;
import kr.co.ta9.pandora3.common.util.ResponseUtil;

@Controller
public class TransportController extends CommonActionController{

	@Autowired TransportMgr transportMgr;
	
	// 배송 조회
	@RequestMapping(value = "/baro/transport/geTransportList", method = RequestMethod.POST)
	public void memberList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameterMap 선언
		ParameterMap parameterMap = getParameterGridMap(request, response);
		// result 선언
		String result = Const.BOOLEAN_SUCCESS;
		// json 선언
		JSONObject json = new JSONObject();
		try {
			// 마스터코드 그리드 목록 조회
			json = transportMgr.transportList(parameterMap);
		} catch (Exception e) {
			// Exception 일 경우
			result = Const.BOOLEAN_FAIL;
		}
		// json에 결과 담기
		json.put("RESULT", result);
		
		ResponseUtil.write(response, json.toJSONString());
	}
	
	// 차트1 조회
	@ResponseBody
	@RequestMapping(value = "/baro/transport/chart1", method = RequestMethod.POST)
	public ModelAndView chart1(@ModelAttribute("chart1") Transport transport, ModelMap model, 
	HttpServletRequest request, HttpServletResponse response, HttpSession session, BindingResult bindingResult) throws Exception{

		ModelAndView modelAndView = new ModelAndView();
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		modelAndView.setView(jsonView);
		ArrayList c1 = transportMgr.chart1();
		model.addAttribute("c1", c1);

		return modelAndView;
	}
	
	// 차트2 조회
	@ResponseBody
	@RequestMapping(value = "/baro/transport/chart2", method = RequestMethod.POST)
	public ModelAndView chart2(@ModelAttribute("chart2") Transport transport, ModelMap model, 
	HttpServletRequest request, HttpServletResponse response, HttpSession session, BindingResult bindingResult) throws Exception{

		ModelAndView modelAndView = new ModelAndView();
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		modelAndView.setView(jsonView);
		ArrayList c2 = transportMgr.chart2();
		model.addAttribute("c2", c2);

		return modelAndView;
	}
}
