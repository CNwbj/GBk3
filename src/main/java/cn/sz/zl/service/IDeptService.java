package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.Dept;

public interface IDeptService {
	public List<Dept> queryAllDept();

	public Dept queryDeptByDeptno(Integer deptno);
	
	public void addDept(Dept dept);
	
	public List<Dept> queryAllDeptandUserCount();
	
	public Integer checkDeptre(String dname);
	
}
