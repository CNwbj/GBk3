package cn.sz.zl.service;

import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface IThirdAccountService {
	//更改账户
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public void updateAccount(Integer money);
	//更改用戶账户
	public void updateUserAccount(Map<String,Object> map);
}
