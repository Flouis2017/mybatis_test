package com.flouis.mybatis.entity;

public class Major {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Major(){}
	
	public Major(String name){
		this.name = name;
	}

	public Major(int id,String name){
		this.id = id;
		this.name = name;
	}
}
