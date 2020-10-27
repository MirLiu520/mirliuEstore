package com.briup.estore.sevice;

import com.briup.estore.bean.ShopingCar;
import com.briup.estore.common.exception.EstoreServiceException;
/**
 * @param car 购物车
 * @param bookId 即将添加的商品
 * @param num 添加的数量
 * @author Mir Liu
 *
 */
public interface IShopCarService {
	public void addShopCar(ShopingCar car,int bookId,int num) throws EstoreServiceException;
}
