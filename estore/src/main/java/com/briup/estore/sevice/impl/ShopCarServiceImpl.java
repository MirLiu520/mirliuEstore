package com.briup.estore.sevice.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EBook;
import com.briup.estore.bean.ShopingCar;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.EBookMapper;
import com.briup.estore.sevice.IShopCarService;

public class ShopCarServiceImpl implements IShopCarService{

	@Override
	public void addShopCar(ShopingCar car, int bookId, int num) throws EstoreServiceException {
		SqlSession session=MyBatisUtils.openSession();
		EBookMapper mapper = session.getMapper(EBookMapper.class);
		
		try {
			EBook book = mapper.selectByPrimaryKey(bookId);
			car.add(book, num);
			
		} finally {
			session.close();
		}
	}
	
}
