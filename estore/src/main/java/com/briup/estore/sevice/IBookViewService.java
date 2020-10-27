package com.briup.estore.sevice;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exception.EstoreServiceException;

public interface IBookViewService {
	EBook selectBook(int id) throws EstoreServiceException;
}
