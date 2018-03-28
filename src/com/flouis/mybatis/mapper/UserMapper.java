package com.flouis.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.flouis.mybatis.entity.User;

/**
 * @author 
 * 		Flouis
 * @description 
 *		基于注解的形式完成数据库操作
 */
public interface UserMapper {

	@Insert("insert into users(name,age) values(#{name},#{age})")
	public int insertUser(User user);
	
	@Delete("delete from users where id=#{id}")
	public int deleteUserById(int id);
	
	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int updateUserById(User user);
	
	@Select("select * from users where id=#{id}")
	public User findUserById(int id);
	
	@Select("select * from users")
	public List<User> findAllUsers();
	
}
