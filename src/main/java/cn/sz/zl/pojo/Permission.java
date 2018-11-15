package cn.sz.zl.pojo;

import java.io.Serializable;

public class Permission implements Serializable {
	private Integer perid;
	private String pname;
	private Integer parentid;
	private String parentname;
	private String percode;
	private String icon;
	private String perurl;
	private Integer is_dele;

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public Integer getPerid() {
		return perid;
	}

	public void setPerid(Integer perid) {
		this.perid = perid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPerurl() {
		return perurl;
	}

	public void setPerurl(String perurl) {
		this.perurl = perurl;
	}

	public Integer getIs_dele() {
		return is_dele;
	}

	public void setIs_dele(Integer is_dele) {
		this.is_dele = is_dele;
	}

}
