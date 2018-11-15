package cn.sz.zl.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.zl.pojo.Dept;
import cn.sz.zl.pojo.SysRole;
import cn.sz.zl.pojo.SysUser;
import cn.sz.zl.service.IDeptService;
import cn.sz.zl.service.ISysRoleService;
import cn.sz.zl.service.ISysUserService;
import cn.sz.zl.util.RandomCodeGenerator;
import cn.sz.zl.util.SysUserSearchCondition;

@Controller
@RequestMapping("/uc")
public class SysUserController {
	@Autowired
	private ISysUserService sus;
	@Autowired
	private IDeptService ds;
	@Autowired
	private ISysRoleService rs;

	@RequestMapping("/getVerifyCode")
	public void generate(HttpServletResponse response, HttpSession session) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		RandomCodeGenerator codeUtil = new RandomCodeGenerator();
		String verifyCodeValue = codeUtil.drawImg(output);
		System.out.println(verifyCodeValue);
		session.setAttribute("verifyCode", verifyCodeValue);
		try {
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "islogin")
	public String checkLogIn(SysUser user, HttpSession session, @RequestParam("code") String code) {
		Subject subject = SecurityUtils.getSubject();
		String verifyCode= (String) session.getAttribute("verifyCode");
        if(!code.equalsIgnoreCase(verifyCode)){
            return "redirect:/uc/logout";
        }

		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginname(), user.getLoginpwd());
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			return "403";
		} catch (IncorrectCredentialsException e) {
			return "500";
		}
		return "pages/main";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {

		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "index";
	}

	@RequestMapping(value = "preadduser")
	public String preAddUser(Model model) {
		List<Dept> deptlist = ds.queryAllDept();
		List<SysRole> rolelist = rs.queryAllRoleWithoutAdmin();

		model.addAttribute("deptlist", deptlist);
		model.addAttribute("rolelist", rolelist);
		return "pages/frame/uc/user_add";
	}

	@RequestMapping(value = "adduser")
	public String addUser(SysUser user,@RequestParam("roleid") Integer roleid) {
		if (user != null) {
			sus.addSysUser(user);
			SysUser theuser=sus.queryUserByLoginname(user.getLoginname());
			sus.addUsertorole(theuser.getUserid(),roleid);
		}
		return "redirect:/uc/findusersplit";
	}

	@RequestMapping(value = "deleteuser")
	public String deleteUser(int[] arr) {
		sus.deleteSysUser(arr);
		return "redirect:/uc/findusersplit";
	}

	@RequestMapping(value = "prechangerole")
	public String preupdateUser(Integer userid, Model model) {
		List<SysRole> rolelist = rs.queryAllRoleWithoutAdmin();
		SysUser user = sus.queryUserByUserid(userid);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("user", user);
		return "pages/frame/uc/changerole";
	}

	@RequestMapping(value = "updaterole")
	public String updateUser(Integer userid, Integer roleid) {
		sus.updateUserRole(userid, roleid);
		return "redirect:/uc/findusersplit";
	}

	@RequestMapping(value = "preupdate")
	public String preUpdateUser(Integer userid, Model model) {
		SysUser user = sus.queryUserByUserid(userid);
		List<Dept> deptlist = ds.queryAllDept();
		model.addAttribute("deptlist", deptlist);
		model.addAttribute("user", user);
		return "pages/frame/uc/user_update";
	}

	@RequestMapping(value = "updateuser")
	public String updateUser(SysUser user) {
		sus.updateSysUser(user);
		return "redirect:/uc/findusersplit";
	}

	@RequestMapping(value = "checkre", method = RequestMethod.POST)
	@ResponseBody
	public Integer checkRepeat(String loginname) {
		return sus.checkLoginnameRepeat(loginname);
	}

	@RequestMapping(value = "findusersplit", method = RequestMethod.GET)
	public String findUserSplit(SysUserSearchCondition usersc, Model model) {
		Integer cp = 1, ps = 5;
		usersc.setLoginname(null);
		usersc.setIs_dele(null);
		usersc.setDeptno(null);
		usersc.setRoleid(null);
		usersc.setStart((cp - 1) * ps);
		usersc.setEnd(cp * ps);
		List<SysUser> userlist = sus.queryAllUser(usersc);
		List<Dept> deptlist = ds.queryAllDept();
		List<SysRole> rolelist = rs.queryAllRoleWithoutAdmin();
		int count = sus.countAllUser(usersc);//
		int allpage = (count - 1) / ps + 1;//
		model.addAttribute("cp", cp);
		model.addAttribute("ps", ps);
		model.addAttribute("userlist", userlist);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("deptlist", deptlist);
		model.addAttribute("count", count);
		model.addAttribute("allpage", allpage);
		return "pages/frame/uc/user_list";
	}

	@RequestMapping(value = "findusersplitBySc", method = RequestMethod.POST)
	public String findUserSplitByCondition(HttpServletRequest request, Model model) {
		SysUserSearchCondition usersc = new SysUserSearchCondition();
		Integer cp = 1, ps = 5;
		String cpvalue = request.getParameter("cp");
		if (cpvalue != null && !cpvalue.equals("")) {
			cp = Integer.valueOf(cpvalue);
		}
		String ln = request.getParameter("loginname");
		String loginname = "".equals(ln) || ln == null ? null : ln;
		
		String isdele = request.getParameter("is_dele");
		String isd = "".equals(isdele) || isdele == null ? null : isdele;

		String de = request.getParameter("deptno");
		String dep = "".equals(de) || de == null ? null : de;
		
		String ro = request.getParameter("roleid");
		String role = "".equals(ro) || ro == null ? null : ro;

		Integer is_dele = null;
		if (isd != null) {
			is_dele = Integer.parseInt(isd);
		}
		Integer deptno = null;
		if (dep != null) {
			deptno = Integer.parseInt(dep);
		}
		Integer roleid = null;
		if (role != null) {
			usersc.setRoleid(roleid);
		}

		usersc.setLoginname(loginname);
		usersc.setIs_dele(is_dele);
		usersc.setDeptno(deptno);
		usersc.setRoleid(roleid);
		usersc.setStart((cp - 1) * ps);
		usersc.setEnd(cp * ps);

		List<Dept> deptlist = ds.queryAllDept();
		List<SysUser> userlist = sus.queryAllUser(usersc);
		List<SysRole> rolelist = rs.queryAllRoleWithoutAdmin();
		int count = sus.countAllUser(usersc);
		int allpage = (count - 1) / ps + 1;
		model.addAttribute("cp", cp);
		model.addAttribute("ps", ps);
		model.addAttribute("userlist", userlist);
		model.addAttribute("deptlist", deptlist);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("count", count);
		model.addAttribute("usersc", usersc);
		model.addAttribute("allpage", allpage);
		return "pages/frame/uc/user_list";
	}
}
