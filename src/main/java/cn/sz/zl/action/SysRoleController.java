package cn.sz.zl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.zl.pojo.Permission;
import cn.sz.zl.pojo.SysRole;
import cn.sz.zl.service.IPermissionService;
import cn.sz.zl.service.ISysRoleService;
import io.lettuce.core.dynamic.annotation.Param;

@Controller
@RequestMapping("/rc")
public class SysRoleController {
	@Autowired
	private ISysRoleService srs;
	@Autowired
	private IPermissionService ps;

	@RequestMapping(value = "findallrole")
	public String queryAllRole(Model model) {
		List<SysRole> rolelist = srs.queryAllRoleWithoutAdmin();
		model.addAttribute("rolelist", rolelist);
		return "pages/frame/uc/sysrolelist";
	}

	@RequestMapping(value = "preaddrole")
	public String preAddRole(Model model) {
		List<Permission> perlist = ps.queryAllPermission();
		model.addAttribute("perlist", perlist);
		return "pages/frame/uc/role_add";
	}

	@RequestMapping(value = "addrole")
	public String addRole(SysRole role, HttpServletRequest request) {
		srs.addSysRole(role);
		Integer roleid = srs.queryRoleByRolename(role.getRolename()).getRoleid();
		String[] pers = request.getParameterValues("hasper");
		for (int i = 0; i < pers.length; i++) {
			if (pers[i] != null) {
				Integer perid = Integer.valueOf(pers[i]);
				Map<String, Integer> rpmap = new HashMap<String, Integer>();
				rpmap.put("roleid", roleid);
				rpmap.put("perid", perid);
				srs.addRoletopermission(rpmap);
			}
		}
		return "redirect:/rc/findallrole";
	}

	@RequestMapping(value = "checkre", method = RequestMethod.POST)
	@ResponseBody
	public Integer checkRepeat(String rolename) {
		return srs.checkRoleRepeat(rolename);
	}

	@RequestMapping(value = "deleterole")
	public String deleteRole(Integer roleid) {
		srs.deleteSysRole(roleid);
		srs.delteusertorole(roleid);
		List<Integer> perlist = srs.queryrPerididByRoleid(roleid);
		for (int i = 0; i < perlist.size(); i++) {
			Map<String, Integer> rpmap = new HashMap<String, Integer>();
			rpmap.put("roleid", roleid);
			rpmap.put("perid", perlist.get(i));
			srs.deleteRoletopermission(rpmap);
		}
		return "redirect:/rc/findallrole";
	}

	@RequestMapping(value = "queryper")
	public String queryPerByRoleid(Integer roleid, Model model) {
		SysRole role = srs.queryRoleByRoleid(roleid);
		List<Permission> perlist = ps.queryPermissionByRoleid(roleid);
		model.addAttribute("role", role);
		model.addAttribute("perlist", perlist);
		return "pages/frame/uc/role_per";
	}

	@RequestMapping(value = "preupdateper")
	public String preUpdateRolePer(@RequestParam("roleid") Integer roleid, Model model) {
		SysRole role = srs.queryRoleByRoleid(roleid);
		List<Permission> oldperlist = ps.queryPermissionByRoleid(roleid);
		List<Permission> perlist = ps.queryAllPermission();
		model.addAttribute("perlist", perlist);
		model.addAttribute("role", role);
		model.addAttribute("oldperlist", oldperlist);
		return "pages/frame/uc/role_update";
	}

	@RequestMapping(value = "updateroleper")
	public String updatePermission(Integer roleid,HttpServletRequest request) {
		List<Integer> oldperlist1 = srs.queryrPerididByRoleid(roleid);// 原角色拥有的权限perid
		for (int i = 0; i < oldperlist1.size(); i++) {
		}
		List<Integer> oldperlist2 = srs.queryrPerididByRoleid(roleid);// 原角色拥有的权限perid
		String[] pers = request.getParameterValues("hasper");// 选择的新权限PERID
		List<Integer> newperlist = new ArrayList<Integer>();// 选择的新权限perid
		for (int i = 0; i < pers.length; i++) {
			if (pers[i] != null) {
				Integer perid = Integer.valueOf(pers[i]);
				newperlist.add(perid);
			}
		}
		if (newperlist.size()>0) {
			// 求差集,oldperlist1与newperlist的差集为需要删除的角色对应权限
			if (oldperlist1.size()>0) {
				oldperlist1.removeAll(newperlist);// 修改roletopermission
				for (int i = 0; i < oldperlist1.size(); i++) {
					Map<String, Integer> rpmap = new HashMap<String, Integer>();
					rpmap.put("roleid", roleid);
					rpmap.put("perid", oldperlist1.get(i));
					srs.deleteRoletopermission(rpmap);
				}
			}
			// 求差集,newperlist与oldperlist2的差集为需要增加的角色对应权限

			if (oldperlist2.size()>0) {
				newperlist.removeAll(oldperlist2);// 增加roletopermission
			}
			for (int i = 0; i < newperlist.size(); i++) {
				Map<String, Integer> rpmap = new HashMap<String, Integer>();
				rpmap.put("roleid", roleid);
				rpmap.put("perid", newperlist.get(i));
				srs.addRoletopermission(rpmap);
			}
		} else {
			if (oldperlist1.size()>0) {
				for (int i = 0; i < oldperlist1.size(); i++) {
					Map<String, Integer> rpmap = new HashMap<String, Integer>();
					rpmap.put("roleid", roleid);
					rpmap.put("perid", oldperlist1.get(i));
					srs.deleteRoletopermission(rpmap);
				}
			}
		}

		return "redirect:/rc/findallrole";
	}
}
