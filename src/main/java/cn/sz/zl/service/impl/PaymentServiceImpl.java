package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IPaymentDAO;
import cn.sz.zl.pojo.C_payment;
import cn.sz.zl.service.IPaymentService;
@Service
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	private IPaymentDAO pd;
	@Override
	public C_payment findPaymentById(Integer paymentid) {
		// TODO Auto-generated method stub
		return pd.findPaymentById(paymentid);
	}

	@Override
	public List<C_payment> findAllPayment() {
		// TODO Auto-generated method stub
		return pd.findAllPayment();
	}

}
