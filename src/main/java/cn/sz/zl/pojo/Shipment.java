package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.Date;
public class Shipment implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer shipment_id;//出货表id
	//private Integer material_id ;//物资id
	//private Integer saleid ;//销售id
	//private Integer stateid ;//出货状态
	//销售对象
	private Sale sale;
	//状态对象
	private State state;
	//采购对象
	private Purchase purchase;
	private SysUser sysuser;
	//private Integer userid ;//审核人
	//物资表对象
	/*private Integer c_id;
	private Integer depot_id;*/
	private Depot depot;
	//客状态
	private Customer customer;
	private Material material;

	private String shipment_nul="深圳龙华富士康";//出货表空字段1
	private Date shipment_null ;//发货时间
	public Integer getShipment_id() {
		return shipment_id;
	}
	public void setShipment_id(Integer shipment_id) {
		this.shipment_id = shipment_id;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public SysUser getSysuser() {
		return sysuser;
	}
	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getShipment_nul() {
		return shipment_nul;
	}
	public void setShipment_nul(String shipment_nul) {
		this.shipment_nul = shipment_nul;
	}
	public Date getShipment_null() {
		return shipment_null;
	}
	public void setShipment_null(Date shipment_null) {
		this.shipment_null = shipment_null;
	}
	

}
