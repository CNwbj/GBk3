package cn.sz.zl.util;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FlowQuery implements Serializable {
	private Integer cp;
	private Integer ps=5;
	private Integer begin;
	private Integer end;
	private Integer type;
	private Integer cpCount;
	private Integer psCount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date first;
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date last;
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public Integer getPs() {
		return ps;
	}
	public void setPs(Integer ps) {
		this.ps = ps;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCpCount() {
		return cpCount;
	}
	public void setCpCount(Integer cpCount) {
		this.cpCount = cpCount;
	}
	public Integer getPsCount() {
		return psCount;
	}
	public void setPsCount(Integer psCount) {
		this.psCount = psCount;
	}
	public Integer getBegin() {
		return cp*ps;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getEnd() {
		return (cp-1)*ps;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public Date getFirst() {
		return first;
	}
	public void setFirst(Date first) {
		this.first = first;
	}
	public Date getLast() {
		return last;
	}
	public void setLast(Date last) {
		this.last = last;
	}
}
