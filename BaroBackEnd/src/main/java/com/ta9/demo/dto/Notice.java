package com.ta9.demo.dto;

import lombok.Data;

@Data
public class Notice {
	private String _notice_no;       
	private String _notice_title;    
	private String _notice_content;  
	private String _notice_date;     
	
	private String o_file_name;    
	private String c_file_name;
	
	private String notice_writer;
	private String notice_modifydate;
	private String notice_modifyer;
}