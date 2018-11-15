package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.State;

@Mapper
public interface IStateDAO {
	//根据编号查询,级联
	public State findStateById(Integer stateid);
	//查询所有的状态
	public List<State> findAllState();
}
