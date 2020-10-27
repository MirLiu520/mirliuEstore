package com.briup.estore.mapper.ext;

import java.util.List;

import com.briup.estore.bean.ECategory;
import com.briup.estore.common.exception.EstoreServiceException;

public interface ECategoryExtendMapper {
	//获取所有的顶级分类,以及相关的小分类
	List<ECategory> selectAll() throws EstoreServiceException;
}
