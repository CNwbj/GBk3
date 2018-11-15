package cn.sz.zl.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sz.zl.dao.IBillDao;
import cn.sz.zl.dao.IFlowmeterDao;
import cn.sz.zl.dao.IMaterialDAO;
import cn.sz.zl.dao.IPurchaseDAO;
import cn.sz.zl.pojo.Bill;
import cn.sz.zl.pojo.Flowmeter;
import cn.sz.zl.pojo.Purchase;
import cn.sz.zl.pojo.ThirdAccount;
import cn.sz.zl.service.FlowmeterService;
import cn.sz.zl.util.EvenTable;
import cn.sz.zl.util.FHUtil;
import cn.sz.zl.util.FlowQuery;
@Service
public class FlowmeterServiceImpl implements FlowmeterService {
	@Autowired
	private IFlowmeterDao fwdao;
	@Autowired
	private IBillDao billdao;
	@Autowired
	private IMaterialDAO madao;
	@Autowired
	private IPurchaseDAO purdao;
	@Override
	public List<EvenTable> findAll(FlowQuery fq) {
		return fwdao.findAll(fq);
	}
	@Override
	public EvenTable findFlowmeterById(int id) {
		return fwdao.findFlowmeterById(id);
	}
	public int getCount(FlowQuery fq) {
		return fwdao.getCount(fq);
	}
	@Override
	public boolean updateColumn4(Map map) {
		return fwdao.updateColumn4(map);
	}
	@Override
	public List<FHUtil> findBySaleid(int saleid) {
		return fwdao.findBySaleid(saleid);
	}
	@Transactional()
	public boolean Receivables(int saleid) {
		Bill b = new Bill();
		
		Purchase pur = fwdao.findPurchaseById(saleid);
		
		System.out.println("pur完成");
		int purchaseId =pur.getPurchase_id();
		int cost_price = pur.getCost_price();
		System.out.println(pur.getMaterial());
		Double material_price = pur.getMaterial().getMaterial_price();//销售价格
		Double profit = material_price-cost_price;
		b.setSaleId(saleid);
		b.setPurchaseId(purchaseId);
		b.setProfit(profit);
		billdao.addBill(b);
		System.out.println("添加bill");
		
		List<Bill> blist = billdao.findBillBySaleId(saleid);
		
		System.out.println(blist);
		Bill bill =blist.get(blist.size()-2);
		Bill bi = blist.get(blist.size()-1);
		System.out.println(bi.getBillId());
		System.out.println(bill.getBillId());
		Flowmeter flow = fwdao.findByBillId(bill.getBillId());
		System.out.println(flow);
		System.out.println("查找流水");
		Flowmeter fm = new Flowmeter();
		String flowmeter_id = getBody(bill.getSaleId());
		fm.setFlowmeter_id(flowmeter_id);
		fm.setBill_id(blist.get(blist.size()-1).getBillId());
		fm.setFlowmeter_time(new Date());
		fm.setFlowmeter_type(2);
		fm.setOld_balance(flow.getNow_balance());
		System.out.println(bill.getSaleId());
		List<FHUtil> fhlist = fwdao.findBySaleid(bill.getSaleId());
		Double salemoney = fhlist.get(fhlist.size()-1).getMaterial().getMaterial_price()*fhlist.get(fhlist.size()-1).getSale().getGoodscount();
		fm.setNow_balance(fm.getOld_balance()+salemoney);
		
		int money = fwdao.findByAcc(1);
		System.out.println("查询账户");
		int nowmoney = (int)(money-salemoney);
		/*if(nowmoney<0) {
			
		}*/
		ThirdAccount acc = new ThirdAccount();
		acc.setT_id(1);
		acc.setMoney(nowmoney);
		System.out.println("修改账户");
		fwdao.updateByAcc(acc);
		fwdao.insertFlowmeter(fm);
		System.out.println("修改完成");
		
		return true;
	}
	
	private String getBody(Integer id) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(new Date()).substring(2, 14) + String.format("%04d", id);
		
	}
	@Override
	public List<FHUtil> findAllInfo(Map map) {
		// TODO Auto-generated method stub
		return fwdao.findAllInfo(map);
	}
	@Override
	public Integer getSaleCount() {
		// TODO Auto-generated method stub
		return fwdao.getSaleCount();
	}
	@Override
	public List<Integer> findSaleid() {
		return fwdao.findSaleid();
	}


}
