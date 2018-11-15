package cn.sz.zl.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IThirdAccountDAO {
	//更改自己账户
	public void updateAccount(Integer money);
	//更改用戶账户
	public void updateUserAccount(Map<String,Object> map);
}
