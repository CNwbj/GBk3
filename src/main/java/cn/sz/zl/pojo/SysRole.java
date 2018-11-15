package cn.sz.zl.pojo;

import java.io.Serializable;
import java.util.List;

public class SysRole implements Serializable {
	private Integer roleid;
	private String rolename;
	private String roledes;
	private List<Permission> perlist;
	private Integer is_dele;
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledes() {
		return roledes;
	}

	public void setRoledes(String roledes) {
		this.roledes = roledes;
	}

	public List<Permission> getPerlist() {
		return perlist;
	}

	public void setPerlist(List<Permission> perlist) {
		this.perlist = perlist;
	}

	public Integer getIs_dele() {
		return is_dele;
	}

	public void setIs_dele(Integer is_dele) {
		this.is_dele = is_dele;
	}
	
	
}
