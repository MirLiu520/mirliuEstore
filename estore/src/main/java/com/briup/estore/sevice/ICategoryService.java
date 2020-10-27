package com.briup.estore.sevice;
/**
 * 	获取所有商品分类
 * @author Mir Liu
 *
 */

import java.util.List;

import com.briup.estore.bean.ECategory;
import com.briup.estore.common.exception.EstoreServiceException;

public interface ICategoryService {
	List<ECategory> getAllCategery() throws EstoreServiceException;
}
