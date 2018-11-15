package cn.sz.zl.util;

import java.util.Date;

public class Excellent {
	//关键字
		private String linchpin;
		//分页数
		private Integer pagination;
		//当前页码数
		private Integer ps=3;
	//m下拉框
		private Integer state;
		
		private Integer start;
		
		private Integer end;
		
		//价格最小
		private String sprice;
		//价格最大
		private String tprice;
		
		private Date startTime;
		//价格最大
		private Date StopTime;
		
		public String getLinchpin() {
			return linchpin;
		}
		public void setLinchpin(String linchpin) {
			this.linchpin = linchpin;
		}
		public Integer getPagination() {
			return pagination;
		}
		public void setPagination(Integer pagination) {
			this.pagination = pagination;
		}
		public String getSprice() {
			return sprice;
		}
		public void setSprice(String sprice) {
			this.sprice = sprice;
		}
		public String getTprice() {
			return tprice;
		}
		public void setTprice(String tprice) {
			this.tprice = tprice;
		}
		public Integer getStart() {
			return  (pagination-1)*ps;
		}
		
		public Integer getEnd() {
			return pagination*ps;
		}
		public void setEnd(Integer end) {
			this.end = end;
		}
		public Integer getPs() {
			return ps;
		}
		public void setPs(Integer ps) {
			this.ps = ps;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getStopTime() {
			return StopTime;
		}
		public void setStopTime(Date stopTime) {
			StopTime = stopTime;
		}
		public Integer getState() {
			return state;
		}
		public void setState(Integer state) {
			this.state = state;
		}
	
		
		
		
		
		
		
}
