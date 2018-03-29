package com.flouis.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.flouis.mybatis.entity.Student;

public class CorrelationTest {

	@Test
	public void testOneToOneQuery() throws Exception{
		String resource = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.flouis.mybatis.resource.studentMapper.";
		String operation = "";
		operation = "getStudent";
		operation = "getStudent2";
		Student student = session.selectOne(statement+operation,4);
		System.out.println("Query Result As Below:");
		String res = student.getId()+" : "+student.getName()+" : ";
		res+= student.getMyClass() == null ? "No Class" : student.getMyClass().getName();
		System.out.println(res);
		session.close();
		reader.close();
	}
	
}
