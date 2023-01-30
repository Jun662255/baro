package com.ta9.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class cont {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String vueTest() {
		return "barovue/index.html";
	}
}