package cn.sz.zl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.SysRole;

@Mapper
public interface ISysRoleDao {

	public SysRole queryRoleAndPermissionByRoleid(Integer roleid);
	
	public SysRole queryRoleByRoleid(Integer roleid);

	public List<SysRole> queryAllRoleWithoutAdmin();

	public void addSysRole(SysRole role);
	
	public SysRole queryRoleByRolename(String rolename);

	public Integer checkRoleRepeat(String pname);
	
	public void addRoletopermission(Map<String, Integer> rmmap);

	public void deleteSysRole(Integer roleid);

	public void delteusertorole(Integer roleid);
	
	public void deleteRoletopermission(Map<String,Integer> rpmap);
	
	public List<Integer> queryrPerididByRoleid(Integer roleid);
}
