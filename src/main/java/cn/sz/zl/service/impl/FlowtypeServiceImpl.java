package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IFlowtypeDao;
import cn.sz.zl.pojo.Flowtype;
import cn.sz.zl.service.FlowtypeService;
@Service
public class FlowtypeServiceImpl implements FlowtypeService {
	@Autowired
	private IFlowtypeDao ftdao; 
	@Override
	public List<Flowtype> findAllType() {
		return ftdao.findAllType();
	}

}
