package cn.sz.zl.action;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sz.zl.pojo.Flowtype;
import cn.sz.zl.pojo.State;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.service.FlowmeterService;
import cn.sz.zl.service.FlowtypeService;
import cn.sz.zl.service.ISaleService;
import cn.sz.zl.service.IShipmentService;
import cn.sz.zl.service.IStateService;
import cn.sz.zl.util.EvenTable;
import cn.sz.zl.util.FHUtil;
import cn.sz.zl.util.FlowQuery;

@Controller
@RequestMapping("/fc")
public class FlowmeterController {
	@Autowired
	private FlowmeterService flowmeterServiceImpl;
	@Autowired
	private FlowtypeService flowtypeServiceImpl;
	@Autowired
	private  ISaleService iSaleServiceImpl;
	@Autowired
	private IStateService stateServiceImpl;
	@Autowired
	private IShipmentService shipmentServiceImpl; 
	/**
	 * 流水筛选接口
	 * @param fq:筛选条件
	 * @param request
	 * @return
	 */
	@RequestMapping("showFlowmeter")
	public String showFlowmeter(FlowQuery fq,HttpServletRequest request) {
		
		fq.setCp(1);
		
		String cp = request.getParameter("cp");
		
		if(cp!=null &&!cp.equals("")) {
			fq.setCp(Integer.parseInt(cp));
		}
		List<Flowtype> ftlist = flowtypeServiceImpl.findAllType();
		
		Integer psCount = flowmeterServiceImpl.getCount(fq);
		if (psCount==0||psCount==null) {
			fq.setCpCount(1);
		}else {
			fq.setCpCount((psCount-1)/fq.getPs()+1);
		}
		

		List<EvenTable> list = flowmeterServiceImpl.findAll(fq);
		request.setAttribute("ftlist",ftlist);
		request.setAttribute("list", list);
		request.setAttribute("fq", fq);
		return "flowsplit";
	}
	/**
	 * 流水详情接口
	 * @param request
	 * @return
	 */
	@RequestMapping("show")
	public String show(int fm_id,HttpServletRequest request) {
		
		EvenTable et = flowmeterServiceImpl.findFlowmeterById(fm_id);
		request.setAttribute("et", et);
		return "flowshow";
	}
	/**
	 * 订单列表接口
	 * @param query
	 * @param request
	 * @return
	 */
	@RequestMapping("showSale")
	public String showSale(HttpServletRequest request) {
		int cp =1;
		String mypage = request.getParameter("cp");
		if(mypage!=null&&!mypage.equals("")) {
			cp = Integer.parseInt(mypage);
		}
		Map<String,Integer> map = new HashMap<String,Integer>(); 
		int start = cp*5;
		int stop =(cp-1)*5;
		map.put("start",start);
		map.put("stop", stop);
		List<FHUtil> fulist = flowmeterServiceImpl.findAllInfo(map);
		int psCount = flowmeterServiceImpl.getSaleCount();
		int allpage = (psCount-1)/5+1;
		List<State> stalist = stateServiceImpl.findAllState();
		
		request.setAttribute("fulist", fulist);
		request.setAttribute("stalist", stalist);
		request.setAttribute("cp", cp);
		request.setAttribute("allpage", allpage);
		return "flowsale2";
	}
	
	public Date getDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(); 
		try {
			 date = sdf.parse(str);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 操作接口
	 * @param stateid:审核状态
	 * @param saleid:订单ID
	 * @param request
	 * @return
	 */
	@RequestMapping("returnSale")
	public String returnSale(int stateid,int saleid,HttpServletRequest request) {
		Map map = new HashMap();
		map.put("stateid", stateid);
		map.put("saleid", saleid);
		boolean flag = flowmeterServiceImpl.updateColumn4(map);
		/*if(flag) {
			
			
			
			
			shipmentServiceImpl.insertShipment(sh);
		}*/
		return "redirect:/fc/showSale";
		
	}
	/**
	 * 订单详情接口
	 * @param saleid:订单ID
	 * @param request
	 * @return
	 */
	@RequestMapping("flowsaleshow")
	public String flowsaleshow(int saleid,HttpServletRequest request) {
		List<FHUtil> fh = flowmeterServiceImpl.findBySaleid(saleid);
		request.setAttribute("fh", fh);
		return "flowsaleshow";
	}
	/**
	 * 收款接口
	 * @return
	 */
/*	@RequestMapping("getMoney")
	public String getMoney(){
		System.out.println("进入控制器");
		flowmeterServiceImpl.Receivables(70);
		return "";
	}*/
	/*	@RequestMapping("getMoney")
	@Scheduled(cron = "0/2 * * * * *")
	public void timer() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		List<Integer> list = flowmeterServiceImpl.findSaleid();
		if(list!=null) {
			for (Integer integer : list) {
				flowmeterServiceImpl.Receivables(integer);
			}
		}
	}*/
}
