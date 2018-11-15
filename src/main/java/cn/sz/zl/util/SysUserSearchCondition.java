package cn.sz.zl.util;

import java.io.Serializable;

public class SysUserSearchCondition implements Serializable {
	private String loginname;
	private Integer is_dele;
	private Integer deptno;
	private Integer roleid;
	private Integer start;
	private Integer end;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public Integer getIs_dele() {
		return is_dele;
	}

	public void setIs_dele(Integer is_dele) {
		this.is_dele = is_dele;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

}
