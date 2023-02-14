package com.ta9.demo.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.common.Pagination;
import com.ta9.demo.dto.Transport;
import com.ta9.demo.mgr.TransportMgr;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransportController {
	
	@Autowired
	TransportMgr transportMgr;
	@PostMapping("/setTransport")
	public int setTransport(@RequestBody Transport t) {
		
		String add1 = t.getAdd1();
		String add2 = t.getAdd2();
		String add3 = t.getAdd3();
		String add4 = t.getAdd4();
		String add5 = t.getAdd5();
		String add6 = t.getAdd6();
		t.setDeparture(add1+"/"+add2+"/"+add3);
		t.setDestination(add4+"/"+add5+"/"+add6);
		System.out.println(t);
		int result =transportMgr.setTransport(t); 
		return result;
	}
	@PostMapping("/myTransport")
	public Map<String, Object> myTransport(@RequestBody Transport n,@RequestParam("cPage") int currentPage){
		PageInfo pi = Pagination.getPageInfo(transportMgr.getmyTransportCount(n), currentPage, 5, 10);
		List<Transport> list = transportMgr.myTransport(n,pi);
		Map<String, Object> rtnMap = new HashMap<>();
		rtnMap.put("pi", pi);
		rtnMap.put("list", list);
		return rtnMap;
	}
	@PostMapping("/price")
	public  String price(@RequestBody Transport n){
		String price = transportMgr.price(n);
		return price;
	}
}
