package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReturnGoods implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer orderid;
	private Integer c_id;
	private Integer material_id;
	private Integer stateid;
	private Integer goodscount;
	private Date orderdate;
	private String returnreason;
	
	public Integer getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(Integer goodscount) {
		this.goodscount = goodscount;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public Integer getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public String getReturnreason() {
		return returnreason;
	}
	public void setReturnreason(String returnreason) {
		this.returnreason = returnreason;
	}
	
}
