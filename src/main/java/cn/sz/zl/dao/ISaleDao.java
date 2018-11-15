package cn.sz.zl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Sale;
import cn.sz.zl.pojo.TalkPrice;
import cn.sz.zl.query.FHQuery;
import cn.sz.zl.util.FHUtil;



@Mapper
public interface ISaleDao {
	
	//链表查询所有数据
	public List<FHUtil> findAllInfo(FHQuery query);
	//符合条件的数据
	public int querySaleRows(FHQuery query);
	//修改状态
	public boolean updateStateid(Integer sateid);
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
