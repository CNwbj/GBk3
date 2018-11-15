package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.Purchase;
import cn.sz.zl.util.Excellent;

public interface IPurchaseService {
	//模糊查询
	public List<Purchase>findAllPurchase(Excellent exe);
	//页数
	public Integer getCcount(Excellent exe);

	public Purchase findPurchaseById(int id); 
	
	public Purchase UpdatePurchaseById(Integer id);
	
	public void DeletePurchaseByid(Integer id);
	
	//修改查询
	public Purchase lookshowExcellent(Integer id);
}
