package cn.sz.zl.pojo;

import java.io.Serializable;


public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer purchase_id;//采购表id
	
	private Integer orders_sum ;//采购数量
	
	//物资
	private Purchase purchase;
	private Material material;
	private Integer stock_sum; //库存数量
	//业务员对象
	private SysUser sysuser;
	private Integer sum_oos; //缺货数
	//销售类型
	private Sale sale;
	//仓库类型
	private Depot depot;
	private  Integer cost_price; //成本价出 
	private String purchase_nul ;//采购表空字段1
	private String purchase_null ;//采购表空字段2
	public Integer getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(Integer purchase_id) {
		this.purchase_id = purchase_id;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public SysUser getSysuser() {
		return sysuser;
	}
	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	public String getPurchase_nul() {
		return purchase_nul;
	}
	public void setPurchase_nul(String purchase_nul) {
		this.purchase_nul = purchase_nul;
	}
	public String getPurchase_null() {
		return purchase_null;
	}
	public void setPurchase_null(String purchase_null) {
		this.purchase_null = purchase_null;
	}
	public Integer getOrders_sum() {
		return orders_sum;
	}
	public void setOrders_sum(Integer orders_sum) {
		this.orders_sum = orders_sum;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public Integer getStock_sum() {
		return stock_sum;
	}
	public void setStock_sum(Integer stock_sum) {
		this.stock_sum = stock_sum;
	}
	public Integer getSum_oos() {
		return sum_oos;
	}
	public void setSum_oos(Integer sum_oos) {
		this.sum_oos = sum_oos;
	}
	public Integer getCost_price() {
		return cost_price;
	}
	public void setCost_price(Integer cost_price) {
		this.cost_price = cost_price;
	}
	
	
	
	
	
	
}
