package com.briup.estore.sevice.impl;

import static com.briup.estore.common.utils.MyBatisUtils.openSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.mapper.ext.ECustomerExtendMapper;
import com.briup.estore.sevice.IUserService;

public class UserServiceImpl implements IUserService {
	// 接口实现类映射
	// ECustomerMapper customerMapper=
	// openSession().getMapper(ECustomerMapper.class);
	// ECustomerExtendMapper
	// mapper=openSession().getMapper(ECustomerExtendMapper.class);
	// 首页注册
	@Override
	public boolean register(ECustomer cus) throws EstoreServiceException {
		// 打开会话
		SqlSession session = openSession();
		try {
			ECustomerExtendMapper mapper = session.getMapper(ECustomerExtendMapper.class);
			// 根据用户名检索
			ECustomer findUser = mapper.findByName(cus.getUsername());
			if (findUser != null)// 如果用户名已存在，则返回注册失败
			{
				throw new EstoreServiceException("用户名已被注册！！！");
			}
			mapper.saveECustomer(cus);
			// 事务提交
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new EstoreServiceException("注册失败！" + e.getMessage(), e);
		} finally {
			// 关闭会话
			session.close();
		}
	}

	@Override
	public ECustomer login(String name, String password) throws EstoreServiceException {
		SqlSession session = openSession();
		
		try{
			ECustomerExtendMapper mapper = session.getMapper(ECustomerExtendMapper.class);
			//根据用户名查找是否存在
			ECustomer cus = mapper.findByName(name);
			if(cus==null) {
				throw new EstoreServiceException("用户不存在！");
			}
			if (!password.equals(cus.getPassword())) {
				throw new EstoreServiceException("用户名或密码错误");
			}
			return cus;
		}catch (Exception e) {
			throw new EstoreServiceException(e);
		}finally {
			session.close();
		}
	}

}
