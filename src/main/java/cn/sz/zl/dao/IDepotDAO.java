package cn.sz.zl.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Depot;

@Mapper
public interface IDepotDAO {
	public boolean updateDepot(Depot depot_id);
	public Depot findById(Integer depot_id);
}
