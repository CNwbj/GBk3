package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.C_payment;
@Mapper
public interface IC_paymentDAO {
	/**
	 * 查询所有
	 */
	public List<C_payment> findAll();
}
