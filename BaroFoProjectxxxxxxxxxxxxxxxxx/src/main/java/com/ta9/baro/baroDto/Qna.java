package com.ta9.baro.baroDto;

import lombok.Data;

@Data
public class Qna {
	private int qna_no;          
	private String qna_title;       
	private String qna_content;  
	private String qna_date;      
	private int user_no;       
	
	private String user_id;
	private String check_comment;
	private String comment;
	
	private String qna_modifydate;
	private String qna_modifyer;
	
}