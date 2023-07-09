package com.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	
	private static SqlSessionFactory sqlSessionFactory  ;
	static {
		try {
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			sqlSessionFactory = ssfb.build(in) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getsqlSessionFactory() {
			return sqlSessionFactory.openSession(true) ;
	}

}
