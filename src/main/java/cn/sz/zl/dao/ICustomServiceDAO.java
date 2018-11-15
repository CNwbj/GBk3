package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.CustomService;
import cn.sz.zl.pojo.Customer;
import cn.sz.zl.util.CustomerSearchCondition;
@Mapper
public interface ICustomServiceDAO {
	//根据编号级联查询
		public CustomService findCustomServiceById(Integer customServiceid);
		
		public List<CustomService> findAllCustomService();
		
}
