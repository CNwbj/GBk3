package cn.sz.zl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sz.zl.pojo.C_payment;
import cn.sz.zl.pojo.Customer;
import cn.sz.zl.pojo.Material;
import cn.sz.zl.pojo.Sale;
import cn.sz.zl.query.DWXQuery;
import cn.sz.zl.service.IC_paymentService;
import cn.sz.zl.service.ICustomerService;
import cn.sz.zl.service.IMaterialServce;
import cn.sz.zl.service.ISaleService;
import cn.sz.zl.util.CustomerSearchCondition;
import cn.sz.zl.util.DWXFenYe;
import cn.sz.zl.util.Excellent;
import cn.sz.zl.util.TestSMS;

@Controller
@RequestMapping("ca")
public class CustomerAction {
	private Logger log = Logger.getLogger(FHController.class);
	@Autowired
	private ICustomerService customerServiceImpl;
	@Autowired
	private IMaterialServce materialServiceImpl;
	@Autowired
	private IMaterialServce MaterilaService;
	@Autowired
	private IC_paymentService c_paymentService;
	@Autowired
	private ISaleService iSaleServiceImpl;
	
	String yzm = null;
	@RequestMapping(value = "findcussplit", method = RequestMethod.GET)
	public String queryAllCus(CustomerSearchCondition cusc, Model model) {
		Integer cp = 1, ps = 5;
		cusc.setC_mail(null);
		cusc.setC_phone(null);
		cusc.setC_sex(null);
		cusc.setStateid(null);
		cusc.setStart((cp - 1) * ps);
		cusc.setEnd(cp * ps);

		List<Customer> cuslist = customerServiceImpl.findAllCustomer(cusc);
		int count = customerServiceImpl.CountAllCus(cusc);
		int allpage = (count - 1) / ps + 1;//
		model.addAttribute("cp", cp);
		model.addAttribute("ps", ps);
		model.addAttribute("cuslist", cuslist);
		model.addAttribute("count", count);
		model.addAttribute("allpage", allpage);
		return "pages/frame/uc/cus_list";
	}

	@RequestMapping(value = "findcussplitbysc", method = RequestMethod.POST)
	public String queryAllCusByCondition(HttpServletRequest request, Model model) {
		CustomerSearchCondition cusc = new CustomerSearchCondition();
		Integer cp = 1, ps = 5;
		String cpvalue = request.getParameter("cp");
		if (cpvalue != null && !cpvalue.equals("")) {
			cp = Integer.valueOf(cpvalue);
		}
		String sex = request.getParameter("c_sex");
		String c_sex = "".equals(sex) || sex == null ? null : sex;
		String phone = request.getParameter("c_phone");
		String c_phone = "".equals(phone) || phone == null ? null : phone;
		String mail = request.getParameter("c_mail");
		String c_mail = "".equals(mail) || mail == null ? null : mail;

		String isdele = request.getParameter("stateid");
		String isd = "".equals(isdele) || isdele == null ? null : isdele;

		Integer stateid = null;
		if (isd != null) {
			stateid = Integer.parseInt(isd);
		}

		cusc.setC_mail(c_mail);
		cusc.setC_phone(c_phone);
		cusc.setC_sex(c_sex);
		cusc.setStateid(stateid);
		cusc.setStart((cp - 1) * ps);
		cusc.setEnd(cp * ps);

		List<Customer> cuslist = customerServiceImpl.findAllCustomer(cusc);
		int count = customerServiceImpl.CountAllCus(cusc);
		int allpage = (count - 1) / ps + 1;//
		model.addAttribute("cp", cp);
		model.addAttribute("ps", ps);
		model.addAttribute("cuslist", cuslist);
		model.addAttribute("count", count);
		model.addAttribute("cusc", cusc);
		model.addAttribute("allpage", allpage);
		return "pages/frame/uc/cus_list";
	}

	@RequestMapping(value = "disablecus")
	public String disableCus(Integer c_id) {
		customerServiceImpl.disableCustomer(c_id);
		return "redirect:/ca/findcussplit";
	}

	@RequestMapping(value = "ablecus")
	public String ableCus(Integer c_id) {
		customerServiceImpl.ablCustomer(c_id);
		return "redirect:/ca/findcussplit";
	}
	

	//注册
	@RequestMapping(value="register.action",method=RequestMethod.POST)
	public ModelAndView register(Customer customer) {
		ModelAndView mv = new ModelAndView();
		
		customerServiceImpl.customerRegister(customer);
		mv.setViewName("login_in");
		return mv;
	}
	
	
	
	//登录
	@RequestMapping(value="customer_login.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String ,Object> login(HttpServletRequest request, HttpSession session){
			Customer c = new Customer();
			String name = request.getParameter("c_name");
			//System.out.println(name);
			if (name.length()==11) {
				c.setC_phone(name);
			}else {
				c.setC_name(name);
			}
			Map<String,Object> json=new HashMap<String,Object>();
			Customer customer = customerServiceImpl.findCustomer(c);
			if (customer!=null) {
				if(customer.getStateid()==11) {
					json.put("flag", "jinyong");
					return json;
				}
				json.put("flag", true);
				//开启会话
				session.setAttribute("customer", customer);
			}else {
				json.put("flag", false);
			}
			return json;
	}
	
/*	//登录成功跳转至前
	@RequestMapping(value="customer_show.action",method=RequestMethod.GET)
	public String show() {
		
		return "cate_pencil";
	}*/
	//跳转至客户找好找回密码页面
	@RequestMapping(value="pwd_back.action",method=RequestMethod.GET)
	public ModelAndView preSendYzm() {	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Customer_pwd_back");
		return mv;
	}
	
