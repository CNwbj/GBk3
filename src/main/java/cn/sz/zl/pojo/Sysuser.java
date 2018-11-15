package cn.sz.zl.pojo;

import java.io.Serializable;

public class SysUser implements Serializable {
	private Integer userid;
	private String loginname;
	private String loginpwd;
	private Integer deptno;
	private Integer roleid;
	private Integer is_dele;
	private Dept dept;
	private SysRole sysrole;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public boolean checkRole() {
		if (sysrole != null && sysrole.getRoleid() == 1) {
			return true;
		}
		return false;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public Integer getis_dele() {
		return is_dele;
	}

	public void setis_dele(Integer is_dele) {
		this.is_dele = is_dele;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public SysRole getSysrole() {
		return sysrole;
	}

	public void setSysrole(SysRole sysrole) {
		this.sysrole = sysrole;
	}

}
