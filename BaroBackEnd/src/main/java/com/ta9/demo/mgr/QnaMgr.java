package com.ta9.demo.mgr;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.dao.QnaDao;
import com.ta9.demo.dto.Qna;

@Service
public class QnaMgr {
	
	@Autowired  QnaDao qnaDao;
	@Autowired SqlSessionTemplate sql;
	public List<Qna> getQnaList(PageInfo pi, String serch) {
		return qnaDao.getQnaList(sql,pi,serch);
	}
	public List<Qna> getMainQnaList() {
		return qnaDao.getMainQnaList(sql);
	}

	public int insertQna(Qna q) {
		return  qnaDao.insertQna(sql, q);
	}
	public int getQnaCount(String serch) {
		return qnaDao.getQnaCount(sql, serch);
	}
	public List<Qna> getQnaDetail(String qno) {
		return qnaDao.getQnaDetail(sql, qno);
	}
	public int qnaDelete(int qno) {
		return qnaDao.qnaDelete(sql,qno);
	}
	public int updateQna(Qna q) {
		return qnaDao.updateQna(sql,q);
	}
	public List<Qna> myQnaList(Qna q, PageInfo pi) {
		return qnaDao.myQnaList(sql, q, pi);
	}
	public int myQnaListCount(Qna q) {
		return qnaDao.myQnaListCount(sql, q);
	}

}
