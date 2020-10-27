package com.briup.estore.mapper.ext;

import java.util.List;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exception.EstoreServiceException;

public interface EBookExtendMapper {
	List<EBook> selectAllBook() throws EstoreServiceException;
}
