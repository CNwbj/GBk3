package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.State;

public interface IStateService {
	//根据编号查询,级联
	public State findStateById(Integer stateid);
	//查询所有的状态
	public List<State> findAllState();
	
	
}
