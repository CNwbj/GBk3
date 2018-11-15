package cn.sz.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IDeptDao;
import cn.sz.zl.pojo.Dept;
import cn.sz.zl.service.IDeptService;

@Service
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao dd;
	@Override
	public List<Dept> queryAllDept() {
		return dd.queryAllDept();
	}
	@Override
	public Dept queryDeptByDeptno(Integer deptno) {
		if (deptno != null && !"".equals(deptno)) {
			return dd.queryDeptByDeptno(deptno);
		}
		return null;
	}

	@Override
	public void addDept(Dept dept) {
		if(dept!=null) {
			dd.addDept(dept);
		}
	}

	@Override
	public List<Dept> queryAllDeptandUserCount() {
		return dd.queryAllDeptandUserCount();
	}

	@Override
	public Integer checkDeptre(String dname) {
		if(dname!=null&&!"".equals(dname)) {
			return dd.checkDeptre(dname);
		}
		return null;
	}


}
