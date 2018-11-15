package cn.sz.zl.util;

import java.io.Serializable;

public class MFenYe implements Serializable {
		//当前页码
		private Integer page;
		//符合要求的记录总数
		private Integer rowCount;
		//每页显示多少条
		private Integer rows=3;
		//一共分多少页
		private Integer pageCount;
		//封装查询条件
		private Query query;
		//当前页码开始条数
		private Integer startRow;
		//当前页码结束条数
		private Integer endRow;
		
		public Integer getPage() {
			return page;
		}
		public void setPage(Integer page) {
			this.page = page;
		}
		public Integer getRowCount() {
			return rowCount;
		}
		public void setRowCount(Integer rowCount) {
			this.rowCount = rowCount;
		}
		public Integer getRows() {
			return rows;
		}
		public void setRows(Integer rows) {
			this.rows = rows;
		}
		public Integer getPageCount() {
			
			if(getRowCount()%getRows()==0) {
				pageCount=getRowCount()/getRows();
			}else {
				pageCount=getRowCount()/getRows()+1;
			}
			if(getRowCount()/getRows()==0) {
				pageCount=1;
			}
			return pageCount;
		}
		public void setPageCount(Integer pageCount) {
			this.pageCount = pageCount;
		}
	
		public Integer getStartRow() {
			startRow=(getPage()-1)*getRows();
			return startRow;
		}
		public void setStartRow(Integer startRow) {
			this.startRow = startRow;
		}
		public Integer getEndRow() {
			endRow=getPage()*getRows();
			return endRow;
		}
		public void setEndRow(Integer endRow) {
			this.endRow = endRow;
		}
		public Query getQuery() {
			return query;
		}
		public void setQuery(Query query) {
			this.query = query;
		}
		
}
