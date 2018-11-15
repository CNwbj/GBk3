package cn.sz.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IDepotDAO;
import cn.sz.zl.pojo.Depot;
import cn.sz.zl.service.IDepotService;
@Service
public class IDepotServiceImpl implements IDepotService {

	@Autowired
	private IDepotDAO depotdao;
	@Override
	public boolean updateDepot(Depot depot_id) {
		return depotdao.updateDepot(depot_id);
	}
	@Override
	public Depot findById(Integer depot_id) {
		return depotdao.findById(depot_id);
	}

	
}
