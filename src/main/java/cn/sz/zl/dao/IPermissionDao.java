package cn.sz.zl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Permission;
@Mapper
public interface IPermissionDao {
	
	public List<Permission> queryPermissionByRoleid(Integer roleid);
	
	public List<Permission> queryPermissionByloginname(String loginname);
	
	public List<Permission> queryAllPermission();
	
	public List<Permission> queryAllPermissionSplit(Map<String,Integer> map);
	
	public Integer countAllPermission();
	
	public List<String> queryAllURL();
	
	public void addPermission(Permission permission);
	
	public Integer checkPerReByName(String pname);
	
	public void deletePermission(Integer perid);
	
	public Integer queryPeridByPname(String pname);
}
