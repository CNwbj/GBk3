package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer c_id;
	private String c_idcard_id;
	private String c_company;
	private String c_name;
	private String c_pwd;
	private String c_sex;
	private String c_phone;
	private String c_mail;
	private Date c_createdate;
	private String c_account_num;//卡号
	
	public String getC_account_num() {
		return c_account_num;
	}
	public void setC_account_num(String c_account_num) {
		this.c_account_num = c_account_num;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getC_idcard_id() {
		return c_idcard_id;
	}
	public void setC_idcard_id(String c_idcard_id) {
		this.c_idcard_id = c_idcard_id;
	}
	public String getC_company() {
		return c_company;
	}
	public void setC_company(String c_company) {
		this.c_company = c_company;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_pwd() {
		return c_pwd;
	}
	public void setC_pwd(String c_pwd) {
		this.c_pwd = c_pwd;
	}
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
	public Date getC_createdate() {
		return c_createdate;
	}
	public void setC_createdate(Date c_createdate) {
		this.c_createdate = c_createdate;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public Integer getC_accountid() {
		return c_accountid;
	}
	public void setC_accountid(Integer c_accountid) {
		this.c_accountid = c_accountid;
	}
	public Integer getC_eduid() {
		return c_eduid;
	}
	public void setC_eduid(Integer c_eduid) {
		this.c_eduid = c_eduid;
	}
	public String getC_photo() {
		return c_photo;
	}
	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public Double getC_money() {
		return c_money;
	}
	public void setC_money(Double c_money) {
		this.c_money = c_money;
	}
	public String getC_work() {
		return c_work;
	}
	public void setC_work(String c_work) {
		this.c_work = c_work;
	}
	private String c_address;
	private Integer c_accountid;
	private Integer c_eduid;
	private String c_photo;
	private Integer stateid;
	private Double c_money;
	private String c_work;
	
}
