package cn.sz.zl.pojo;

import java.io.Serializable;
/**
 * 支付方式实体类
 * @author Administrator
 *
 */
public class C_payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer c_paymentid;
	private String payment;
	public Integer getC_paymentid() {
		return c_paymentid;
	}
	public void setC_paymentid(Integer c_paymentid) {
		this.c_paymentid = c_paymentid;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
}
