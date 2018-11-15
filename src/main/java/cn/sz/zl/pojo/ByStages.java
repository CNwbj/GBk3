package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.Date;

public class ByStages implements Serializable {
	private Integer staId;		//分期表主键
	private Integer saleId;		//订单ID
	private Integer staCount;	//分期次数
	private Integer repaymentCount;	//当前还款期数
	private Date repaymentDte;	//还款日期
	private Double repaymentMoney;	//每期还款金额
	public Integer getStaId() {
		return staId;
	}
	public void setStaId(Integer staId) {
		this.staId = staId;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getStaCount() {
		return staCount;
	}
	public void setStaCount(Integer staCount) {
		this.staCount = staCount;
	}
	public Integer getRepaymentCount() {
		return repaymentCount;
	}
	public void setRepaymentCount(Integer repaymentCount) {
		this.repaymentCount = repaymentCount;
	}
	public Date getRepaymentDte() {
		return repaymentDte;
	}
	public void setRepaymentDte(Date repaymentDte) {
		this.repaymentDte = repaymentDte;
	}
	public Double getRepaymentMoney() {
		return repaymentMoney;
	}
	public void setRepaymentMoney(Double repaymentMoney) {
		this.repaymentMoney = repaymentMoney;
	}
}
