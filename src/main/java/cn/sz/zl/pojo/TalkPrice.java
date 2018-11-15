package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.Date;

public class TalkPrice implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer talkid;
	private Integer c_id;
	private Customer customer;
	private Integer material_id;
	private Material material;//资材对象
	private double q_price;
	private Integer stateid;
	private State state;
	private Date talkdate;
	public Integer getTalkid() {
		return talkid;
	}
	public void setTalkid(Integer talkid) {
		this.talkid = talkid;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public double getQ_price() {
		return q_price;
	}
	public void setQ_price(double q_price) {
		this.q_price = q_price;
	}
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Date getTalkdate() {
		return talkdate;
	}
	public void setTalkdate(Date talkdate) {
		this.talkdate = talkdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
