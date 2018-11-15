package cn.sz.zl.service;

import java.util.List;
import java.util.Map;

import cn.sz.zl.pojo.Sale;
import cn.sz.zl.pojo.TalkPrice;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.util.FHUtil;



public interface ISaleService {
	
	//链表查询所有数据
	public List<FHUtil> findallInfo(FHQuery query,Integer startR, Integer stopR);

	//修改状态
	public boolean updateStateid(Integer sateid);
	//符合条件的个数
	public int querySaleRows(FHQuery query);
	//提交
	public int submit(Map map);
	//生成销售订单
	public void saleorder(Map map);
	//根据ID查询
	public Sale querySale(Integer saleid);
	//判断议价是否成功
	public List<TalkPrice> bargaining(Map<String,Object> map);
	//修改待收货状态
	public void updateColumn6(Integer c_id);
	//批量修改
	public void updateAll(List<String> list);
}
