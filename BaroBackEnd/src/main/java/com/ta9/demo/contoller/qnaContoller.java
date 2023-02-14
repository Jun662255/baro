package com.ta9.demo.contoller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.common.Pagination;
import com.ta9.demo.dto.Qna;
import com.ta9.demo.mgr.QnaMgr;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class qnaContoller {

	@Autowired
	QnaMgr qnaMge;

	@GetMapping("/qnaList")
	public Map<String, Object> getQnaList(@RequestParam("cPage") int currentPage, @RequestParam(required = false, value="serch") String serch ) {
		Map<String, Object> rtnMap = new HashMap<>();
		PageInfo pi = Pagination.getPageInfo(qnaMge.getQnaCount(serch), currentPage, 5, 10);
		List<Qna> list = qnaMge.getQnaList(pi,serch);
		rtnMap.put("pi", pi);
		rtnMap.put("list", list);
		return rtnMap;
	}
	@GetMapping("/mainQnaList")
	public List<Qna> getMainQnaList() {
		List<Qna> list = qnaMge.getMainQnaList();
		return list;
	}
	@GetMapping("/qnaDetail")
	public List<Qna> getQnaDetail(@RequestParam("qno") String qno) {
		List<Qna> list = qnaMge.getQnaDetail(qno);
		return list;
	}
	
	@PostMapping("/insertQna")
	public int insertQna(Qna q) {
		int result = 0;
		if(!q.getUpfile().getOriginalFilename().equals("")) {
			String changeName = saveFile(q);
			q.setO_file_name(q.getUpfile().getOriginalFilename());
			q.setC_file_name(changeName);
			
			result = qnaMge.insertQna(q);
		} else {
			result = qnaMge.insertQna(q);
		}
		
		return result;
	}
	private String saveFile(Qna q) {
		String user_no = Integer.toString(q.getUser_no());
		String originName = q.getUpfile().getOriginalFilename();
		int ranNum = (int)(Math.random() * 90000) + 10000; 
		String ext = originName.substring(originName.lastIndexOf("."));
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String ChangeName = currentTime + "_" + user_no + "_" + ranNum + "_" + ext;
		String savePath = "C:\\aaa/"; 
		try {
			q.getUpfile().transferTo(new File(savePath+ChangeName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return ChangeName;
	}
	@GetMapping("/qnaDelete")
	public int qnaDelete(@RequestParam("qno") int qno) {
		int result = qnaMge.qnaDelete(qno);
		return result;
	}
	
	
	
	
}
