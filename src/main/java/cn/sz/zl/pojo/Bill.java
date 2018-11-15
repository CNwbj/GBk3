package cn.sz.zl.pojo;

import java.io.Serializable;

public class Bill implements Serializable {
	private Integer billId;	//账单ID
	private Integer saleId;	//订单ID
	private Integer purchaseId;	//采购表ID
	private Double profit;		//利润
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	
	
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	
	
}
