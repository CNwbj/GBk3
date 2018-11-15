package cn.sz.zl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.sz.zl.pojo.SysUser;
import cn.sz.zl.util.SysUserSearchCondition;

public interface ISysUserService {
public SysUser checkLogIn(SysUser user);
	
	public SysUser queryUserByLoginname(String loginname);
	
	public List<SysUser> queryAllUser(SysUserSearchCondition usersc);
	
	public Integer countAllUser(SysUserSearchCondition usersc);
	
	public Integer queryRoleidByUserid(Integer userid);
	
	public Integer checkLoginnameRepeat(String loginname);
	
	public void addSysUser(SysUser user);
	
	public void updateSysUser(SysUser user);
	
	public void deleteSysUser(int[] arr);
	
	public SysUser queryUserByUserid(Integer userid);
	
	public void updateUserRole(Integer userid,Integer roleid);
	
	public void addUsertorole(Integer userid,Integer roleid);
}
