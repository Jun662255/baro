package kr.co.ta9.pandora3.baro.qna.model.vo;

import kr.co.ta9.pandora3.app.bean.CommonBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class Qna extends CommonBean {
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
	private String o_file_name;    
	private String c_file_name;
	
}
