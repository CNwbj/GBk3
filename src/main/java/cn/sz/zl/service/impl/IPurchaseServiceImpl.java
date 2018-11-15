package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IPurchaseDAO;
import cn.sz.zl.pojo.Purchase;
import cn.sz.zl.service.IPurchaseService;
import cn.sz.zl.util.Excellent;
@Service
public class IPurchaseServiceImpl implements IPurchaseService {
		@Autowired
		private IPurchaseDAO purchasedao;
	@Override
	public List<Purchase> findAllPurchase(Excellent exe) {
		if(exe==null) {
			return null;
		}
		return purchasedao.findAllPurchase(exe);
	}
	@Override
	public Integer getCcount(Excellent exe) {
		if(exe==null) {
		return null;
		}
	return purchasedao.getCcount(exe);
	}
	@Override
	public Purchase findPurchaseById(int id) {
		// TODO Auto-generated method stub
		return purchasedao.findPurchaseById(id);
	}
	@Override
	public Purchase UpdatePurchaseById(Integer id) {
		if(id==null) {
			return null;
		}
		return purchasedao.UpdatePurchaseById(id);
	}
	@Override
	public void DeletePurchaseByid(Integer id) {
		if(id!=null) {
			purchasedao.DeletePurchaseByid(id);
		}
	}
	@Override
	public Purchase lookshowExcellent(Integer id) {
		if(id==null) {
			return null;
		}
		return purchasedao.lookshowExcellent(id);
	}
}
