package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Bill;

@Mapper
public interface IBillDao {
	public List<Bill> findBillBySaleId(int id);
	
	public boolean addBill(Bill bill);
}
