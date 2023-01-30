package com.ta9.baro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta9.baro.mgr.NoticeMgr;

/*@CrossOrigin(origins = "http://localhost:8080")*/
@RestController
@RequestMapping("/api")
public class NoticeController {
	
	@Autowired NoticeMgr noticeMgr;
	
	
	  @GetMapping("/hello")
	  public String getNoticeList(){
	  
	  return "hello"; 
	  }
	 
	
}
