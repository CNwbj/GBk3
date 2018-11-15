package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.Material;
import cn.sz.zl.util.Excellent;

public interface IMaterialServce {
	//根据编号级联
		public Material findMaterialInfoById(Integer materialid);
		//查询所有的物品信息
		public List<Material> findAllMaterial();
		// 分页模糊
		public List<Material> findall(Excellent exe);
		// 记录分页
		public Integer getCount(Excellent exe);
}
