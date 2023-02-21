
package com.ta9.demo.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.common.Pagination;
import com.ta9.demo.dto.Notice;
import com.ta9.demo.mgr.NoticeMgr;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NoticeController {

	@Autowired
	NoticeMgr noticeMgr;

	@GetMapping("/noticeList")
	public Map<String, Object> getNoticeCount(@RequestParam("cPage") int currentPage, @RequestParam(required = false, value = "serch") String serch) {
		Map<String, Object> rtnMap = new HashMap<>();
		PageInfo pi = Pagination.getPageInfo(noticeMgr.getNoticeCount(serch), currentPage, 5, 10);
		List<Notice> list = noticeMgr.getNoticeList(pi, serch);
		rtnMap.put("pi", pi);
		rtnMap.put("list", list);
		return rtnMap;
	}

	@GetMapping("/mainNoticeList")
	public List<Notice> getMainNoticeList() {
		List<Notice> list = noticeMgr.getMainNoticeList();
		return list;
	}

	@GetMapping("/noticeDetail")
	public List<Notice> getNoticeDetail(@RequestParam("nno") String nno) {
		List<Notice> list = noticeMgr.getNoticeDetail(nno);
		return list;
	}
}
