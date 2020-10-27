package com.briup.estore.sevice.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EOrder;
import com.briup.estore.bean.EOrderline;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.EOrderMapper;
import com.briup.estore.mapper.ext.EOrderExtendMapper;
import com.briup.estore.mapper.ext.EOrderlineExtendMapper;
import com.briup.estore.sevice.IOrderService;

public class OrderServiceImpl implements IOrderService{

	@Override
	public int saveOrder(EOrder order) throws EstoreServiceException {
		SqlSession session = MyBatisUtils.openSession();
		try {
			EOrderExtendMapper mapper = session.getMapper(EOrderExtendMapper.class);
			EOrderlineExtendMapper linemapper=session.getMapper(EOrderlineExtendMapper.class);
			mapper.saveOrder(order);
			linemapper.saveOrderLines(order.getLines(), order.getId());
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new EstoreServiceException(e);
		}finally {
			session.close();
		}
		return 0;
	}

}
