package cn.sz.zl.pojo;

import java.io.Serializable;

public class Material implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer material_id;
	private String material_name;
	private Double material_price;
	private String material_details;
	private String material_url;
	private String material_nul;
	private String material_null;
	private Integer material_sum;
	private State state;
	private Depot depot;
	private Integer depot_id;
	public Integer getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public Double getMaterial_price() {
		return material_price;
	}
	public void setMaterial_price(Double material_price) {
		this.material_price = material_price;
	}
	public String getMaterial_details() {
		return material_details;
	}
	public void setMaterial_details(String material_details) {
		this.material_details = material_details;
	}
	public String getMaterial_url() {
		return material_url;
	}
	public void setMaterial_url(String material_url) {
		this.material_url = material_url;
	}
	public String getMaterial_nul() {
		return material_nul;
	}
	public void setMaterial_nul(String material_nul) {
		this.material_nul = material_nul;
	}
	public String getMaterial_null() {
		return material_null;
	}
	public void setMaterial_null(String material_null) {
		this.material_null = material_null;
	}
	public Integer getMaterial_sum() {
		return material_sum;
	}
	public void setMaterial_sum(Integer material_sum) {
		this.material_sum = material_sum;
	}
	public Integer getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(Integer depot_id) {
		this.depot_id = depot_id;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	
}
