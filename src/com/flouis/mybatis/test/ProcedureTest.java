package com.flouis.mybatis.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.flouis.mybatis.mapper.PersonMapper;

public class ProcedureTest {
	
	@Test
	public void testInvokeProcedure() throws Exception{
		String path = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(path);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		String statement = "com.flouis.mybatis.mapper.PersonMapper.";
		String operation = "getCountByGender";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("gender_flag", 0);
		session.selectOne(statement+operation,map);
		System.out.println(map);
		session.close();
		reader.close();
	}
	
	@Test
	public void testInvokeProcedure2() throws Exception{
		String path = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(path);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		PersonMapper pm = session.getMapper(PersonMapper.class);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("gender_flag", 0);
		pm.getCountByGender2(map);
		System.out.println(map);
		session.close();
		reader.close();
	}

}
