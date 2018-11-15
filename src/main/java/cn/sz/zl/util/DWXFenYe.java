package cn.sz.zl.util;

import java.io.Serializable;

import cn.sz.zl.query.DWXQuery;

public class DWXFenYe implements Serializable {

	//当前页面
	private Integer page ;//
	//总页码数
	private Integer pageCount;
	//每页显示条数
	private Integer rows=3;
	//符合要求的记录总数
	private Integer rowCount;
	//当前页码开始条
	private Integer rowStart;
	//当前页面结束条
	private Integer rowEnd;
      
    private DWXQuery query; //查询条件

    public DWXFenYe() {
        
      }
   
      public Integer getPage() {
  		return page;
  	}
  	public void setPage(Integer page) {
  		this.page = page;
  	}
  	public Integer getPageCount() {
  		if(getRowCount()%getRows()==0) {
  			pageCount=getRowCount()/getRows();
  		}else {
  			pageCount=getRowCount()/getRows()+1;
  		}
  		if(getRowCount()/getRows()==0) {//page=1   pageCount=0
  			pageCount=1;
  		}
  		return pageCount;
  	}
  	public void setPageCount(Integer pageCount) {
  		this.pageCount = pageCount;
  	}
  	public Integer getRows() {
  		return rows;
  	}
  	public void setRows(Integer rows) {
  		this.rows = rows;
  	}
  	public Integer getRowCount() {
  		return rowCount;
  	}
  	public void setRowCount(Integer rowCount) {
  		this.rowCount = rowCount;
  	}
  	public Integer getRowStart() {
  		rowStart=((getPage()-1)*getRows());
  		return rowStart;
  	}
  	public void setRowStart(Integer rowStart) {
  		this.rowStart = rowStart;
  	}
  	public Integer getRowEnd() {
  		rowEnd=getPage()*getRows();
  		return rowEnd;
  	}
  	public void setRowEnd(Integer rowEnd) {
  		this.rowEnd = rowEnd;
  	}

	public DWXQuery getQuery() {
		return query;
	}

	public void setQuery(DWXQuery query) {
		this.query = query;
	}





      
}
