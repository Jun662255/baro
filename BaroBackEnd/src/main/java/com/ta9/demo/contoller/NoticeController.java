
package com.ta9.demo.contoller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta9.demo.dto.Notice;
import com.ta9.demo.mgr.NoticeMgr;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NoticeController {

	@Autowired
	NoticeMgr noticeMgr;

	@GetMapping("/noticeList")
	public List<Notice> getNoticeList() throws IOException {
		List<Notice> list =noticeMgr.getNoticeList();
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/noticeCount")
	public int getNoticeCount() throws IOException {

		return noticeMgr.getNoticeCount();
	}
	

}
