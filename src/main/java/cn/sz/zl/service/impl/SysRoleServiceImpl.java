package cn.sz.zl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.ISysRoleDao;
import cn.sz.zl.pojo.SysRole;
import cn.sz.zl.service.ISysRoleService;

@Service
public class SysRoleServiceImpl implements ISysRoleService {
	@Autowired
	private ISysRoleDao srd;

	public SysRole queryRoleAndPermissionByRoleid(Integer roleid) {
		if (roleid != null && !"".equals(roleid)) {
			return srd.queryRoleAndPermissionByRoleid(roleid);
		}
		return null;
	}

	public List<SysRole> queryAllRoleWithoutAdmin() {
		return srd.queryAllRoleWithoutAdmin();
	}

	@Override
	public void addSysRole(SysRole role) {
		if (role != null) {
			srd.addSysRole(role);
		}
	}

	@Override
	public void addRoletopermission(Map<String, Integer> rmmap) {
		if (!rmmap.isEmpty()) {
			srd.addRoletopermission(rmmap);
		}
	}

	@Override
	public void deleteSysRole(Integer roleid) {
		if (roleid != null && !"".equals(roleid)) {
			srd.deleteSysRole(roleid);
			srd.delteusertorole(roleid);
		}
	}

	@Override
	public SysRole queryRoleByRoleid(Integer roleid) {
		if (roleid != null && !"".equals(roleid)) {
			return srd.queryRoleByRoleid(roleid);
		}
		return null;
	}

	@Override
	public Integer checkRoleRepeat(String rolename) {
		if(rolename!=null&&!"".equals(rolename)) {
			return srd.checkRoleRepeat(rolename);
		}
		return null;
	}

	@Override
	public SysRole queryRoleByRolename(String rolename) {
		if(rolename!=null&&!"".equals(rolename)) {
			return srd.queryRoleByRolename(rolename);
		}
		return null;
	}

	@Override
	public void delteusertorole(Integer roleid) {
		if (roleid != null && !"".equals(roleid)) {
			srd.delteusertorole(roleid);
		}
		
	}

	@Override
	public List<Integer> queryrPerididByRoleid(Integer roleid) {
		if(roleid!=null&&!"".equals(roleid)) {
			return srd.queryrPerididByRoleid(roleid);
		}
		return null;
	}

	@Override
	public void deleteRoletopermission(Map<String, Integer> rpmap) {
		if(rpmap!=null) {
			srd.deleteRoletopermission(rpmap);
		}
	}
}
