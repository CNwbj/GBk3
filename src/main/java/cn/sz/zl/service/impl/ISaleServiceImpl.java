package cn.sz.zl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.ISaleDao;
import cn.sz.zl.pojo.Sale;
import cn.sz.zl.pojo.TalkPrice;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.service.ISaleService;
import cn.sz.zl.util.FHUtil;
@Service
public class ISaleServiceImpl implements ISaleService{
	
	@Autowired
	private ISaleDao sd;
	@Override
	public List<FHUtil> findallInfo(FHQuery query,Integer startR, Integer stopR) {
		// TODO Auto-generated method stub
		if(startR==null && stopR==null) {
			startR = 0;
			stopR = 4;
		}
		List<FHUtil> lf = sd.findAllInfo(query);
		if(stopR>lf.size()) {
			stopR = lf.size();
		}
		List<FHUtil> lflist = lf.subList(startR, stopR);
		
		return lflist;
	}
	@Override
	public boolean updateStateid(Integer sateid) {
		// TODO Auto-generated method stub
		return sd.updateStateid(sateid);
	}
	@Override
	public int querySaleRows(FHQuery query) {
		
		return sd.querySaleRows(query);
	}
	@Override
	public int submit(Map map) {
		// TODO Auto-generated method stub
		return sd.submit(map);
	}
	@Override
	public void saleorder(Map map) {
		
		 sd.saleorder(map);
	}
	@Override
	public Sale querySale(Integer saleid) {
		// TODO Auto-generated method stub
		return sd.querySale(saleid);
	}
	@Override
	public List<TalkPrice> bargaining(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.bargaining(map);
	}
	@Override
	public void updateColumn6(Integer c_id) {
		// TODO Auto-generated method stub
		sd.updateColumn6(c_id);
	}
	@Override
	public void updateAll(List<String> list) {
		// TODO Auto-generated method stub
		sd.updateAll(list);
	}

}
