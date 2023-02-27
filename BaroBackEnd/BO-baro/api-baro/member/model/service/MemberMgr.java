package kr.co.ta9.pandora3.baro.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ta9.pandora3.app.servlet.ParameterMap;
import kr.co.ta9.pandora3.baro.member.model.dao.MemberDao;
import kr.co.ta9.pandora3.baro.transport.model.vo.Transport;
import kr.co.ta9.pandora3.pcmn.dao.TcmnCdDtlDao;
import kr.co.ta9.pandora3.pcommon.dto.TcmnCdDtl;

@Service
public class MemberMgr {
	
	@Autowired MemberDao memberDao;
	@Autowired
	private TcmnCdDtlDao tcmnCdDtlDao;
	
	public JSONObject memberList(ParameterMap parameterMap) throws Exception {
		return memberDao.memberList(parameterMap);
	}

	public JSONObject memberTransport(ParameterMap parameterMap) throws Exception {
		return memberDao.memberTransport(parameterMap);
	}
	

	public void saveStatus(ParameterMap parameterMap) throws Exception {
		List<TcmnCdDtl> insertList = new ArrayList<TcmnCdDtl>();
		List<Transport> updateList = new ArrayList<Transport>();
		List<TcmnCdDtl> deleteList = new ArrayList<TcmnCdDtl>();
		
		parameterMap.populates(Transport.class, insertList, updateList, deleteList);
		
		TcmnCdDtl[] insert = insertList.toArray(new TcmnCdDtl[0]);
		Transport[] update = updateList.toArray(new Transport[0]);
		TcmnCdDtl[] delete = deleteList.toArray(new TcmnCdDtl[0]);
		
		tcmnCdDtlDao.updateMany("Member.saveStatus", update);
	}

}
