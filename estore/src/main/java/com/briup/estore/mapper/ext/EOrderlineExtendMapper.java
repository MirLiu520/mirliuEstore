package com.briup.estore.mapper.ext;

import com.briup.estore.bean.EOrderline;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EOrderlineExtendMapper {
   
    int saveOrderLines(
    		@Param("lines")Collection<EOrderline> order, 
    		@Param("orderId")int orderId);
}