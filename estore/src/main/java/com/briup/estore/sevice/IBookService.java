package com.briup.estore.sevice;

/**
 * 	获取所有图书信息
 * @author Mir Liu
 *
 */

import java.util.List;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exception.EstoreServiceException;

public interface IBookService {
	List<EBook> getAllBook() throws EstoreServiceException;
}
