package com.ta9.demo.mgr;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ta9.demo.common.PageInfo;
import com.ta9.demo.dao.TransportDao;
import com.ta9.demo.dto.Transport;

@Service
public class TransportMgr {
	@Autowired TransportDao transportDao;
	@Autowired SqlSessionTemplate sql;
	public int setTransport(Transport t) {
		return transportDao.setTransport(sql,t);
	}
	public List<Transport> myTransport(Transport n, PageInfo pi) {
		return transportDao.myTransport(sql,n,pi);
	}
	public String price(Transport n) {
		return transportDao.price(sql,n);
	}
	public int getmyTransportCount(Transport n) {
		return transportDao.getmyTransportCount(sql,n);
	} 
}
