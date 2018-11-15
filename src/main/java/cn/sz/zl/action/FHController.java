package cn.sz.zl.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sz.zl.pojo.TalkPrice;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.service.IReturnGoodsService;
import cn.sz.zl.service.ISaleService;
import cn.sz.zl.service.IThirdAccountService;
import cn.sz.zl.util.FHFenYe;
import cn.sz.zl.util.FHUtil;

@Controller
@RequestMapping("/pc")
public class FHController implements Serializable{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(FHController.class);
	@Autowired
	@Qualifier("redisTemplate")
	RedisTemplate<Object,Object> rt;
	@Autowired
	private ISaleService iSaleServiceImpl;
	@Autowired
	private IReturnGoodsService iReturnGoodsServiceImpl;
	@Autowired
	private IThirdAccountService iThirdAccountServiceImpl;
	
	/**
	 * 多条件查询sale+分页
	 * @param query
	 * @param fy
	 * @param request
	 * @return
	 */
	@RequestMapping("/gopage")
	public ModelAndView gopage(FHQuery query,FHFenYe fy,HttpServletRequest request){
		System.out.println("enter salecontroller");
		ModelAndView mv = new ModelAndView();
		if(fy==null) {
			fy = new FHFenYe();
		}
		if(query == null) {
			query = new FHQuery();
		}
		if(fy.getCp()!=null) {
			request.setAttribute("cp", fy.getCp());
		}
		Integer counts = iSaleServiceImpl.querySaleRows(query);
		log.info("操作了数据库");
		fy.setAllCount(counts);
		
		List<FHUtil> lss = iSaleServiceImpl.findallInfo(query,fy.getStartRows(),fy.getStopRows());
		if(lss!=null) {
			List<FHUtil> lsh = new ArrayList<FHUtil>();
			for(FHUtil fh : lss) {
				lsh.add(fh);
			}
			int saleno = lsh.hashCode();
			String sale = String.valueOf(saleno);
			rt.opsForValue().set(sale,lsh);
		}
		mv.addObject("dataurl","pc/gopage");
		mv.addObject("pageUrl","SaleList");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("fy",fy);
		mv.addObject("lss",lss);
		mv.setViewName("SaleList");
		return mv;
	}
	/**
	 * 更改状态分页+送审
	 * @param request
	 * @param query
	 * @param fy
	 * @return
	 */
	@RequestMapping("/updatestateid")
	public ModelAndView updatestateid(HttpServletRequest request,FHQuery query,FHFenYe fy){
		ModelAndView mv = new ModelAndView();
		if(fy==null) {
			fy = new FHFenYe();
		}
		if(query == null) {
			query = new FHQuery();
		}
		if(fy.getCp()!=null) {
			request.setAttribute("cp", fy.getCp());
		}
		Integer counts = iSaleServiceImpl.querySaleRows(query);
		fy.setAllCount(counts);
		String idd = request.getParameter("status");
		Integer id = Integer.parseInt(idd);
		iSaleServiceImpl.updateStateid(id);
		log.info("操作了数据库--update");
		List<FHUtil> lss = iSaleServiceImpl.findallInfo(query,fy.getStartRows(),fy.getStopRows());
		mv.addObject("dataurl","pc/gopage");
		mv.addObject("pageUrl","SaleList");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("fy",fy);
		mv.addObject("lss",lss);
		mv.setViewName("SaleList");
		return mv;
		}
/*	*//**
	 * 用户购买提交
	 * @param req
	 * @return
	 *//*
	@RequestMapping(value="/submit")
	@ResponseBody
	public Map<String,Object> gosubmit(HttpServletRequest req) {
		Map<String,Object> map = new HashMap<String,Object>();
		String cid = req.getParameter("c_id");
		Integer c_id = Integer.parseInt(cid);
		String mid = req.getParameter("material_id");
		Integer material_id = Integer.parseInt(mid);
		String rprice = req.getParameter("realprice");
		Integer realprice = Integer.parseInt(rprice);
		String cpid = req.getParameter("c_paymentid");
		Integer c_paymentid = Integer.parseInt(cpid);
		String goods = req.getParameter("goodscount");
		Integer goodscount = Integer.parseInt(goods);
		String sendaddr = req.getParameter("sendaddr");
		map.put("c_id", c_id);
		map.put("m_id", material_id);
		map.put("sendaddr", sendaddr);
		map.put("c_paymentid",c_paymentid);
		map.put("goodscount", goodscount);
		map.put("realprice", realprice);
		iSaleServiceImpl.saleorder(map);
		log.info("操作了数据库--insert");
		Map<String,Object> json=new HashMap<String,Object>();
		json.put("flag", true);
		return json;
	}*/
	/**
	 * 用户提交
	 * @param req
	 * @return
	 */
	//14成交 //15未成交
	@RequestMapping("/submit")
	public ModelAndView bargaining(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String cid = req.getParameter("c_id");
		Integer c_id = Integer.parseInt(cid);
		String mid = req.getParameter("material_id");
		Integer m_id = Integer.parseInt(mid);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("c_id", c_id);
		map.put("m_id", m_id);
		List<TalkPrice> tp = iSaleServiceImpl.bargaining(map);
		if(tp==null||tp.equals("")) {
			String realprice1 = req.getParameter("realprice");
			Integer realprice = Integer.parseInt(realprice1);
			String cpid = req.getParameter("c_paymentid");
			Integer c_paymentid = Integer.parseInt(cpid);
			String goods = req.getParameter("goodscount");
			Integer goodscount = Integer.parseInt(goods);
			String sendaddr = req.getParameter("sendaddr");
			map.put("sendaddr", sendaddr);
			map.put("realprice", realprice);
			map.put("c_paymentid",c_paymentid);
			map.put("goodscount", goodscount);
			iSaleServiceImpl.saleorder(map);
			mv.setViewName("Forehome");
			return mv;
		}
		TalkPrice Tp = tp.get(tp.size()-1);
		String cpid = req.getParameter("c_paymentid");
		Integer c_paymentid = Integer.parseInt(cpid);
		String goods = req.getParameter("goodscount");
		Integer goodscount = Integer.parseInt(goods);
		String sendaddr = req.getParameter("sendaddr");
		map.put("sendaddr", sendaddr);
		map.put("realprice", Tp.getQ_price());
		map.put("c_paymentid",c_paymentid);
		map.put("goodscount", goodscount);
		iSaleServiceImpl.saleorder(map);
		log.info("操作了数据库--insert");
		mv.setViewName("Forehome");
		return mv;
	}
	/**
	 * 多条件查询returngoods+分页
	 * @param query
	 * @param fy
	 * @param request
	 * @return
	 */
	@RequestMapping("/gogoods")
	public ModelAndView gogoods(FHQuery query,FHFenYe fy,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		if(fy==null) {
			fy = new FHFenYe();
		}
		if(query == null) {
			query = new FHQuery();
		}
		if(fy.getCp()!=null) {
			request.setAttribute("cp", fy.getCp());
		}
		Integer counts = iReturnGoodsServiceImpl.queryGoodsRows(query);
		log.info("操作了数据库--select");
		fy.setAllCount(counts);
		List<FHUtil> lf = iReturnGoodsServiceImpl.queryAll(query,fy.getStartRows(),fy.getStopRows());
		if(lf!=null) {
			List<FHUtil> lsh = new ArrayList<FHUtil>();
			for(FHUtil fh : lf) {
				lsh.add(fh);
			}
			rt.opsForValue().set("sale",lsh);
		}
		log.info("操作了数据库--select");
		mv.addObject("lf",lf);
		mv.addObject("dataurl","pc/gopage");
		mv.addObject("pageUrl","SaleList");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("fy",fy);
		mv.setViewName("ReturnGoodsList");
		return mv;
	}
	/**
	 * 更改退货状态+分页（退货）
	 * @param request
	 * @param query
	 * @param fy
	 * @return
	 */
	@RequestMapping("/updatestate")
	public ModelAndView updatestate(HttpServletRequest request,FHQuery query,FHFenYe fy){
		ModelAndView mv = new ModelAndView();
		if(fy==null) {
			fy = new FHFenYe();
		}
		if(query == null) {
			query = new FHQuery();
		}
		if(fy.getCp()!=null) {
			request.setAttribute("cp", fy.getCp());
		}
		Integer counts = iReturnGoodsServiceImpl.queryGoodsRows(query);
		log.info("操作了数据库--select");
		fy.setAllCount(counts);
		String idd = request.getParameter("status");
		Integer id = Integer.parseInt(idd);
		iReturnGoodsServiceImpl.updatestate(id);
		List<FHUtil> lf = iReturnGoodsServiceImpl.queryAll(query,fy.getStartRows(),fy.getStopRows());
		log.info("操作了数据库--select");
		mv.addObject("dataurl","pc/gopage");
		mv.addObject("pageUrl","SaleList");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("fy",fy);
		mv.addObject("lf",lf);
		mv.setViewName("ReturnGoodsList");
		return mv;
		}
	/**
	 * 退货表分页+修改sale表的退货状态
	 * @param req
	 * @return
	 */
	@RequestMapping("/returngoods")
	public ModelAndView returnOrder(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		Map<String,Object> map = new HashMap<String,Object>();
		String cid = req.getParameter("c_id");
		Integer c_id = Integer.parseInt(cid);
		String mid = req.getParameter("material_id");
		Integer m_id = Integer.parseInt(mid);
		String counts = req.getParameter("goodscount");
		Integer goodscount = Integer.parseInt(counts);
		/*String idd = req.getParameter("saleid");
		Integer id = Integer.parseInt(idd);
		iSaleServiceImpl.updateStateid(id);*/
		
		map.put("c_id", c_id);
		map.put("m_id", m_id);
		map.put("goodscount", goodscount);
		iReturnGoodsServiceImpl.returnorder(map);
		mv.setViewName("cate_pencil");
		return mv;
	}
	/**
	 * 用户确认收货
	 * @param req
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm(HttpServletRequest req) {
		String mon = req.getParameter("money");
		Integer money = Integer.parseInt(mon);
		iThirdAccountServiceImpl.updateAccount(money);
		String cid = req.getParameter("c_id");
		Integer c_id = Integer.parseInt(cid);
		String sid = req.getParameter("saleid");
		Integer saleid = Integer.parseInt(sid);
		iSaleServiceImpl.updateColumn6(saleid);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("money", money);
		map.put("c_id", c_id);
		log.info("第三方数据库被操作");
		iThirdAccountServiceImpl.updateUserAccount(map);
		return "cate_pencil";
	}
	/**
	 * 批量修改
	 * @param request
	 * @param query
	 * @param fy
	 * @return
	 */
	@RequestMapping("/updateAll")
	public ModelAndView updateAll(HttpServletRequest request,FHQuery query,FHFenYe fy) {
		ModelAndView mv = new ModelAndView();
		String str = request.getParameter("status");
		String[] strl = str.split(",");
		List<String> resultList = new ArrayList<>(strl.length);
		for (String s : strl) {
			resultList.add(s);
		}
		iSaleServiceImpl.updateAll(resultList);
		if(fy==null) {
			fy = new FHFenYe();
		}
		if(query == null) {
			query = new FHQuery();
		}
		if(fy.getCp()!=null) {
			request.setAttribute("cp", fy.getCp());
		}
		Integer counts = iSaleServiceImpl.querySaleRows(query);
		fy.setAllCount(counts);
		List<FHUtil> lss = iSaleServiceImpl.findallInfo(query,fy.getStartRows(),fy.getStopRows());
		mv.addObject("dataurl","pc/gopage");
		mv.addObject("pageUrl","SaleList");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("fy",fy);
		mv.addObject("lss",lss);
		mv.setViewName("SaleList");
		return mv;
	}
	/*@Scheduled(cron = "0/2 * * * * *")
	public void timer() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}*/
}

