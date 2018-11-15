package cn.sz.zl.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DWXQuery {
	
	private Integer qc_id;
	
	//开始日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date qStartAddDate;
	//结束日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date qEndAddDate;


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
	public Integer getQc_id() {
		return qc_id;
	}
	public void setQc_id(Integer qc_id) {
		this.qc_id = qc_id;
	}
	

	
}
