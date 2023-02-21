package com.ta9.demo.dto;

import lombok.Data;

// @Data
public class Member {
	private String user_no;
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String phone;
	private String idC;
	private String new_pwd;
	private String user_date;
	private String user_modifydate;
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdC() {
		return idC;
	}
	public void setIdC(String idC) {
		this.idC = idC;
	}
	public String getNew_pwd() {
		return new_pwd;
	}
	public void setNew_pwd(String new_pwd) {
		this.new_pwd = new_pwd;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	public String getUser_modifydate() {
		return user_modifydate;
	}
	public void setUser_modifydate(String user_modifydate) {
		this.user_modifydate = user_modifydate;
	}
	@Override
	public String toString() {
		return "Member [user_no=" + user_no + ", user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name="
				+ user_name + ", phone=" + phone + ", idC=" + idC + ", new_pwd=" + new_pwd + ", user_date=" + user_date
				+ ", user_modifydate=" + user_modifydate + "]";
	}
	public Member(String user_no, String user_id, String user_pwd, String user_name, String phone, String idC,
			String new_pwd, String user_date, String user_modifydate) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.phone = phone;
		this.idC = idC;
		this.new_pwd = new_pwd;
		this.user_date = user_date;
		this.user_modifydate = user_modifydate;
	}
	public Member() {
		super();
	}


}