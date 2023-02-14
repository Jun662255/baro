package com.ta9.demo.mgr;

import java.io.IOException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.dao.NoticeDao;
import com.ta9.demo.dto.Notice;

@Service
public class NoticeMgr {
	@Autowired NoticeDao noticeDao;
	@Autowired SqlSessionTemplate sql;


	public List<Notice> getNoticeList(PageInfo pi,String serch) throws IOException{
		return noticeDao.getNoticeList(sql,pi,serch);
	}

	public int getNoticeCount(String serch)  throws IOException{
		return noticeDao.getNoticeCount(sql,serch);
	}

	public List<Notice> getMainNoticeList() {
		return noticeDao.getMainNoticeList(sql);
	}

	public List<Notice> getNoticeDetail(String nno) {
		return  noticeDao.getNoticeDetail(sql, nno);
	}
}