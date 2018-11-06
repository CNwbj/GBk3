package cn.sz.zl.pojo;

import java.io.Serializable;

public class Material implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer material_id;
	private String material_name;
	private Double material_price;
	private String material_details;
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
	
}
