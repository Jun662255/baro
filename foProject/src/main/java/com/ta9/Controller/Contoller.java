package com.ta9.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Contoller {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String vueTest() {
		System.out.println("asdasdadsdsadsasdasdasd");
		return "fovue/index.html";
	}

}
