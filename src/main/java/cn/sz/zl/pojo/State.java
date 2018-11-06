package cn.sz.zl.pojo;

import java.io.Serializable;

public class State implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer stateid;
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	private String statename;
	
}
