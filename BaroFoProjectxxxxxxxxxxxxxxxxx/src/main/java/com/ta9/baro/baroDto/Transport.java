package com.ta9.baro.baroDto;

import lombok.Data;

@Data

public class Transport {
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
	
}

