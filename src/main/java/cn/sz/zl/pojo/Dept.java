package cn.sz.zl.pojo;

import java.io.Serializable;

public class Dept implements Serializable {
	private Integer deptno;
	private String dname;
	private Integer usercount;

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

	public Integer getUsercount() {
		return usercount;
	}

	public void setUsercount(Integer usercount) {
		this.usercount = usercount;
	}

}
