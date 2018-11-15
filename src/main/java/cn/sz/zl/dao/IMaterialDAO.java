package cn.sz.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sz.zl.pojo.Material;
import cn.sz.zl.util.Excellent;

@Mapper
public interface IMaterialDAO {
	//分页模糊
	public List<Material> findall(Excellent exe);
	//记录分页
	public Integer getCount(Excellent exe);

	//根据编号级联
	public Material findMaterialInfoById(Integer materialid);
			//查询所有的物品信息
	public List<Material> findAllMaterial();

}
