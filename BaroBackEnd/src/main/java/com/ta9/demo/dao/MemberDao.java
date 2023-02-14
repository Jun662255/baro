package com.ta9.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ta9.demo.dto.Member;
import com.ta9.demo.dto.Transport;
@Repository
public class MemberDao {

	public int getduplicateCheck(SqlSessionTemplate sql, Member m) {
		return sql.selectOne("member.getduplicateCheck",m);
	}

	public int singUp(SqlSessionTemplate sql, Member m) {
		return sql.insert("member.singUp",m);
	}

	public List<Member> login(SqlSessionTemplate sql, Member m) {
		return sql.selectList("member.login",m);
	}

	public int infoChange(SqlSessionTemplate sql, Member m) {
		System.out.println(m);
		
		int i = sql.update("member.infoChange",m);
		
		System.out.println(i);
		System.out.println(i);
		System.out.println(i);
		System.out.println(i);
		System.out.println(i);
		System.out.println(i);
		return i;
	}

	

}
