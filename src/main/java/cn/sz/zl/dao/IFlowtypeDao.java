package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Flowtype;

@Mapper
public interface IFlowtypeDao {
	public List<Flowtype> findAllType();
}
