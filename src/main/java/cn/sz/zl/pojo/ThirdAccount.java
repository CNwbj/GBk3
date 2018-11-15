package cn.sz.zl.pojo;

import java.io.Serializable;

public class ThirdAccount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer t_id;
	private Integer money;
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
}
