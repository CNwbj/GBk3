package cn.sz.zl.pojo;

import java.io.Serializable;

public class Dept implements Serializable {
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	private static final long serialVersionUID = 1L;
	private Integer deptno;
	private String dname;
	
}