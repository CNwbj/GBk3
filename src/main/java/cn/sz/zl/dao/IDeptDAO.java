package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Dept;
@Mapper
public interface IDeptDao {
	
	public List<Dept> queryAllDept();

	public Dept queryDeptByDeptno(Integer deptno);
	
	public void addDept(Dept dept);
	
	public List<Dept> queryAllDeptandUserCount();
	
	public Integer checkDeptre(String dname);
	
}
