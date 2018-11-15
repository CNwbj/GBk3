package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.ICustomerDAO;
import cn.sz.zl.pojo.Customer;
import cn.sz.zl.pojo.Sale;
import cn.sz.zl.query.DWXQuery;
import cn.sz.zl.service.ICustomerService;
import cn.sz.zl.util.CustomerSearchCondition;
import cn.sz.zl.util.DWXFenYe;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDAO cd;
	
	//根据编号级联查询
	@Override
	public Customer findCustomerById(Integer cid) {
		return cd.findCustomerById(cid);
	}
	
	//查询所有的客户信息

	@Override
	public void disableCustomer(Integer c_id) {
		if(c_id!=null&&!"".equals(c_id)) {
			cd.disableCustomer(c_id);
		}
		
	}

	@Override
	public void ablCustomer(Integer c_id) {
		if(c_id!=null&&!"".equals(c_id)) {
			cd.ablCustomer(c_id);
		}
	}

	@Override
	public List<Customer> findAllCustomer(CustomerSearchCondition cusc) {
		return cd.findAllCustomer(cusc);
	}


	@Override
	public Integer CountAllCus(CustomerSearchCondition cusc) {
		return cd.CountAllCus(cusc);
	}
	
	//登录使用
	@Override
	public Customer findCustomer(Customer customer) {
		if (customer==null) {
			return null;
		}
		return cd.findCustomer(customer);
	}

	@Override
	public Customer findOneCustomer(Customer customer) {
		if (customer==null) {
			return null;
		}
		return cd.findOneCustomer(customer);
	}

	@Override
	public void customerRegister(Customer customer) {
		cd.customerRegister(customer);
	}

	@Override
	public void customerUpdate(Customer customer) {
		cd.customerUpdate(customer);
	}
	
	/**
	 * 历史订单分页查询
	 */
	@Override
	public List<Sale> findSale(DWXFenYe fy) {
		//对分页对象进行处理
		//处理当前页码
		if(fy.getPage()==null) {
			fy.setPage(1);
		}
		//设置符合要求的记录总数
		fy.setRowCount(cd.saleCount(fy.getQuery()));
		
		List<Sale> ls=cd.findSale(fy);
		return ls;
	}
	/**
	 * 符合历史订单分页查询条数
	 */
	@Override
	public int saleCount(DWXQuery query) {
		return cd.saleCount(query);
	}

}
