package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.ITalkPriceDAO;
import cn.sz.zl.pojo.TalkPrice;
import cn.sz.zl.service.ITalkPriceService;
@Service
public class TalkPriceServiceImpl implements ITalkPriceService {
	@Autowired
	private ITalkPriceDAO td;
	@Override
	public TalkPrice findAllByTalkId(Integer talkid) {
		// TODO Auto-generated method stub
		return td.findAllByTalkId(talkid);
	}

	@Override
	public void insertTalkPrice(TalkPrice talkPrice) {
		// TODO Auto-generated method stub
		td.insertTalkPrice(talkPrice);
	}

	@Override
	public List<TalkPrice> findAllTalkPrice() {
		// TODO Auto-generated method stub
		return td.findAllTalkPrice();
	}
	

}
