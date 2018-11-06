package cn.sz.zl.pojo;

import java.io.Serializable;

public class Errs implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer errid;
	private String errname;
	public Integer getErrid() {
		return errid;
	}
	public void setErrid(Integer errid) {
		this.errid = errid;
	}
	public String getErrname() {
		return errname;
	}
	public void setErrname(String errname) {
		this.errname = errname;
	}
	
}
