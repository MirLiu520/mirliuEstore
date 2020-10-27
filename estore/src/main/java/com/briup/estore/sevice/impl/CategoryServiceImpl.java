package com.briup.estore.sevice.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ECategory;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.ext.ECategoryExtendMapper;
import com.briup.estore.sevice.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public List<ECategory> getAllCategery() throws EstoreServiceException {
		SqlSession session = MyBatisUtils.openSession();
		try {
			ECategoryExtendMapper mapper = session.getMapper(ECategoryExtendMapper.class);
			List<ECategory> selectAll = mapper.selectAll();
			return selectAll;
		} finally {
			session.close();
		}
	}

}
