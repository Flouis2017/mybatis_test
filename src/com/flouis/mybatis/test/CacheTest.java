package com.flouis.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.flouis.mybatis.entity.User;

public class CacheTest {

	@Test
	public void testSecondLevelCache() throws Exception{
		String path = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(path);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		String statement = "com.flouis.mybatis.resource.userMapper.findUserById";
		User user = session.selectOne(statement,1);
		System.out.println(user);
		session.commit();
//		session.close();
//		session = ssf.openSession();
		user = session.selectOne(statement,1);
		System.out.println(user);
		
	}
	
}
