package com.ta9.demo.dao;

import java.io.IOException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ta9.demo.dto.Notice;

@Repository
public class NoticeDao {
	

	public List<Notice> getNoticeList(SqlSessionTemplate sql) throws IOException{
//		return (List)sql.selectList("notice.getNoticeList");
		return sql.selectList("notice.getNoticeList");
	}
	/*
	 * int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit(); int limit =
	 * pi.getBoardLimit();
	 * 
	 * RowBounds rowBounds = new RowBounds(offset, limit);
	 * 
	 * return (ArrayList)sql.selectList("notice.getNoticeList", null, rowBounds);
	 */

	public int getNoticeCount(SqlSessionTemplate sql) throws IOException{
		return sql.selectOne("notice.getNoticeCount");
	}
}
