package cn.sz.zl.pojo;

import java.io.Serializable;

public class CustomService implements Serializable {
	private Integer customServiceid;
	private String customServicename;
	public Integer getCustomServiceid() {
		return customServiceid;
	}
	public void setCustomServiceid(Integer customServiceid) {
		this.customServiceid = customServiceid;
	}
	public String getCustomServicename() {
		return customServicename;
	}
	public void setCustomServicename(String customServicename) {
		this.customServicename = customServicename;
	}
	
}
