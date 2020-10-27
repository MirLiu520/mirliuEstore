package com.briup.estore.sevice;

import com.briup.estore.bean.EOrder;
import com.briup.estore.common.exception.EstoreServiceException;

public interface IOrderService {
	/**
	 * 
	 * 	保存订单
	 * @param order
	 * @return
	 * @throws EstoreServiceException
	 */
	int saveOrder(EOrder order) throws EstoreServiceException;
}
