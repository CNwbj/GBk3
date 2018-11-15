package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IC_paymentDAO;
import cn.sz.zl.pojo.C_payment;
import cn.sz.zl.service.IC_paymentService;

@Service
public class C_paymentServiceImpl implements IC_paymentService {
	@Autowired
	private IC_paymentDAO c_paymentdao;
	
	@Override
	public List<C_payment> findAll() {
		// TODO Auto-generated method stub
		return c_paymentdao.findAll();
	}

}
