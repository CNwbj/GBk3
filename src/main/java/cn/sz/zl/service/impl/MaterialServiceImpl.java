package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IMaterialDAO;
import cn.sz.zl.pojo.Material;
import cn.sz.zl.service.IMaterialServce;
import cn.sz.zl.util.Excellent;
@Service
public class MaterialServiceImpl implements IMaterialServce {
	@Autowired
	private IMaterialDAO md;
	@Override
	public Material findMaterialInfoById(Integer materialid) {
		// TODO Auto-generated method stub
		return md.findMaterialInfoById(materialid);
	}
//123
	@Override
	public List<Material> findAllMaterial() {
		// TODO Auto-generated method stub
		return md.findAllMaterial();
	}

	@Override
	public Integer getCount(Excellent exe) {
		if(exe==null) {
			return null;
		}
		return md.getCount(exe);
	}

	@Override
	public List<Material> findall(Excellent exe) {
		if(exe==null) {
			return null;
		}
		return md.findall(exe);
	}

}
