package cn.sz.zl.service;

import java.util.List;
import java.util.Map;

import cn.sz.zl.query.FHQuery;
import cn.sz.zl.util.FHUtil;

public interface IReturnGoodsService {
		//查询退货表链表查询
		public List<FHUtil> queryAll(FHQuery query,Integer startR, Integer stopR);
		//修改状态
		public boolean updatestate(Integer stateid);
		//符合条件的数据
		public int queryGoodsRows(FHQuery query);
		//生成退货订单
		public void returnorder(Map map);
}
