package com.briup.estore.sevice;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exception.EstoreServiceException;

public interface IUserService {
	 //注册逻辑
	 boolean register(ECustomer cus) throws EstoreServiceException;
	 //登陆逻辑
	 ECustomer login(String name,String password)throws EstoreServiceException;
}
