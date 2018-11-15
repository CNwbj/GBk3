package cn.sz.zl.service;

import cn.sz.zl.pojo.Depot;

public interface IDepotService {

	public boolean updateDepot(Depot depot_id);
	public Depot findById(Integer depot_id);
}
