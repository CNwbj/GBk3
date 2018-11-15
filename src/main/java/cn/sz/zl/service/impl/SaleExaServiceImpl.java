package cn.sz.zl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.ISaleExaDAO;
import cn.sz.zl.pojo.Sale;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.service.ISaleExaService;
import cn.sz.zl.util.FHUtil;

@Service
public class SaleExaServiceImpl implements ISaleExaService {
	@Autowired
	private ISaleExaDAO sd;

	@Override
	public List<Sale> findByStateid() {
		// TODO Auto-generated method stub
		return sd.findByStateid();
	}

	@Override
	public List<Sale> findByColumn1() {
		// TODO Auto-generated method stub
		return sd.findByColumn1();
	}

	@Override
	public List<Sale> findByColumn2() {
		// TODO Auto-generated method stub
		return sd.findByColumn2();
	}

	@Override
	public List<FHUtil> findAllInfo(FHQuery query,Integer startR, Integer stopR) {
		if(startR==null && stopR==null) {
			startR = 0;
			stopR = 2;
		}
		List<FHUtil> lf = sd.findAllInfo(query);
		if(stopR>lf.size()) {
			stopR = lf.size();
		}
		List<FHUtil> lflist = lf.subList(startR, stopR);
		
		return lflist;
	}

	@Override
	public int querySaleRows(FHQuery query) {
		// TODO Auto-generated method stub
		return sd.querySaleRows(query);
	}

	@Override
	public boolean updateStateid(Integer sateid) {
		// TODO Auto-generated method stub
		return sd.updateStateid(sateid);
	}

	@Override
	public void saleorder(Map map) {
		// TODO Auto-generated method stub
		sd.saleorder(map);
	}

	@Override
	public Sale querySale(Integer saleid) {
		// TODO Auto-generated method stub
		return sd.querySale(saleid);
	}

	@Override
	public void updateStateById(Integer stateid) {
		// TODO Auto-generated method stub
		sd.updateStateById(stateid);
	}

	@Override
	public void updateSHStateById(Integer stateid) {
		// TODO Auto-generated method stub
		sd.updateSHStateById(stateid);
	}

	@Override
	public void updateStateById2(Integer stateid) {
		// TODO Auto-generated method stub
		sd.updateStateById2(stateid);
	}

	@Override
	public void updateSHStateById2(Integer stateid) {
		// TODO Auto-generated method stub
		sd.updateSHStateById2(stateid);
	}

	@Override
	public void updateStateById1(Integer stateid) {
		// TODO Auto-generated method stub
		sd.updateStateById1(stateid);
	}

	@Override
	public void updateSHStateById1(Integer stateid) {
		// TODO Auto-generated method stub
		sd.updateSHStateById1(stateid);
	}
	

}
