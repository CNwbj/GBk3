package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.C_payment;



@Mapper
public interface IPaymentDAO {
	//根据编号查找,级联
	public C_payment findPaymentById(Integer paymentid);
	//查询所有的支付方式
	public List<C_payment> findAllPayment();
}
