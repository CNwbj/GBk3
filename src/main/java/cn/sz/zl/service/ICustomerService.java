package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.Customer;
import cn.sz.zl.pojo.Sale;
import cn.sz.zl.query.DWXQuery;
import cn.sz.zl.util.CustomerSearchCondition;
import cn.sz.zl.util.DWXFenYe;

public interface ICustomerService {
		//根据编号级联查询
		public Customer findCustomerById(Integer cid);
		//查询所有的客户信息
		public List<Customer> findAllCustomer(CustomerSearchCondition cusc);
		
		public Integer CountAllCus(CustomerSearchCondition cusc);
		//禁用账号
		public void disableCustomer(Integer cusid);	
		//启用账号
		public void ablCustomer(Integer cusid);
		
		//登录使用
		public Customer findCustomer(Customer customer);
		//密码找回使用
		public Customer findOneCustomer(Customer customer);
		//注册客户账号
		public void customerRegister(Customer customer);
		//客户修改信息
		public void customerUpdate(Customer customer);
		//分页展示历史订单
		public List<Sale>  findSale (DWXFenYe fy);
		//符合分页展示历史订单的条数
		public int saleCount (DWXQuery query);
}
