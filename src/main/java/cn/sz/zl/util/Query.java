package cn.sz.zl.util;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Query implements Serializable {
	private String qcid;//用以查询客户姓名
	private Integer qstateid;//用以查询状态
	public Integer getQstateid() {
		return qstateid;
	}
	public void setQstateid(Integer qstateid) {
		this.qstateid = qstateid;
	}
	private Integer qcpaymentid;//用以查询付款方式
	private Integer qmaterialid;//
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date qstartdate;//用以查询有效日期的时间段
	@DateTimeFormat(pattern="yyyy-MM-dd")
	
	private Date qenddate;//报价结束日期
	
	public String getQcid() {
		return qcid;
	}
	public void setQcid(String qcid) {
		this.qcid = qcid;
	}	

	public Integer getQcpaymentid() {
		return qcpaymentid;
	}
	public void setQcpaymentid(Integer qcpaymentid) {
		this.qcpaymentid = qcpaymentid;
	}
	public Integer getQmaterialid() {
		return qmaterialid;
	}
	public void setQmaterialid(Integer qmaterialid) {
		this.qmaterialid = qmaterialid;
	}
	public Date getQstartdate() {
		return qstartdate;
	}
	public void setQstartdate(Date qstartdate) {
		this.qstartdate = qstartdate;
	}
	public Date getQenddate() {
		return qenddate;
	}
	public void setQenddate(Date qenddate) {
		this.qenddate = qenddate;
	}

	
	
}
