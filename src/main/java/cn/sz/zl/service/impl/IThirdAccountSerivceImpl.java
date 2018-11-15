package cn.sz.zl.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.zl.dao.IThirdAccountDAO;
import cn.sz.zl.service.IThirdAccountService;
@Service
public class IThirdAccountSerivceImpl implements IThirdAccountService {
	@Autowired
	private IThirdAccountDAO itd;
	@Override
	public void updateAccount(Integer money) {
		// TODO Auto-generated method stub
		itd.updateAccount(money);
	}
	@Override
	public void updateUserAccount(Map<String,Object> map) {
		// TODO Auto-generated method stub
		itd.updateUserAccount(map);
	}
	
}
