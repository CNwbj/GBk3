package cn.sz.zl.service;

import java.util.List;

import cn.sz.zl.pojo.CustomService;

public interface MCustomService {
	public CustomService findCustomServiceById(Integer customServiceid);
	
	public List<CustomService> findAllCustomService();
}
