package cn.sz.zl.util;



public class FHFenYe {
	
	// current page
	private Integer cp = 1;
	// page show rows
	private Integer ps = 4;
	// data count
	private Integer allCount;
	
	// count pages
	private Integer allPage;
	//sql dml start rows
	private Integer startRows;
	//sql dml stop rows
	private Integer stopRows;
	//other use
	private Boolean flag=true;//default true
	//query class

		
	public Integer getCp() {
		return cp;
	}
	public Integer getPs() {
		return ps;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public Integer getAllCount() {
		return allCount;
	}
	public Integer getAllPage() {
		if(allCount!=null&&ps!=null&&ps!=0) {
			return (allCount-1)/ps+1;
		}
		return allPage;
	}
	public Integer getStartRows() {
		if(cp!=null&&ps!=null&&cp!=0&&ps!=0) {
			return (cp-1)*ps;
		}
		return startRows;
	}
	public Integer getStopRows() {
		if(cp!=null&&ps!=null&&cp!=0&&ps!=0) {
			return cp*ps;
		}
		return stopRows;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public void setPs(Integer ps) {
		this.ps = ps;
	}
	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}
	
}
