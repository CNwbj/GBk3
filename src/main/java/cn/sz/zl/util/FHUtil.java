package cn.sz.zl.util;

import java.io.Serializable;

import cn.sz.zl.pojo.C_payment;
import cn.sz.zl.pojo.Customer;
import cn.sz.zl.pojo.Material;
import cn.sz.zl.pojo.ReturnGoods;
import cn.sz.zl.pojo.Sale;
import cn.sz.zl.pojo.State;

public class FHUtil implements Serializable{
	private static final long serialVersionUID = 1L;
	private Sale sale;
	private Customer customer;    //客户表对象
	private Material material;	  //商品表对象
	private State state;		  //仓库状态表对象
	private C_payment payment;	  //支付方式表对象
	private ReturnGoods returngoods;
	private State state1;//
	private State state2;//
	private State state3;//
	private State sendGoodState;//发货状态
	private State encoState;//财务状态
	
	public State getState1() {
		return state1;
	}
	public void setState1(State state1) {
		this.state1 = state1;
	}
	public State getState2() {
		return state2;
	}
	public void setState2(State state2) {
		this.state2 = state2;
	}
	public State getState3() {
		return state3;
	}
	public void setState3(State state3) {
		this.state3 = state3;
	}
	public ReturnGoods getReturngoods() {
		return returngoods;
	}
	public void setReturngoods(ReturnGoods returngoods) {
		this.returngoods = returngoods;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public C_payment getPayment() {
		return payment;
	}
	public void setPayment(C_payment payment) {
		this.payment = payment;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public State getSendGoodState() {
		return sendGoodState;
	}
	public void setSendGoodState(State sendGoodState) {
		this.sendGoodState = sendGoodState;
	}
	public State getEncoState() {
		return encoState;
	}
	public void setEncoState(State encoState) {
		this.encoState = encoState;
	}
	
}
