package com.ta9.demo.contoller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.common.Pagination;
import com.ta9.demo.dto.Qna;
import com.ta9.demo.dto.Transport;
import com.ta9.demo.mgr.QnaMgr;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class qnaContoller {

	@Autowired
	QnaMgr qnaMgr;
	
	@GetMapping("/qnaList")
	public Map<String, Object> getQnaList(@RequestParam("cPage") int currentPage, @RequestParam(required = false, value = "serch") String serch) {
		Map<String, Object> rtnMap = new HashMap<>();
		PageInfo pi = Pagination.getPageInfo(qnaMgr.getQnaCount(serch), currentPage, 5, 10);
		List<Qna> list = qnaMgr.getQnaList(pi, serch);
		rtnMap.put("pi", pi);
		rtnMap.put("list", list);
		return rtnMap;
	}
	
	@GetMapping("/mainQnaList")
	public List<Qna> getMainQnaList() {
		List<Qna> list = qnaMgr.getMainQnaList();
		return list;
	}

	@GetMapping("/qnaDetail")
	public List<Qna> getQnaDetail(@RequestParam("qno") String qno) {
		List<Qna> list = qnaMgr.getQnaDetail(qno);
		return list;
	}

	@PostMapping("/insertQna")
	public int insertQna(Qna q) {
		int result = 0;
		String upFileName = q.getUpfile().getOriginalFilename();
		if(!upFileName.isEmpty()) {
		boolean check = isImageFile(q.getUpfile());
			if(!check) {
				return 9;
			}
		}
		if (!q.getUpfile().getOriginalFilename().equals("")) {
			String changeName = saveFile(q);
			q.setO_file_name(q.getUpfile().getOriginalFilename());
			q.setC_file_name(changeName);

			result = qnaMgr.insertQna(q);
		} else {
			result = qnaMgr.insertQna(q);
		}
		return result;
	}
	private boolean isImageFile(MultipartFile file) {
		String contentType = file.getContentType();
		if (contentType == null) {
			return false;
		}
		if (contentType.startsWith("image")) { // ????????? ??????????????? true
			return true;
		}
		return false;
	}
	@PostMapping("/updateQna")
	public int updateQna(Qna q) {
		int result = 0;
		String upFileName = q.getUpfile().getOriginalFilename();
		if (!upFileName.isEmpty()) {
			boolean check = isImageFile(q.getUpfile());
			if (!check) {
				return 9;
			}
		}
		if (!q.getUpfile().getOriginalFilename().equals("")) { // ?????? ???????????? ??????
			// ???????????? ?????? ??????
			deleteFile(q.getC_file_name()); // ???????????? ?????? ????????? ??????
			String changeName = saveFile(q); // ?????? ?????? ??? ???????????? ????????? ????????? ??????
			q.setO_file_name(q.getUpfile().getOriginalFilename());
			q.setC_file_name(changeName);
			result = qnaMgr.updateQna(q);
		} else {
			result = qnaMgr.updateQna(q);
		}
		return result;
	}

	// ?????? ??????
	private void deleteFile(String fileName) {
		File file = new File("C:\\aaa\\" + fileName);
		if (file.exists()) { // ?????? ?????? ???????????? ??????
			file.delete(); // ?????? ??????
		}
	}

	private String saveFile(Qna q) {
		String user_no = Integer.toString(q.getUser_no());
		String originName = q.getUpfile().getOriginalFilename();
		int ranNum = (int) (Math.random() * 90000) + 10000; // ?????? 5??????
		String ext = originName.substring(originName.lastIndexOf(".")); // ?????????
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // ?????? ??????, ??????
		String ChangeName = currentTime + "_" + user_no + "_" + ranNum + "_" + ext; // ???????????????
		String savePath = "C:\\aaa/"; // ???????????? ?????? 
		try {
			q.getUpfile().transferTo(new File(savePath + ChangeName)); // ????????? ????????? ????????? ??????
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace(); // ????????????
		}
		return ChangeName;
	}

	@GetMapping("/qnaDelete")
	public int qnaDelete(@RequestParam("qno") int qno, @RequestParam("c_file_name") String fileName) {
		deleteFile(fileName);
		int result = qnaMgr.qnaDelete(qno);
		return result;
	}

	@PostMapping("/myQnaList")
	public Map<String, Object> myQnaList(@RequestBody Qna q, @RequestParam("cPage") int currentPage) {
		PageInfo pi = Pagination.getPageInfo(qnaMgr.myQnaListCount(q), currentPage, 5, 10);
		List<Qna> list = qnaMgr.myQnaList(q, pi);
		Map<String, Object> rtnMap = new HashMap<>();
		rtnMap.put("pi", pi);
		rtnMap.put("list", list);
		return rtnMap;
	}

	@GetMapping("/fileUpload")
	public int checkFile(@RequestParam("upFile") String upFile) {
		int result = 0;
		File file = new File("C:\\aaa\\" + upFile);
		if(file.exists()) {
			result = 1;
		}else {
			result = 0;
		};
		return result;
	}
	
	
}
