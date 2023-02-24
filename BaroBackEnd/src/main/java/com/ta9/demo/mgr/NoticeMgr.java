package com.ta9.demo.mgr;

import java.util.List;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.dao.NoticeDao;
import com.ta9.demo.dto.Notice;

@Service
public class NoticeMgr {
	@Autowired
	NoticeDao noticeDao;
	@Autowired
	SqlSessionTemplate sql;
    Configuration config;

    public NoticeMgr() {
        config = new Configuration();
        config.setCallSettersOnNulls(false);
    }
	public List<Notice> getNoticeList(PageInfo pi, String serch) {
		return noticeDao.getNoticeList(sql, pi, serch);
	}

	public int getNoticeCount(String serch) {
		return noticeDao.getNoticeCount(sql, serch);
	}

	public List<Notice> getMainNoticeList() {
		return noticeDao.getMainNoticeList(sql);
	}

	public List<Notice> getNoticeDetail(String nno) {
		return noticeDao.getNoticeDetail(sql, nno);
	}
}