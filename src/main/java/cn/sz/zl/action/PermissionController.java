package cn.sz.zl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.zl.pojo.Permission;
import cn.sz.zl.service.IPermissionService;
import cn.sz.zl.service.ISysRoleService;

@Controller
@RequestMapping("/pc")
public class PermissionController {
	@Autowired
	private IPermissionService ps;
	@Autowired
	private ISysRoleService srs;

	@RequestMapping(value = "findPriByLoginname")
	public String queryPermissionByLoginname(Model model) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String loginname = (String) session.getAttribute("currentUser");

		List<Permission> perlist = ps.queryPermissionByLoginname(loginname);
		model.addAttribute("perlist", perlist);
		model.addAttribute("loginname", loginname);
		return "pages/frame/left";
	}

	@RequestMapping(value = "allper")
	public String queryAllPer(HttpServletRequest request, Model model) {
		Integer cp = 1, pss = 5;
		String cpvalue = request.getParameter("cp");
		if (cpvalue != null && !cpvalue.equals("")) {
			cp = Integer.valueOf(cpvalue);
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", (cp - 1) * pss);
		map.put("end", cp * pss);
		List<Permission> perlist = ps.queryAllPermissionSplit(map);
		Integer count = ps.countAllPermission();
		int allpage = (count - 1) / pss + 1;
		model.addAttribute("cp", cp);
		model.addAttribute("ps", ps);
		model.addAttribute("count", count);
		model.addAttribute("allpage", allpage);
		model.addAttribute("perlist", perlist);
		return "pages/frame/uc/permission_list";
	}

	@RequestMapping(value = "checkre")
	@ResponseBody
	public Integer checkRe(String pername) {
		return ps.checkPerReByName(pername);
	}

	@RequestMapping(value = "deleteper")
	public String deletePer(Integer perid) {
		ps.deletePermission(perid);
		return "redirect:/pc/allper";
	}

	@RequestMapping(value = "preaddper")
	public String preAddPer(Model model) {
		List<Permission> perlist = ps.queryAllPermission();
		model.addAttribute("perlist", perlist);
		return "pages/frame/uc/permission_add";
	}

	@RequestMapping(value = "addper")
	public String addPer(Permission permission) {
		ps.addPermission(permission);
		Integer perid=ps.queryPeridByPname(permission.getPname());
		Map<String,Integer> rpmap=new HashMap<String,Integer>();
		rpmap.put("roleid", 1);
		rpmap.put("perid", perid);
		srs.addRoletopermission(rpmap);
		return "redirect:/pc/allper";
	}

}