package cn.sz.zl.pojo;

import java.io.Serializable;

public class Flowtype implements Serializable {
	private Integer flowmeter_type;
	private String flowmeter_typename;
	public Integer getFlowmeter_type() {
		return flowmeter_type;
	}
	public void setFlowmeter_type(Integer flowmeter_type) {
		this.flowmeter_type = flowmeter_type;
	}
	public String getFlowmeter_typename() {
		return flowmeter_typename;
	}
	public void setFlowmeter_typename(String flowmeter_typename) {
		this.flowmeter_typename = flowmeter_typename;
	}
}
