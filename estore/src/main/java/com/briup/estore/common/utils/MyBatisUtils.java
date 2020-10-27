package com.briup.estore.common.utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 *  	封装MyBatisUtils对象
 *  	后续需要获取sqlsession对象进行操作，那么只需要调用MyBatisUtils.openSission()
 * @author Mir Liu
 *
 */
public class MyBatisUtils {
	private static SqlSessionFactory sf;
	static {
		try {
			sf = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static SqlSession openSession() {
		return sf.openSession();
	}
}
