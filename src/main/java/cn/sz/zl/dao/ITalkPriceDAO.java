package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.TalkPrice;
@Mapper
public interface ITalkPriceDAO {
	//根据id查询所有信息
	public TalkPrice findAllByTalkId(Integer talkid);
	//添加
	public void insertTalkPrice(TalkPrice talkPrice);
	
	public List<TalkPrice> findAllTalkPrice();
	
}
