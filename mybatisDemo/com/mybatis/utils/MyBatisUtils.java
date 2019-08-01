package com.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession getSqlSession(){
		try {
			//1.加载主配置文件
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			if (sqlSessionFactory == null) {
				//2.创建SqlSessionFaction对象
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
			//3.创建SqlSession对象
			return sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
