package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.sz.zl.dao.IBillDao;
import cn.sz.zl.pojo.Bill;
import cn.sz.zl.service.BillService;

public class BillServiceImpl implements BillService {
	@Autowired
	private IBillDao billdao;
	public boolean addBill(Bill bill) {
		return billdao.addBill(bill);
	}
	@Override
	public List<Bill> findBillBySaleId(int id) {
		return billdao.findBillBySaleId(id);
	}

}
