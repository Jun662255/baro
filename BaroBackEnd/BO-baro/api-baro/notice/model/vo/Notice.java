package kr.co.ta9.pandora3.baro.notice.model.vo;

import kr.co.ta9.pandora3.app.bean.CommonBean;
import lombok.Data;

@Data

public class Notice extends CommonBean{
	private String _notice_no;       
	private String _notice_title;    
	private String _notice_content;  
	private String _notice_date;     
	

	
	private String notice_writer;
	private String notice_modifydate;
	private String notice_modifyer;
	
}
