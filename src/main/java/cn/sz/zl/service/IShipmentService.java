package cn.sz.zl.service;

import java.util.List;
import java.util.Map;

import cn.sz.zl.pojo.Sale;
import cn.sz.zl.pojo.Shipment;
import cn.sz.zl.util.Excellent;
import cn.sz.zl.util.FHUtil;

public interface IShipmentService {

	//分页查询
	public List<FHUtil> findAllAndShipments(Excellent exe);
		//分页模糊查询
		public Integer getCount(Excellent exe);
		public Sale findById(Integer id);
		public boolean updatePurchase(Map map);
		public boolean updateSysDate(Map map);
		 public void insertShipment(Shipment sh);
}
