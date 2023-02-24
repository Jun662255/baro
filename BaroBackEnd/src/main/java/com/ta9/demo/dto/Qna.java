package com.ta9.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Qna {
	private int qna_no;
	private int qna_no_row;
	private String qna_title;
	private String qna_content;
	private String qna_date;
	private int user_no;
	private MultipartFile upfile;
	private String user_id;
	private String check_comment;
	private String comment;

	private String qna_modifydate;
	private String qna_modifyer;
	private String o_file_name;
	private String c_file_name;
	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public String getQna_date() {
		return qna_date;
	}

	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCheck_comment() {
		return check_comment;
	}

	public void setCheck_comment(String check_comment) {
		this.check_comment = check_comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getQna_modifydate() {
		return qna_modifydate;
	}

	public void setQna_modifydate(String qna_modifydate) {
		this.qna_modifydate = qna_modifydate;
	}

	public String getQna_modifyer() {
		return qna_modifyer;
	}

	public void setQna_modifyer(String qna_modifyer) {
		this.qna_modifyer = qna_modifyer;
	}

	public String getO_file_name() {
		return o_file_name;
	}

	public void setO_file_name(String o_file_name) {
		this.o_file_name = o_file_name;
	}

	public String getC_file_name() {
		return c_file_name;
	}

	public void setC_file_name(String c_file_name) {
		this.c_file_name = c_file_name;
	}



	@Override
	public String toString() {
		return "Qna [qna_no=" + qna_no + ", qna_title=" + qna_title + ", qna_content=" + qna_content + ", qna_date="
				+ qna_date + ", user_no=" + user_no + ", user_id=" + user_id + ", check_comment=" + check_comment
				+ ", comment=" + comment + ", qna_modifydate=" + qna_modifydate + ", qna_modifyer=" + qna_modifyer
				+ ", o_file_name=" + o_file_name + ", c_file_name=" + c_file_name  
				+ ", upfile=" + upfile + "]";
	}

	public Qna(int qna_no, String qna_title, String qna_content, String qna_date, int user_no, String user_id,
			String check_comment, String comment, String qna_modifydate, String qna_modifyer, String o_file_name,
			String c_file_name) {
		super();
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_date = qna_date;
		this.user_no = user_no;
		this.user_id = user_id;
		this.check_comment = check_comment;
		this.comment = comment;
		this.qna_modifydate = qna_modifydate;
		this.qna_modifyer = qna_modifyer;
		this.o_file_name = o_file_name;
		this.c_file_name = c_file_name;
	}

	public Qna() {
		super();
	}

}
