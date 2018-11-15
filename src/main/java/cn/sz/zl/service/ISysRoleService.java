package cn.sz.zl.service;

import java.util.List;
import java.util.Map;

import cn.sz.zl.pojo.SysRole;

public interface ISysRoleService {
	
	public SysRole queryRoleAndPermissionByRoleid(Integer roleid);
	
	public SysRole queryRoleByRoleid(Integer roleid);

	public List<SysRole> queryAllRoleWithoutAdmin();

	public void addSysRole(SysRole role);
	
	public Integer checkRoleRepeat(String pname);
	
	public SysRole queryRoleByRolename(String rolename);

	public void addRoletopermission(Map<String, Integer> rmmap);
	
	public void deleteSysRole(Integer roleid);
	
	public void delteusertorole(Integer roleid);
	
	public List<Integer> queryrPerididByRoleid(Integer roleid);
	
	public void deleteRoletopermission(Map<String,Integer> rpmap);
}
