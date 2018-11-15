package cn.sz.zl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IShipmentDAO;
import cn.sz.zl.pojo.Sale;
import cn.sz.zl.pojo.Shipment;
import cn.sz.zl.service.IShipmentService;
import cn.sz.zl.util.Excellent;
import cn.sz.zl.util.FHUtil;
@Service
public class IShipmentServiceImpl implements IShipmentService {
		@Autowired
		private IShipmentDAO shipmentdao;
	@Override
	public List<FHUtil> findAllAndShipments(Excellent exe) {
		if(exe==null) {
			return null;
		}
		return shipmentdao.findAllAndShipments(exe);
	}

	@Override
	public Integer getCount(Excellent exe) {
		if(exe==null) {
			return null;
		}
		return shipmentdao.getCount(exe);
	}

	@Override
	public Sale findById(Integer id) {
		if(id==null) {
			return null;
		}
		return shipmentdao.findById(id);
	}

	@Override
	public boolean updatePurchase(Map map) {
		return shipmentdao.updatePurchase(map);
	}

	@Override
	public boolean updateSysDate(Map map) {
		return shipmentdao.updateSysDate(map);
	}

	@Override
	public void insertShipment(Shipment sh) {
		if(sh!=null) {
			shipmentdao.insertShipment(sh);
		}
		
	}

	

	

}
