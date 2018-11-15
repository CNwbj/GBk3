package cn.sz.zl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.SysUser;
import cn.sz.zl.util.SysUserSearchCondition;

@Mapper
public interface ISysUserDao {
	
	public SysUser checkLogIn(SysUser user);
	
	public SysUser queryUserByLoginname(String loginname);
	
	public List<SysUser> queryAllUser(SysUserSearchCondition usersc);
	
	public Integer countAllUser(SysUserSearchCondition usersc);
	
	public Integer queryRoleidByUserid(Integer userid);
	
	public Integer checkLoginnameRepeat(String loginname);
	
	public void addSysUser(SysUser user);
	
	public void updateSysUser(SysUser user);
	
	public void deleteSysUser(Integer userid);
	
	public void deleteUsertorole(Integer userid);
	
	public SysUser queryUserByUserid(Integer userid);
	
	public void updateUserRole(Map<String, Integer> urmap);
	
	public void addUsertorole(Map<String, Integer> urmap);
}
