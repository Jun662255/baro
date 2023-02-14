package com.ta9.demo.dto;

import lombok.Data;

@Data
public class Notice {
	private String _notice_no;       
	private String _notice_title;    
	private String _notice_content;  
	private String _notice_date;     
	
	private String notice_writer;
	private String notice_modifydate;
	private String notice_modifyer;
	private String nno;
	
	
	public String getNno() {
		return nno;
	}
	public void setNno(String nno) {
		this.nno = nno;
	}
	public String get_notice_no() {
		return _notice_no;
	}
	public void set_notice_no(String _notice_no) {
		this._notice_no = _notice_no;
	}
	public String get_notice_title() {
		return _notice_title;
	}
	public void set_notice_title(String _notice_title) {
		this._notice_title = _notice_title;
	}
	public String get_notice_content() {
		return _notice_content;
	}
	public void set_notice_content(String _notice_content) {
		this._notice_content = _notice_content;
	}
	public String get_notice_date() {
		return _notice_date;
	}
	public void set_notice_date(String _notice_date) {
		this._notice_date = _notice_date;
	}
	public String getNotice_writer() {
		return notice_writer;
	}
	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}
	public String getNotice_modifydate() {
		return notice_modifydate;
	}
	public void setNotice_modifydate(String notice_modifydate) {
		this.notice_modifydate = notice_modifydate;
	}
	public String getNotice_modifyer() {
		return notice_modifyer;
	}
	public void setNotice_modifyer(String notice_modifyer) {
		this.notice_modifyer = notice_modifyer;
	}
	@Override
	public String toString() {
		return "Notice [_notice_no=" + _notice_no + ", _notice_title=" + _notice_title + ", _notice_content="
				+ _notice_content + ", _notice_date=" + _notice_date + ", notice_writer=" + notice_writer
				+ ", notice_modifydate=" + notice_modifydate + ", notice_modifyer=" + notice_modifyer + ", nno=" + nno
				+ "]";
	}

	
	
	
}