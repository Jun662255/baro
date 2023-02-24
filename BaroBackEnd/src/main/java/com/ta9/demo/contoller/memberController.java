package com.ta9.demo.contoller;

import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta9.demo.dto.Member;
import com.ta9.demo.mgr.MemberMgr;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class memberController {

	@Autowired
	MemberMgr memberMgr;

	// private BCryptPasswordEncoder b =new BCryptPasswordEncoder();
	@PostMapping("/duplicateCheck")
	public int getduplicateCheck(@RequestBody Member m) {
		int result = memberMgr.getduplicateCheck(m);
		return result;
	}

	@PostMapping("singUp")
	public int singUp(@RequestBody Member m) {
		String pwd = m.getUser_pwd();
		m.setUser_pwd(encrypt(pwd));
		int result = memberMgr.singUp(m);
		return result;
	}

	// SHA 256 단방향암호화
	public static String encrypt(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pwd.getBytes()); // 바이트 배열로 변경후  바이트배열 해시함수에 입력
			byte byteData[] = md.digest();// 호출된 암호화 값 얻기
			StringBuffer sb = new StringBuffer(); 
			for (int i = 0; i < byteData.length; i++) { // 16진수 문자열 변환 후 sb에 추가
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); 
			}
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) { // byteData배열의 각요소 변경 후 hexString에 추가
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) { // 예외처리 
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@PostMapping("login")
	public List<Member> login(@RequestBody Member m) {
		String pwd = m.getUser_pwd();
		m.setUser_pwd(encrypt(pwd));
		List<Member> list = memberMgr.login(m);
		return list;
	}

	@PostMapping("infoChange")
	public int infoChange(@RequestBody Member m) {
		String pwd = m.getUser_pwd();
		m.setUser_pwd(encrypt(pwd));
		if(m.getNew_pwd() != null) {
			String newPwd = m.getNew_pwd();
			m.setNew_pwd(encrypt(newPwd));
		}
		int result = memberMgr.infoChange(m);
		return result;
	}

}
