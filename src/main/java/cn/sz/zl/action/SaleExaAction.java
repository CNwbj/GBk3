package cn.sz.zl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sz.zl.pojo.Sale;
import cn.sz.zl.pojo.State;
import cn.sz.zl.query.FHQuery;

import cn.sz.zl.service.ISaleExaService;
import cn.sz.zl.service.IStateService;
import cn.sz.zl.util.FHFenYe;
import cn.sz.zl.util.FHUtil;


@Controller
@RequestMapping("/sea")
public class SaleExaAction {
	/*@Autowired
	private SaleExaServiceImpl ses;
	@Autowired
	private IStateService ss;
	@Autowired
	private IMaterialServce ms;
	@Autowired
	private ICustomerService cs;
	@Autowired
	private IPaymentService ps;*/

	@Autowired
	private ISaleExaService ss;
	@Autowired
	private IStateService sts;

	@RequestMapping("/gofenye")
	public ModelAndView gopage(FHQuery query,FHFenYe fy,HttpServletRequest request){
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
		List<State> statelist=sts.findAllState();
		Integer counts = ss.querySaleRows(query);
		System.out.println(counts);
		//log.info("操作了数据库--select");
		fy.setAllCount(counts);
		
		List<FHUtil> lss = ss.findAllInfo(query, fy.getStartRows(), fy.getStopRows());
		//log.info("操作了数据库--select");
		mv.addObject("dataurl","sea/gofenye");
		mv.addObject("pageUrl","SaleExa");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("statelist",statelist);
		mv.addObject("fy",fy);
		mv.addObject("lss",lss);
		mv.setViewName("SaleExa");
		return mv;
	}
	//二级审核-->审核
	@RequestMapping("updatestateid")
	public ModelAndView shenheState(HttpServletRequest request,FHQuery query,FHFenYe fy) {
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
		Integer counts = ss.querySaleRows(query);
		fy.setAllCount(counts);
		//得到页面传送过来的数据(id编号)		
		String idsh=request.getParameter("states");//
		//String转为Integer
		Integer sid= Integer.parseInt(idsh);//		
		//二级审核,查询仓库经理要审批的订单内容,得到已经审批过的所有销售订单
	
			ss.updateStateById(sid);  //审核	
			
		
		List<FHUtil> lss = ss.findAllInfo(query,fy.getStartRows(),fy.getStopRows());
		mv.addObject("dataurl","sea/gofenye");
		mv.addObject("pageUrl","SaleExa");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("fy",fy);
		mv.addObject("lss",lss);
		mv.setViewName("SaleExa");
		return mv;
		}
	//二级审核-->驳回
	@RequestMapping("updatestateid1")
	public ModelAndView bohuiState(HttpServletRequest request,FHQuery query,FHFenYe fy) {
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
		Integer counts = ss.querySaleRows(query);
		fy.setAllCount(counts);
		//得到页面传送过来的数据(id编号)		
		String idsh=request.getParameter("states");//
		//String转为Integer
		Integer sid= Integer.parseInt(idsh);//
		//二级审核,查询仓库经理要审批的订单内容,得到已经审批过的所有销售订单
	
		ss.updateSHStateById(sid);//驳回
		
		
		List<FHUtil> lss = ss.findAllInfo(query,fy.getStartRows(),fy.getStopRows());
		mv.addObject("dataurl","sea/gofenye");
		mv.addObject("pageUrl","SaleExa");
		mv.addObject("allpage",fy.getAllPage());
		mv.addObject("fy",fy);
		mv.addObject("lss",lss);
		mv.setViewName("SaleExa");
		return mv;
		}

		//三级审核-->审核
		@RequestMapping("updatestateid2")
		public ModelAndView shenheState1(HttpServletRequest request,FHQuery query,FHFenYe fy) {
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
			Integer counts = ss.querySaleRows(query);
			fy.setAllCount(counts);
			//得到页面传送过来的数据(id编号)		
			String idsh=request.getParameter("states");//
			//String转为Integer
			Integer sid= Integer.parseInt(idsh);//		
		
			ss.updateStateById1(sid);  //审核
			List<FHUtil> lss = ss.findAllInfo(query,fy.getStartRows(),fy.getStopRows());
			mv.addObject("dataurl","sea/gofenye");
			mv.addObject("pageUrl","SaleExa");
			mv.addObject("allpage",fy.getAllPage());
			mv.addObject("fy",fy);
			mv.addObject("lss",lss);
			mv.setViewName("SaleExa");
			return mv;
			}
		//三级审核-->驳回
		@RequestMapping("updatestateid3")
		public ModelAndView bohuiState1(HttpServletRequest request,FHQuery query,FHFenYe fy) {
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
			Integer counts = ss.querySaleRows(query);
			fy.setAllCount(counts);
			//得到页面传送过来的数据(id编号)		
			String idsh=request.getParameter("states");//
			//String转为Integer
			Integer sid= Integer.parseInt(idsh);//
			//二级审核,查询仓库经理要审批的订单内容,得到已经审批过的所有销售订单
		
			ss.updateSHStateById1(sid);//驳回
			List<FHUtil> lss = ss.findAllInfo(query,fy.getStartRows(),fy.getStopRows());
			mv.addObject("dataurl","sea/gofenye");
			mv.addObject("pageUrl","SaleExa");
			mv.addObject("allpage",fy.getAllPage());
			mv.addObject("fy",fy);
			mv.addObject("lss",lss);
			mv.setViewName("SaleExa");
			return mv;
			}
	
		//四级审核-->驳回
		@RequestMapping("updatestateid5")
		public ModelAndView bohuiState2(HttpServletRequest request,FHQuery query,FHFenYe fy) {
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
			Integer counts = ss.querySaleRows(query);
			fy.setAllCount(counts);
			//得到页面传送过来的数据(id编号)		
			String idsh=request.getParameter("states");//
			//String转为Integer
			Integer sid= Integer.parseInt(idsh);//
			
		
			ss.updateSHStateById2(sid);//司机驳回
			
			List<FHUtil> lss = ss.findAllInfo(query,fy.getStartRows(),fy.getStopRows());
			mv.addObject("dataurl","sea/gofenye");
			mv.addObject("pageUrl","SaleExa");
			mv.addObject("allpage",fy.getAllPage());
			mv.addObject("fy",fy);
			mv.addObject("lss",lss);
			mv.setViewName("SaleExa");
			return mv;
			}
			//四级审核-->审核
				@RequestMapping("updatestateid4")
				public ModelAndView shenheState2(HttpServletRequest request,FHQuery query,FHFenYe fy) {
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
					Integer counts = ss.querySaleRows(query);
					fy.setAllCount(counts);
					//得到页面传送过来的数据(id编号)		
					String idsh=request.getParameter("states");
					//String转为Integer
					Integer sid= Integer.parseInt(idsh);		
					//二级审核,查询仓库经理要审批的订单内容,得到已经审批过的所有销售订单
				
					
					ss.updateStateById2(sid);  //审核
					
						
					List<FHUtil> lss = ss.findAllInfo(query,fy.getStartRows(),fy.getStopRows());
					mv.addObject("dataurl","sea/gofenye");
					mv.addObject("pageUrl","SaleExa");
					mv.addObject("allpage",fy.getAllPage());
					mv.addObject("fy",fy);
					mv.addObject("lss",lss);
					mv.setViewName("SaleExa");
					return mv;
					}

	
}
