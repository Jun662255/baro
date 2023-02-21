package com.ta9.demo.mgr;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta9.demo.dao.MemberDao;
import com.ta9.demo.dto.Member;

@Service
public class MemberMgr {

	@Autowired
	MemberDao memberDao;
	@Autowired
	SqlSessionTemplate sql;

	public int getduplicateCheck(Member m) {
		return memberDao.getduplicateCheck(sql, m);
	}

	public int singUp(Member m) {
		return memberDao.singUp(sql, m);
	}

	public List<Member> login(Member m) {
		return memberDao.login(sql, m);
	}

	public int infoChange(Member m) {
		return memberDao.infoChange(sql, m);
	}

}
