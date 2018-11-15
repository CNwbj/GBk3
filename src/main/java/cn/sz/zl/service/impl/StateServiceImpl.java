package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IStateDAO;
import cn.sz.zl.pojo.State;
import cn.sz.zl.service.IStateService;
@Service
public class StateServiceImpl implements IStateService {
	@Autowired
	private IStateDAO sd;
	@Override
	public State findStateById(Integer stateid) {
		// TODO Auto-generated method stub
		return sd.findStateById(stateid);
	}

	@Override
	public List<State> findAllState() {
		// TODO Auto-generated method stub
		return sd.findAllState();
	}

}
