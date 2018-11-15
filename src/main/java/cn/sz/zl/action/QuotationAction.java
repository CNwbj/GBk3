package cn.sz.zl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import cn.sz.zl.pojo.C_payment;
import cn.sz.zl.pojo.Customer;
import cn.sz.zl.pojo.Material;
import cn.sz.zl.pojo.Quotation;
import cn.sz.zl.pojo.State;
import cn.sz.zl.pojo.SysRole;

import cn.sz.zl.service.ICustomerService;
import cn.sz.zl.service.IMaterialServce;
import cn.sz.zl.service.IPaymentService;

import cn.sz.zl.service.IStateService;
import cn.sz.zl.service.ISysRoleService;
import cn.sz.zl.service.impl.QuotationServiceImpl;

import cn.sz.zl.util.MFenYe;




@Controller
@RequestMapping("/qa")
public class QuotationAction {
	@Autowired
	private QuotationServiceImpl qs;
	@Autowired
	private IStateService ss;
	@Autowired
	private IMaterialServce ms;
	@Autowired
	private ICustomerService cs;
	@Autowired
	private IPaymentService ps;
	@Autowired
	private ISysRoleService srs;
	//分页
	@RequestMapping("/gofenye")
	public ModelAndView  GoFenYe(MFenYe fy) {
		
		
		System.out.println("enter quotation");
		ModelAndView  model=new ModelAndView ();
		//查询所有报价单信息
		List<Quotation> qtList=qs.queryQuotationByFy(fy);
		//查询所有状态信息
		List<State> statelist=ss.findAllState();
		//查询所有物品信息
		List<Material> materiallist=ms.findAllMaterial();
		//查询所有客户信息
		List<Customer> customlist=cs.findAllCustomer(null);
		//查询所有支付方式
		List<C_payment> paymentlist=ps.findAllPayment();
		//查询所有角色
		List<SysRole> sysrolelist=srs.queryAllRoleWithoutAdmin();
		
		model.addObject("sysrolelist", sysrolelist);
		model.addObject("qtList", qtList);
		model.addObject("statelist",statelist);
		model.addObject("materiallist", materiallist);
		model.addObject("customlist",customlist);
		model.addObject("paymentlist",paymentlist);
		model.addObject("fy", fy);
		model.setViewName("quotation");//设置视图名称
		return model;	
	} 
	//修改状态
/*	@RequestMapping("/updateState")
	public ModelAndView updatestateid(HttpServletRequest request,Model model){
		ModelAndView mv = new ModelAndView();
		String sid6 = request.getParameter("stateid6");
		String  sid22= request.getParameter("stateid22");
		String  sid7= request.getParameter("stateid7");
		Integer stat6 = Integer.parseInt(sid6);
		Integer stat22 = Integer.parseInt(sid22);
		Integer stat7 = Integer.parseInt(sid7);
		qs.updateTJStateById(stat6);
		qs.updateSHStateById(stat22);
		qs.updateSHStateById(stat7);
		mv.setViewName("quotation");
		return mv;
		}
	//查找已审核的报价单
		@RequestMapping("/updatestateid")
		public ModelAndView updatestateid(HttpServletRequest request,Model model){
			ModelAndView mv = new ModelAndView();
			String sid6 = request.getParameter("stateid6");
			String  sid22= request.getParameter("stateid22");
			String  sid7= request.getParameter("stateid7");
			Integer stat6 = Integer.parseInt(sid6);
			Integer stat22 = Integer.parseInt(sid22);
			Integer stat7 = Integer.parseInt(sid7);
			qs.updateTJStateById(stat6);
			qs.updateSHStateById(stat22);
			qs.updateSHStateById(stat7);
			mv.setViewName("quotation");
			return mv;
			}
	*/
	
/*	//修改
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateJump(Integer quotationid,Model model){
		
		
		Quotation quotation=qs.findQuotationById(quotationid);
		
		List<Material> materiallist=ms.findAllMaterial();
		List<Customer> customlist=cs.findAllCustomer(null);
		List<State> statelist=ss.findAllState();
		List<C_payment> paymentlist=ps.findAllPayment();
	
		System.out.println(quotation);
		
		
		model.addAttribute("quotation", quotation);
		model.addAttribute("statelist", statelist);
		model.addAttribute("materiallist", materiallist);
		model.addAttribute("customlist", customlist);
		model.addAttribute("paymentlist", paymentlist);
		return "updateQuotation";
	
	}*/
	/*@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateJump(Quotation quotation,Model model){
			
			boolean flag=qs.UpdateQuotation(quotation);
	
			if(flag==true){
				return "redirect:gofenye";
			}else{
				model.addAttribute("msg", "修改失败");
				return "updateQuotation";
			}			
	}
	//删除
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteJump(Integer quotationid,Model model){
		//boolean flag=wuziServiceImpl.deletewuzi(wuziid);
		boolean flag=qs.deleteQuotation(quotationid);
		if(flag==true){
			return "redirect:gofenye";
		}else{
			model.addAttribute("msg", "删除失败");
			return "redirect:gofenye";
		}				
	}*/
	
}
