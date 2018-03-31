package com.flouis.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.flouis.mybatis.entity.Classes;
import com.flouis.mybatis.entity.Major;
import com.flouis.mybatis.entity.Student;

public class CorrelationTest {

	@Test
	public void testOneToOneQuery() throws Exception{
		String resource = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.flouis.mybatis.resource.classesMapper.";
		String operation = "getClass";
//		operation = "getClass2";
		Classes c = session.selectOne(statement+operation, 2);
//		System.out.println(c.getStudentList());
		String res = c.getId()+" : "+c.getClassCode()+" : ";
		res += c.getMajor() == null ? "Prior Course" : c.getMajor().getName();
		System.out.println(res);
		
		session.close();
		reader.close();
	}
	
	@Test
	public void testOneToMany() throws Exception{
		String resource = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.flouis.mybatis.resource.classesMapper.";
		String operation = "selectClass";
		operation = "selectClass2";
		Classes c = session.selectOne(statement+operation,1);
		System.out.println("The Result as below:");
		System.out.println("Class : " + c.getClassCode());
		System.out.println("Major : " + c.getMajor().getName());
		System.out.println("Student List : ");
		if (c.getStudentList() == null){
			System.out.println("null");
		} else {
			for (Student student : c.getStudentList()){
				System.out.println(student.getId()+" : "+student.getName());
			}
		}
		session.close();
		reader.close();
		
	}
	
	
	@Test
	public void testAddMajor() throws Exception{
		String resource = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.flouis.mybatis.resource.majorMapper.";
		String operation = "addMajor";
		Major major = new Major("Computer English");
		session.insert(statement+operation, major);
		session.close();
		reader.close();
	}
	
}
