package com.briup.estore.sevice.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.ext.EBookViewExtendMapper;
import com.briup.estore.sevice.IBookViewService;

public class BookViewServiceImpl implements IBookViewService{

	@Override
	public EBook selectBook(int id) throws EstoreServiceException {
		SqlSession session = MyBatisUtils.openSession();
		try {
			EBookViewExtendMapper mapper = session.getMapper(EBookViewExtendMapper.class);
			EBook selectBook = mapper.selectBook(id);
			return selectBook;
		}finally {
			session.close();
		}
		
	}
	
}
