package cn.sz.zl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IReturnGoodsDAO;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.service.IReturnGoodsService;
import cn.sz.zl.util.FHUtil;
@Service
public class IReturnGoodsServiceImpl implements IReturnGoodsService {
	@Autowired
	private IReturnGoodsDAO irg;
	@Override
	public List<FHUtil> queryAll(FHQuery query,Integer startR, Integer stopR) {
		// TODO Auto-generated method stub
		if(startR==null && stopR==null) {
			startR = 0;
			stopR = 2;
		}
		List<FHUtil> lf = irg.queryAll(query);
		if(stopR>lf.size()) {
			stopR = lf.size();
		}
		List<FHUtil> lflist = lf.subList(startR, stopR);
		return lflist;
	}
	@Override
	public boolean updatestate(Integer stateid) {
		// TODO Auto-generated method stub
		return irg.updatestate(stateid);
	}
	@Override
	public int queryGoodsRows(FHQuery query) {
		// TODO Auto-generated method stub
		return irg.queryGoodsRows(query);
	}
	@Override
	public void returnorder(Map map) {
		// TODO Auto-generated method stub
		irg.returnorder(map);
	}

}
