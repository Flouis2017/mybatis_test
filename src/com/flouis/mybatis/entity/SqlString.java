package com.flouis.mybatis.entity;
public class SqlString {
	private String sqlString;
	public void setSqlString(String sqlString){
		this.sqlString = sqlString;
	}
	public String getSqlString(){
		return this.sqlString;
	}
	public SqlString(String sqlString){
		this.sqlString = sqlString;
	}
}


