package com.ta9.demo.mgr;

import java.io.IOException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta9.demo.dao.NoticeDao;
import com.ta9.demo.dto.Notice;

@Service
public class NoticeMgr {
	@Autowired NoticeDao noticeDao;
	@Autowired SqlSessionTemplate sql;


	public List<Notice> getNoticeList() throws IOException{
		return noticeDao.getNoticeList(sql);
	}

	public int getNoticeCount()  throws IOException{

		return noticeDao.getNoticeCount(sql);
	}
}