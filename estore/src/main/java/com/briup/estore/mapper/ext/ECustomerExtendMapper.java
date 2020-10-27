package com.briup.estore.mapper.ext;

import java.util.List;

import com.briup.estore.bean.EBook;
import com.briup.estore.bean.ECategory;
import com.briup.estore.bean.ECustomer;
/**
 * 	扩展的mapper
 * @author Mir Liu
 *
 */
public interface ECustomerExtendMapper {
	//查找
	ECustomer findByName(String username);
	//注册输入
	int saveECustomer(ECustomer cus);
	
}
