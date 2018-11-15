package cn.sz.zl.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.zl.pojo.Dept;
import cn.sz.zl.service.IDeptService;

@Controller
@RequestMapping("/dc")
public class DeptController {
	@Autowired
	private IDeptService ds;

	@RequestMapping(value = "alldept")
	public String allDept(Model model) {
		List<Dept> deptlist = ds.queryAllDeptandUserCount();
		model.addAttribute("deptlist", deptlist);
		return "pages/frame/uc/dept_list";
	}

	@RequestMapping(value = "preadddept")
	public String preAddDept() {
		return "pages/frame/uc/dept_add";
	}

	@RequestMapping(value = "adddept")
	public String addDept(Dept dept) {
		System.out.println(dept.getDname()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ds.addDept(dept);
		return "redirect:/dc/alldept";
	}

	@RequestMapping(value = "checkre")
	@ResponseBody
	public Integer checkDeptRe(String dname) {
		return ds.checkDeptre(dname);
	}

}
