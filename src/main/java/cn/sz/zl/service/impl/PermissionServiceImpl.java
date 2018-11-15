package cn.sz.zl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IPermissionDao;
import cn.sz.zl.pojo.Permission;
import cn.sz.zl.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private IPermissionDao pd;

	@Override
	public List<Permission> queryPermissionByRoleid(Integer roleid) {
		if (roleid != null && !"".equals(roleid)) {
			return pd.queryPermissionByRoleid(roleid);
		}
		return null;
	}

	@Override
	public List<Permission> queryPermissionByLoginname(String loginname) {
		if (loginname != null && !"".equals(loginname)) {
			return pd.queryPermissionByloginname(loginname);
		}
		return null;
	}

	@Override
	public List<String> queryAllURL() {
		return pd.queryAllURL();
	}

	@Override
	public void addPermission(Permission permission) {
		if (permission != null) {
			pd.addPermission(permission);
		}
	}

	@Override
	public Integer checkPerReByName(String pname) {
		if (pname != null && !"".equals(pname)) {
			return pd.checkPerReByName(pname);
		}
		return null;
	}

	@Override
	public void deletePermission(Integer perid) {
		if (perid != null && !"".equals(perid)) {
			pd.deletePermission(perid);
		}
	}

	@Override
	public List<Permission> queryAllPermissionSplit(Map<String, Integer> map) {
		return pd.queryAllPermissionSplit(map);
	}

	@Override
	public List<Permission> queryAllPermission() {
		return pd.queryAllPermission();
	}

	@Override
	public Integer countAllPermission() {
		return pd.countAllPermission();
	}

	@Override
	public Integer queryPeridByPname(String pname) {
		if(pname!=null&&!"".equals(pname)) {
			return pd.queryPeridByPname(pname);
		}
		return null;
	}

}
