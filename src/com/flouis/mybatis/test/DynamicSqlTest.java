package com.flouis.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.flouis.mybatis.entity.SqlString;
import com.flouis.mybatis.entity.User;

public class DynamicSqlTest {
	
	@Test
	public void testGetUsersByCondition() throws Exception{
		String path = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(path);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.flouis.mybatis.resource.userMapper.";
		String operation = "getUsersByCondition";
		operation = "getUsersByCondition2";
		User userCondition = new User(-1,"%a%",24);
		List<User> userList = session.selectList(statement+operation,userCondition);
		if (userList!=null){
			for (User user:userList){
				System.out.println(user.getId()+" : "+
						user.getName()+" : "+user.getAge());
			}
		}
		session.close();
		reader.close();
	}
	
	@Test
	public void testgetUsersBySqlString() throws Exception{
		String path = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(path);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.flouis.mybatis.resource.userMapper.";
		String operation = "getUsersBySqlString";
		
		String tmpStr = "select * from users where name like '%n%' "+
				"and age >= 28";
		SqlString ss = new SqlString(tmpStr);
		List<User> userList = session.selectList(statement+operation,ss);
		if (userList!=null){
			for (User u:userList){
				System.out.println(u.getId()+" : "+u.getName()+" : "+u.getAge());
			}
		}
		session.close();
		reader.close();
	}

}
