package com.ta9.demo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.dto.Transport;

@Repository
public class TransportDao {

	public int setTransport(SqlSessionTemplate sql, Transport t) {
		return sql.insert("tranport.setTransport",t);
	}
	public List<Transport> myTransport(SqlSessionTemplate sql, Transport n,PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sql.selectList("tranport.myTransport",n,rowBounds);
	}
	public String price(SqlSessionTemplate sql, Transport n) {
		return  sql.selectOne("tranport.price", n);
	}
	public int getmyTransportCount(SqlSessionTemplate sql,Transport n) {
		return sql.selectOne("tranport.getmyTransportCount",n);
	}
}
