package cn.sz.zl.pojo;

import java.io.Serializable;
/**
 * 客户学历实体类
 * @author Administrator
 *
 */
public class Education implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer c_eduid ;
     private String c_educational ;
	public Integer getC_eduid() {
		return c_eduid;
	}
	public void setC_eduid(Integer c_eduid) {
		this.c_eduid = c_eduid;
	}
	public String getC_educational() {
		return c_educational;
	}
	public void setC_educational(String c_educational) {
		this.c_educational = c_educational;
	}
     
}
