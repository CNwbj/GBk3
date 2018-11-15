package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Flowmeter implements Serializable {
	private Integer fm_id;			//流水id
	private String flowmeter_id;	//流水号
	private Double old_balance;		//操作之前账户余额
	private Integer bill_id;			//账单ID
	private Date flowmeter_time;		//流水时间
	private Integer flowmeter_type;	//流水类型
	private Double now_balance;		//操作之后账户余额
	public Integer getFm_id() {
		return fm_id;
	}
	public void setFm_id(Integer fm_id) {
		this.fm_id = fm_id;
	}
	public String getFlowmeter_id() {
		return flowmeter_id;
	}
	public void setFlowmeter_id(String flowmeter_id) {
		this.flowmeter_id = flowmeter_id;
	}
	public Double getOld_balance() {
		return old_balance;
	}
	public void setOld_balance(Double old_balance) {
		this.old_balance = old_balance;
	}
	public Integer getBill_id() {
		return bill_id;
	}
	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}
	public Date getFlowmeter_time() {
		return flowmeter_time;
	}
	public void setFlowmeter_time(Date flowmeter_time) {
		this.flowmeter_time = flowmeter_time;
	}
	public Integer getFlowmeter_type() {
		return flowmeter_type;
	}
	public void setFlowmeter_type(Integer flowmeter_type) {
		this.flowmeter_type = flowmeter_type;
	}
	public Double getNow_balance() {
		return now_balance;
	}
	public void setNow_balance(Double now_balance) {
		this.now_balance = now_balance;
	}
	
	
	
}
