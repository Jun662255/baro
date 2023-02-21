package com.ta9.demo.dto;

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

	private String add1;
	private String add2;
	private String add3;
	private String add4;
	private String add5;
	private String add6;

	private String cd;
	private String cd_nm;
	private String ref_1;
	
	public String getRef_1() {
		return ref_1;
	}

	public void setRef_1(String ref_1) {
		this.ref_1 = ref_1;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCd_nm() {
		return cd_nm;
	}

	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}

	public int getTransport_no() {
		return transport_no;
	}

	public void setTransport_no(int transport_no) {
		this.transport_no = transport_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTransport_date() {
		return transport_date;
	}

	public void setTransport_date(String transport_date) {
		this.transport_date = transport_date;
	}

	public String get_status() {
		return _status;
	}

	public void set_status(String _status) {
		this._status = _status;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getS_cnt() {
		return s_cnt;
	}

	public void setS_cnt(String s_cnt) {
		this.s_cnt = s_cnt;
	}

	public String getP_sum() {
		return p_sum;
	}

	public void setP_sum(String p_sum) {
		this.p_sum = p_sum;
	}

	public String getTransport_modifyer() {
		return transport_modifyer;
	}

	public void setTransport_modifyer(String transport_modifyer) {
		this.transport_modifyer = transport_modifyer;
	}

	public String getCrtr_id() {
		return crtr_id;
	}

	public void setCrtr_id(String crtr_id) {
		this.crtr_id = crtr_id;
	}

	public String getUpdr_id() {
		return updr_id;
	}

	public void setUpdr_id(String updr_id) {
		this.updr_id = updr_id;
	}

	public String getTransport_modifydate() {
		return transport_modifydate;
	}

	public void setTransport_modifydate(String transport_modifydate) {
		this.transport_modifydate = transport_modifydate;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getAdd3() {
		return add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	public String getAdd4() {
		return add4;
	}

	public void setAdd4(String add4) {
		this.add4 = add4;
	}

	public String getAdd5() {
		return add5;
	}

	public void setAdd5(String add5) {
		this.add5 = add5;
	}

	public String getAdd6() {
		return add6;
	}

	public void setAdd6(String add6) {
		this.add6 = add6;
	}

	@Override
	public String toString() {
		return "Transport [transport_no=" + transport_no + ", user_no=" + user_no + ", departure=" + departure
				+ ", price=" + price + ", recipient=" + recipient + ", destination=" + destination + ", transport_date="
				+ transport_date + ", _status=" + _status + ", user_name=" + user_name + ", s_cnt=" + s_cnt + ", p_sum="
				+ p_sum + ", transport_modifyer=" + transport_modifyer + ", crtr_id=" + crtr_id + ", updr_id=" + updr_id
				+ ", transport_modifydate=" + transport_modifydate + ", add1=" + add1 + ", add2=" + add2 + ", add3="
				+ add3 + ", add4=" + add4 + ", add5=" + add5 + ", add6=" + add6 + ", cd=" + cd + ", cd_nm=" + cd_nm
				+ ", ref_1=" + ref_1 + "]";
	}

}
