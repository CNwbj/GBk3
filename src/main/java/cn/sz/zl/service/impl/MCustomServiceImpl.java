package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.ICustomServiceDAO;
import cn.sz.zl.pojo.CustomService;
import cn.sz.zl.service.MCustomService;
@Service
public class MCustomServiceImpl implements MCustomService {
	@Autowired
	private ICustomServiceDAO cd;
	@Override
	public CustomService findCustomServiceById(Integer customServiceid) {
		// TODO Auto-generated method stub
		return cd.findCustomServiceById(customServiceid);
	}

	@Override
	public List<CustomService> findAllCustomService() {
		// TODO Auto-generated method stub
		return cd.findAllCustomService();
	}

}
