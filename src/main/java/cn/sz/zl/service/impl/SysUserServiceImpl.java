package cn.sz.zl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IPermissionDao;
import cn.sz.zl.dao.ISysUserDao;
import cn.sz.zl.pojo.Permission;
import cn.sz.zl.pojo.SysRole;
import cn.sz.zl.pojo.SysUser;
import cn.sz.zl.service.ISysUserService;
import cn.sz.zl.util.SysUserSearchCondition;

@Service
public class SysUserServiceImpl implements ISysUserService {
	@Autowired
	private ISysUserDao sud;
	@Autowired
	private IPermissionDao pd;

	public SysUser checkLogIn(SysUser user) {
		if (user != null) {
			SysUser su = sud.checkLogIn(user);
			if (su != null && su.checkRole()) {
				List<Permission> perlist = pd.queryAllPermission();
				SysRole role = su.getSysrole();
				role.setPerlist(perlist);
				su.setSysrole(role);
			}
			return su;
		}
		return null;
	}

	public SysUser queryUserByLoginname(String loginname) {
		if (loginname != null && !"".equals(loginname)) {
			SysUser su = sud.queryUserByLoginname(loginname);
			if (su != null && su.checkRole()) {
				List<Permission> perlist = pd.queryAllPermission();
				SysRole role = su.getSysrole();
				role.setPerlist(perlist);
				su.setSysrole(role);
			}
			return su;
		}
		return null;

	}

	public List<SysUser> queryAllUser(SysUserSearchCondition usersc) {
		return sud.queryAllUser(usersc);
	}

	public Integer countAllUser(SysUserSearchCondition usersc) {
		return sud.countAllUser(usersc);
	}

	public Integer queryRoleidByUserid(Integer userid) {

		return sud.queryRoleidByUserid(userid);
	}

	@Override
	public Integer checkLoginnameRepeat(String loginname) {
		if (loginname != null) {
			return sud.checkLoginnameRepeat(loginname);
		}
		return null;
	}

	@Override
	public void addSysUser(SysUser user) {
		sud.addSysUser(user);

	}

	@Override
	public void updateSysUser(SysUser user) {
		sud.updateSysUser(user);

	}

	@Override
	public void deleteSysUser(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			sud.deleteSysUser(arr[i]);//修改员工的状态
			sud.deleteUsertorole(arr[i]);//修改员工对应角色表状态
		}
	}
	
	@Override
	public SysUser queryUserByUserid(Integer userid) {
		if(userid!=null&&!"".equals(userid)) {
			return sud.queryUserByUserid(userid);
		}
		return null;
	}

	@Override
	public void updateUserRole(Integer userid, Integer roleid) {
		if(userid!=null&&!"".equals(userid)&&roleid!=null&&!"".equals(roleid)) {
			Map<String,Integer> urmap = new HashMap<String,Integer>();
			urmap.put("userid", userid);
			urmap.put("roleid", roleid);
			sud.updateUserRole(urmap);
		}
	}

	@Override
	public void addUsertorole(Integer userid,Integer roleid) {
		if(userid!=null&&!"".equals(userid)&&roleid!=null&&!"".equals(roleid)) {
			Map<String,Integer> urmap = new HashMap<String,Integer>();
			urmap.put("userid", userid);
			urmap.put("roleid", roleid);
			sud.addUsertorole(urmap);
		}
	}
}
