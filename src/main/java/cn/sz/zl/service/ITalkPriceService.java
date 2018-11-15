package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.TalkPrice;

public interface ITalkPriceService {
	//根据id查询所有信息
		public TalkPrice findAllByTalkId(Integer talkid);
		//添加
		public void insertTalkPrice(TalkPrice talkPrice);
		
		public List<TalkPrice> findAllTalkPrice();
}
