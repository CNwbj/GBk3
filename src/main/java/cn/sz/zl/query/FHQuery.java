package cn.sz.zl.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FHQuery {
	private Integer saleid;
	private Integer c_id;
	private String sendaddr;
	private Integer material_id;
	//开始日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date qStartAddDate;
	//结束日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date qEndAddDate;
	private Integer orderid;
	private String c_name;
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Date getqStartAddDate() {
		return qStartAddDate;
	}
	public void setqStartAddDate(Date qStartAddDate) {
		this.qStartAddDate = qStartAddDate;
	}
	public Date getqEndAddDate() {
		return qEndAddDate;
	}
	public void setqEndAddDate(Date qEndAddDate) {
		this.qEndAddDate = qEndAddDate;
	}
	public Integer getSaleid() {
		return saleid;
	}
	public void setSaleid(Integer saleid) {
		this.saleid = saleid;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getSendaddr() {
		return sendaddr;
	}
	public void setSendaddr(String sendaddr) {
		this.sendaddr = sendaddr;
	}
	public Integer getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}
	
}
