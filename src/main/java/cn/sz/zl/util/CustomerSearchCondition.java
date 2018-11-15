package cn.sz.zl.util;

import java.io.Serializable;

public class CustomerSearchCondition implements Serializable {
	private String c_sex;
	private String c_phone;
	private String c_mail;
	private Integer stateid;
	private Integer start;
	private Integer end;

	public String getC_sex() {
		return c_sex;
	}

	public void setC_sex(String c_sex) {
		this.c_sex = c_sex;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public String getC_mail() {
		return c_mail;
	}

	public void setC_mail(String c_mail) {
		this.c_mail = c_mail;
	}

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

}
