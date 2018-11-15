package cn.sz.zl.service;

import java.util.List;
import java.util.Map;

import cn.sz.zl.pojo.Sale;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.util.FHUtil;
import cn.sz.zl.util.MFenYe;
import cn.sz.zl.util.Query;

public interface ISaleExaService {
	//通过状态编号查询所有的待审核订单
	public List<Sale> findByStateid();
	public List<Sale> findByColumn1();
	public List<Sale> findByColumn2();
	
	//链表查询所有数据
	public List<FHUtil> findAllInfo(FHQuery query,Integer startR, Integer stopR);
	//符合条件的数据
	public int querySaleRows(FHQuery query);
	//修改状态
	public boolean updateStateid(Integer sateid);
	/*//提交
	public int submit(Map map);*/
	//生成销售订单审核表
	public void saleorder(Map map);
	//据ID查询
	public Sale querySale(Integer saleid);

	public void updateStateById2(Integer stateid);
	public void updateSHStateById2(Integer stateid);
	//财务经理审批
	public void updateStateById1(Integer stateid);
	public void updateSHStateById1(Integer stateid);
	
	public void updateStateById(Integer stateid);
	public void updateSHStateById(Integer stateid);
}
