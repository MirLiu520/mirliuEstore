package com.briup.estore.sevice.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.common.utils.MyBatisUtils;
import com.briup.estore.mapper.EBookMapper;
import com.briup.estore.mapper.ext.ECustomerExtendMapper;
import com.briup.estore.sevice.IBookService;

public class BookServiceImpl implements IBookService {

	@Override
	public List<EBook> getAllBook() throws EstoreServiceException {
		SqlSession session = MyBatisUtils.openSession();
		try {
			EBookMapper mapper = session.getMapper(EBookMapper.class);
			List<EBook> selectAllBook = mapper.selectAll();
			selectAllBook.forEach(b -> {
				/*
				 * b.getId(); b.getName(); b.getPrice(); b.getCategoryId(); b.getImage();
				 */
				System.out.println(b.toString());
			});
			return selectAllBook;
		} finally {
			session.close();
		}

	}

}
