package cn.sz.zl.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Flowmeter;
import cn.sz.zl.pojo.Purchase;
import cn.sz.zl.pojo.ThirdAccount;
import cn.sz.zl.util.EvenTable;
import cn.sz.zl.util.FHUtil;
import cn.sz.zl.util.FlowQuery;

@Mapper
public interface IFlowmeterDao {
	/**
	 * 分页条件展示全部流水
	 * @param fq:条件
	 * @return
	 */
	public List<EvenTable> findAll(FlowQuery fq);
	/**
	 * 根据ID查询流水信息
	 * @param id:流水ID
	 * @return
	 */
	public EvenTable findFlowmeterById(int id);
	/**
	 * 根据筛选条件查出总流水总数
	 * @param fq:条件
	 * @return
	 */
	public int getCount(FlowQuery fq);
	/**
	 * 更改订单审核状态
	 * @param map:里面有两个元素，1.stateid:状态ID，2.saleid:订单ID
	 * @return
	 */
	public boolean updateColumn4(Map map);
	/**
	 * 根据订单ID查询订单详情
	 * @param saleid:订单ID
	 * @return
	 */
	public List<FHUtil> findBySaleid(int saleid);
	
	public Flowmeter findById(int id);
	
	public Flowmeter findByBillId(int id);
	
	public boolean insertFlowmeter(Flowmeter flow);
	
	public boolean updateByAcc(ThirdAccount acc);
	
	public int findByAcc(int id);
	
	public List<FHUtil> findAllInfo(Map map);
	
	public Integer getSaleCount();
	
	public Purchase findPurchaseById(int saleid);
	
	public List<Integer> findSaleid();
}
