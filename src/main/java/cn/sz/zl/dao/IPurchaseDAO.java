package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Purchase;
import cn.sz.zl.util.Excellent;

@Mapper
public interface IPurchaseDAO {
	public Purchase findPurchaseById(int id); 
	public List<Purchase>findAllPurchase(Excellent exe);
	public Integer getCcount(Excellent exe);
	public Purchase UpdatePurchaseById(Integer id);
	public void DeletePurchaseByid(Integer id);
	public Purchase lookshowExcellent(Integer id);
}
