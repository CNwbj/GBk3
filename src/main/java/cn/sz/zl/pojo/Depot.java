package cn.sz.zl.pojo;

import java.io.Serializable;

public class Depot implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer depot_id;
	private String depot_name;
	private Integer stateid;
	private Integer depot_sum;
	//类型
	private State state;
	public Integer getDepot_id() {
		return depot_id;
	}
	public void setDepot_id(Integer depot_id) {
		this.depot_id = depot_id;
	}
	public String getDepot_name() {
		return depot_name;
	}
	public void setDepot_name(String depot_name) {
		this.depot_name = depot_name;
	}
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Integer getDepot_sum() {
		return depot_sum;
	}
	public void setDepot_sum(Integer depot_sum) {
		this.depot_sum = depot_sum;
	}
	
}
