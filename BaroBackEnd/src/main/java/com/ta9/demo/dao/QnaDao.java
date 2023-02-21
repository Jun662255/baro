package com.ta9.demo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.dto.Qna;
@Repository
public class QnaDao {

	public List<Qna> getQnaList(SqlSessionTemplate sql, PageInfo pi, String serch) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sql.selectList("qna.getQnaList",serch,rowBounds);
	}

	public List<Qna> getMainQnaList(SqlSessionTemplate sql) {
		return sql.selectList("qna.getMainQnaList");
	}

	public List<Qna> getQnaDetail(SqlSessionTemplate sql, String qno) {
		return sql.selectList("qna.getQnaDetail", qno);
	}

	public int insertQna(SqlSessionTemplate sql, Qna q) {
		 
		return sql.insert("qna.insertQna", q);
	}

	public int getQnaCount(SqlSessionTemplate sql, String serch) {
		return sql.selectOne("qna.getQnaCount",serch);
	}

	public int qnaDelete(SqlSessionTemplate sql, int qno) {
		return sql.delete("qna.qnaDelete", qno);
	}

	public int updateQna(SqlSessionTemplate sql, Qna q) {
		return sql.update("qna.updateQna", q);
	}

	public int myQnaListCount(SqlSessionTemplate sql, Qna q) {
		return sql.selectOne("qna.myQnaListCount",q);
	}

	public List<Qna> myQnaList(SqlSessionTemplate sql, Qna q, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sql.selectList("qna.myQnaList",q,rowBounds);
	}

}
