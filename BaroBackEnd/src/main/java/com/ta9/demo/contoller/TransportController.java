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
		t.setDeparture(t.getAdd1() + "/" + t.getAdd2() + "/" + t.getAdd3()); // 한 컬럼에 담기 위함
		t.setDestination(t.getAdd4() + "/" + t.getAdd5() + "/" + t.getAdd6());
		int result = transportMgr.setTransport(t);
		return result;
	}

	@PostMapping("/myTransport")
	public Map<String, Object> myTransport(@RequestBody Transport n, @RequestParam("cPage") int currentPage) {
		PageInfo pi = Pagination.getPageInfo(transportMgr.getmyTransportCount(n), currentPage, 5, 10);
		List<Transport> list = transportMgr.myTransport(n, pi);
		Map<String, Object> rtnMap = new HashMap<>();
		rtnMap.put("pi", pi);
		rtnMap.put("list", list);
		return rtnMap;
	}

	@PostMapping("/successPrice")
	public String successPrice(@RequestBody Transport n) {
		String price = transportMgr.successPrice(n);
		return price;
	}
	@GetMapping("/getPrice")
	public List<Transport> getPrice() {
		List<Transport> list = transportMgr.getPrice();
		return list;
	}
}
