package cn.sz.zl.service;

import java.util.List;
import java.util.Map;

import cn.sz.zl.pojo.Bill;
import cn.sz.zl.pojo.Purchase;
import cn.sz.zl.util.EvenTable;
import cn.sz.zl.util.FHUtil;
import cn.sz.zl.util.FlowQuery;

public interface FlowmeterService {
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
	
	public boolean Receivables(int saleid);
	
	public List<FHUtil> findAllInfo(Map map);
	
	public Integer getSaleCount();
	
	public List<Integer> findSaleid();
	//public Purchase findPurchaseById(int saleid);
}
