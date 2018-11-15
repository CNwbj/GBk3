package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.C_payment;

public interface IPaymentService {
	//根据编号查找,级联
		public C_payment findPaymentById(Integer paymentid);
		//查询所有的支付方式
		public List<C_payment> findAllPayment();
}
