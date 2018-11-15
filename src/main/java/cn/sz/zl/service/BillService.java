package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.Bill;

public interface BillService {
	public List<Bill> findBillBySaleId(int id);
	
	public boolean addBill(Bill bill);
}
