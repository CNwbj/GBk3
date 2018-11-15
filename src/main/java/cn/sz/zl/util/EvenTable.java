package cn.sz.zl.util;

import java.io.Serializable;

import cn.sz.zl.pojo.Bill;
import cn.sz.zl.pojo.Flowmeter;
import cn.sz.zl.pojo.Flowtype;
import cn.sz.zl.pojo.Material;
import cn.sz.zl.pojo.Purchase;
import cn.sz.zl.pojo.Sale;

public class EvenTable implements Serializable {
	private Flowmeter flowmeter;
	private Bill bill;
	private Purchase purchase;
	private Sale sale;
	private Material material;
	private Flowtype flowtype;
	public Flowmeter getFlowmeter() {
		return flowmeter;
	}
	public void setFlowmeter(Flowmeter flowmeter) {
		this.flowmeter = flowmeter;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Flowtype getFlowtype() {
		return flowtype;
	}
	public void setFlowtype(Flowtype flowtype) {
		this.flowtype = flowtype;
	}
}
