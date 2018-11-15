package cn.sz.zl.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.pojo.Permission;
import cn.sz.zl.pojo.SysUser;
import cn.sz.zl.service.IPermissionService;
import cn.sz.zl.service.ISysRoleService;
import cn.sz.zl.service.ISysUserService;

@Service
public class UserPriRealm extends AuthorizingRealm {

	@Autowired
	private ISysUserService userService;
	@Autowired
	private IPermissionService ps;
	@Autowired
	private ISysRoleService rs;
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String loginname = (String) principal.getPrimaryPrincipal();

		SysUser u = userService.queryUserByLoginname(loginname);
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Integer roleid=userService.queryRoleidByUserid(u.getUserid());
		info.addRole(rs.queryRoleAndPermissionByRoleid(roleid).getRolename());
		List<Permission> prilist = ps.queryPermissionByLoginname(u.getLoginname());

		List<String> urls = new ArrayList<String>();
		for (int i = 0; i < prilist.size(); i++) {
			Permission pri = prilist.get(i);
			if (pri.getPerurl() != null) {
				urls.add(pri.getPerurl());
			}
		}

		info.addStringPermissions(urls);

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken atoken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) atoken;

		String loginname = (String) token.getPrincipal();
		
		SysUser u = userService.queryUserByLoginname(loginname);
		if (u == null) {
			throw new UnknownAccountException("账号密码错误");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginname, u.getLoginpwd(),
				this.getClass().getName());

		Subject sub = SecurityUtils.getSubject();
		Session session = sub.getSession();
		session.setAttribute("currentUser", loginname);

		return info;
	}

}