	//发送验证码
	@RequestMapping(value="yzm.action",method=RequestMethod.GET)
	public ModelAndView sendYzm(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView ();
		//先查询数据库是否存在该号码
		String c_phone = request.getParameter("c_phone");
		System.out.println(c_phone);
		Customer c = new Customer();
		c.setC_phone(c_phone);
		Customer customer = customerServiceImpl.findOneCustomer(c);
		if (customer!=null) {
			Random random = new Random();
			int num = random.nextInt(90000);
			yzm = (num +10000)+"";
			TestSMS t = new TestSMS();
			t.setYzm(yzm);	
			t.setPhone(customer.getC_phone());
			//以下为发送验证码代码
	        try {
	            java.lang.String tel = t.getPhone();//要发送的手机号
	            System.out.println(tel);
	            HttpClient httpClient = new HttpClient();
	            PostMethod post = new PostMethod("http://api.sms.cn/sms/");
	            post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//头文件中设置转码
	            NameValuePair[] data = {
						new NameValuePair("ac","send"),
	                    new NameValuePair("uid","dwx666"),//SMS云信平台注册用户名?
	                    new NameValuePair("pwd","d95858585632b9d89ed392bcd98219f4"),//SMS云信平台MD5后的接口密码
	                    new NameValuePair("mobile",tel),//将要发送到的手机号码
	                    new NameValuePair("template","481428"),//json变量模板的模板ID，全文变量模板不需要填
	                    new NameValuePair("content","{\"code\":"+yzm+"}"),//要发送的内容
						new NameValuePair("encode","utf8"),//转utf-8编码
	            };
	            post.setRequestBody(data);
	            httpClient.executeMethod(post);	            
	        }catch (Exception e){
	        } 
	        mv.addObject("customer", customer);
	        System.out.println(customer.getC_name());
	        mv.setViewName("loginpwd_back");
	        return mv;
		}else {
			mv.setViewName("loginpwd_back");
			return mv;
		}				
	}
	
	//手机验证并跳转主页面
	@RequestMapping(value="pwd_back.action",method=RequestMethod.POST)
	public ModelAndView pwd_back(TestSMS t,HttpSession session) {
		ModelAndView mv = new ModelAndView();			
		if (yzm.equals(t.getYzm())) {
			Customer c= new Customer();
			c.setC_phone(t.getPhone());
			Customer customer =customerServiceImpl.findOneCustomer(c);
			session.setAttribute("customer", customer);
			mv.setViewName("cate_pencil");//跳转到主页面
		    return mv;
		}else {
			mv.setViewName("loginpwd_back");//手机验证码登录页面
			return mv;
		}
	}
	
	
	//跳转至修改页面
	@RequestMapping(value="preupdate.action" ,method=RequestMethod.GET)
	public ModelAndView preupdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Customer_Update");
		return mv;
	}
	
	//修改并跳回客户账号展示页面
	@RequestMapping(value="update.action",method=RequestMethod.POST)
	public ModelAndView update(Customer c,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		customerServiceImpl.customerUpdate(c);
		Customer customer= customerServiceImpl.findCustomerById(c.getC_id());
		session.setAttribute("customer", customer);//修改完后改变当前用户存在session的信息
		mv.setViewName("customerDetails");
		return mv;
	}
	
	/**
	 * 商品列表分页展示
	 */
	@RequestMapping(value="/kehufy" ,method=RequestMethod.GET)
	public String kehushow( HttpServletRequest request) {
		Excellent exe = new Excellent();
		//页数
		String c = request.getParameter("pagination");
		//System.out.println(c);
		
		//关键字
		String linchpin = request.getParameter("linchpin");
		//System.out.println(linchpin);
		//价格查询
		String sprice = request.getParameter("sprice");
		//System.out.println(sprice);
		String tprice = request.getParameter("tprice");
		//System.out.println(tprice);
		//判断模糊查询
		if(linchpin!=null&&!linchpin.equals("")) {
			exe.setLinchpin(linchpin);
			request.setAttribute("linchpin", linchpin);
		}
		if(sprice!=null) {
			exe.setSprice(sprice);
			request.setAttribute("sprice",sprice);
		//	System.out.println(sprice);
		}if(tprice!=null) {
			exe.setTprice(tprice);
			request.setAttribute("tprice",tprice);
		//	System.out.println(tprice);
		}
		if(c==null||c.equals("")) {
			c="1";
		}
		int pagination = Integer.parseInt(c);
		exe.setPagination(pagination);
		/*System.out.println(exe.getStart());
		System.out.println(exe.getEnd());*/
		//int ps = Integer.parseInt(sp);
		List<Material>mllist=MaterilaService.findall(exe);
		int allpag = (MaterilaService.getCount(exe)-1)/2+1;
		request.setAttribute("pagination", pagination);
		request.setAttribute("allpag", allpag);
		request.setAttribute("mllist", mllist);
		/*for(int i=0;i<mllist.size();i++) {
			System.out.println(mllist.get(i));
		}*/
		List<C_payment> clist = c_paymentService.findAll();
		request.setAttribute("clist", clist);
		return "purchase";
	}
	
	/**
	 * 多条件查询sale+分页
	 * @param query
	 * @param fy
	 * @return
	 */
	@RequestMapping(value="/sale_manage.action",method=RequestMethod.GET)
	public ModelAndView gopage(DWXFenYe fy,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String str = request.getParameter("c_id");
		if (str!=null) {
			int c_id = Integer.parseInt(str);
			if (fy.getQuery()==null) {
				fy.setQuery(new DWXQuery());
			}
			fy.getQuery().setQc_id(c_id);
		}
		List<Sale> slist = customerServiceImpl.findSale(fy);
		log.info("操作了数据库--select");
		mv.addObject("slist", slist);
		mv.addObject("fy", fy);
		mv.setViewName("ordersMsg");
		return mv;
	}
	
}
