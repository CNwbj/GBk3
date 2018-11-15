package cn.sz.zl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.zl.pojo.C_payment;
import cn.sz.zl.pojo.Customer;
import cn.sz.zl.pojo.Material;
import cn.sz.zl.pojo.Quotation;
import cn.sz.zl.pojo.TalkPrice;
import cn.sz.zl.service.ICustomerService;
import cn.sz.zl.service.IMaterialServce;
import cn.sz.zl.service.IPaymentService;
import cn.sz.zl.service.ITalkPriceService;





@Controller
@RequestMapping("/tpa")
public class TalkPriceAction {
	/**
	 * 添加回复
	 * @return
	 */
	@Autowired
	private IMaterialServce ms;
	@Autowired
	private ITalkPriceService tps;
	@Autowired
	private ICustomerService cs;
	@Autowired
	private IPaymentService ps;
	
	@RequestMapping(value="/itbp",method=RequestMethod.POST)
	@ResponseBody
	public String IsTrueByPrice(HttpServletRequest request) {
		String customerprice = request.getParameter("customerprice");
		String materialid=request.getParameter("material_id");
		
		Double cprice = Double.parseDouble(customerprice);		
		Integer id=Integer.parseInt(materialid);
		
		String c_paymentid = request.getParameter("c_paymentid");
		String c_id=request.getParameter("c_id");
		
		
		Integer paymentid=Integer.parseInt(c_paymentid);
		Integer cid=Integer.parseInt(c_id);
		
		
		C_payment c_payment =ps.findPaymentById(paymentid);
		
		Material material=ms.findMaterialInfoById(id);
		double money=material.getMaterial_price();
		
		TalkPrice talkprice=new TalkPrice();
		talkprice.setC_id(cid);
		talkprice.setMaterial_id(id);
		talkprice.setQ_price(cprice);
		
		if(money*0.9<cprice) {
			//return "true";
			//无返回
			talkprice.setStateid(14);//价格通过审核
			tps.insertTalkPrice(talkprice);
			return "true";
		}else {
			talkprice.setStateid(15);//价格未通过审核
			tps.insertTalkPrice(talkprice);
			return "false";
		}

	}
/*	//添加
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String addJump(TalkPrice talkprice){
		boolean flag=tps.insertTalkPrice(talkprice);
		
		if(flag==true){
			return "add";
		}
		return null;		
	}*/
	/*
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String addJump(Model model){	
		List<Material> materiallist=ms.findAllMaterial();
		//查询所有客户信息
		List<TalkPrice>  talkpricelist=tps.findAllTalkPrice();
		List<Customer> customlist=cs.findAllCustomer(null);
		//查询所有支付方式
		List<C_payment> paymentlist=ps.findAllPayment();
		model.addAttribute("talkpricelist", talkpricelist);
		model.addAttribute("materiallist", materiallist);
		model.addAttribute("customlist", customlist);
		model.addAttribute("paymentlist", paymentlist);
		return "add";		
	}*/
	
	
	
	
}
