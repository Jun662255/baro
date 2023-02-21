package com.ta9.demo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.dto.Notice;

@Repository
public class NoticeDao {
	

	public List<Notice> getNoticeList(SqlSessionTemplate sql, PageInfo pi, String serch) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sql.selectList("notice.getNoticeList",serch,rowBounds);
	}

	public int getNoticeCount(SqlSessionTemplate sql, String  serch) {
		
		return sql.selectOne("notice.getNoticeCount",serch);
	}

	public List<Notice> getMainNoticeList(SqlSessionTemplate sql) {
		return sql.selectList("notice.getMainNoticeList");
	}

	public List<Notice> getNoticeDetail(SqlSessionTemplate sql, String nno) {
		return sql.selectList("notice.getNoticeDetail", nno);
	}
}
