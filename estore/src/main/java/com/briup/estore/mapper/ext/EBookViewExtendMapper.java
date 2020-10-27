package com.briup.estore.mapper.ext;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exception.EstoreServiceException;

public interface EBookViewExtendMapper {
	EBook selectBook(int id) throws EstoreServiceException;
}
