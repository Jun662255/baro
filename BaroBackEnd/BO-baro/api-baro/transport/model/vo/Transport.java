package kr.co.ta9.pandora3.baro.transport.model.vo;

import kr.co.ta9.pandora3.app.bean.CommonBean;
import lombok.Data;

@Data

public class Transport  extends CommonBean{
	private int transport_no;
	private int user_no;
	private String departure;
	private String price;
	private String recipient;
	private String destination;
	private String transport_date;
	private String _status;
	
	
	private String user_name;

	private String s_cnt;
	private String p_sum;
	
	private String transport_modifyer;	
	private String crtr_id;	
	private String updr_id;	
	private String transport_modifydate;
	private String cd_nm;
	private String cd;
	private String _cd;
	private String ref_2;
	
}
