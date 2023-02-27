package kr.co.ta9.pandora3.baro.member.model.vo;

import kr.co.ta9.pandora3.app.bean.CommonBean;
import lombok.Data;

@Data
public class Member extends CommonBean{
	
	private String user_no;     
	private String user_id;     
	private String user_pwd;    
	private String user_name;   
	private String phone;       
	private String user_date;
	private String user_modifydate;
}
