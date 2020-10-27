package com.briup.estore.mapper;

import com.briup.estore.bean.EOrderline;
import java.util.List;

public interface EOrderlineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EOrderline record);

    EOrderline selectByPrimaryKey(Integer id);

    List<EOrderline> selectAll();

    int updateByPrimaryKey(EOrderline record);
}