package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Quotation implements Serializable {
	private Integer quotationid;
	private Integer  materialid;	
	private Integer cpaymentid;	
	private Date quotationdate;
	private Date ofrvail;
	private Integer cid;	
	private Integer stateid;	
	private Integer errid;
	private String remarks;
	private Integer Stateid1;
	
	public Integer getQuotationid() {
		return quotationid;
	}
	public void setQuotationid(Integer quotationid) {
		this.quotationid = quotationid;
	}
	public Integer getMaterialid() {
		return materialid;
	}
	public void setMaterialid(Integer materialid) {
		this.materialid = materialid;
	}
	
	public Integer getCpaymentid() {
		return cpaymentid;
	}
	public void setCpaymentid(Integer cpaymentid) {
		this.cpaymentid = cpaymentid;
	}

	public Date getQuotationdate() {
		return quotationdate;
	}
	public void setQuotationdate(Date quotationdate) {
		this.quotationdate = quotationdate;
	}
	public Date getOfrvail() {
		return ofrvail;
	}
	public void setOfrvail(Date ofrvail) {
		this.ofrvail = ofrvail;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	
	public Integer getErrid() {
		return errid;
	}
	public void setErrid(Integer errid) {
		this.errid = errid;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getStateid1() {
		return Stateid1;
	}
	public void setStateid1(Integer stateid1) {
		Stateid1 = stateid1;
	}

	
}
