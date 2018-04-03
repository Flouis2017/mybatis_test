package com.flouis.mybatis.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class ProcedureTest {
	
	@Test
	public void testInvokeProcedure() throws Exception{
		String path = "com/flouis/mybatis/resource/mybatis_conf.xml";
		Reader reader = Resources.getResourceAsReader(path);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		String statement = "com.flouis.mybatis.resource.personMapper.";
		String operation = "getCountByGender";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("gender_flag", 1);
		session.selectOne(statement+operation,map);
		System.out.println("0".equals(map.get("gender_flag"))? "女性数量:":"男性数量:"+map.get("result_count"));
		session.close();
		reader.close();
	}

}
