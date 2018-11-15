package cn.sz.zl.service;

import java.util.List;
import java.util.Map;

import cn.sz.zl.pojo.Permission;

public interface IPermissionService {
public List<Permission> queryPermissionByRoleid(Integer roleid);
	
	public List<Permission> queryPermissionByLoginname(String loginname);
	
	public List<Permission> queryAllPermission();
	
	public Integer countAllPermission();
	
	public List<Permission> queryAllPermissionSplit(Map<String,Integer> map);
	
	public List<String> queryAllURL();
	
	public void addPermission(Permission permission);
	
	public Integer checkPerReByName(String pname);
	
	public void deletePermission(Integer perid);
	
	public Integer queryPeridByPname(String pname);
}
