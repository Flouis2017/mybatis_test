package com.flouis.mybatis.entity;

public class Person {
	
	private int id;
	private String name;
	private int gender;
	
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public Person(){}
	
	public Person(String name,int gender){
		this.name = name;
		this.gender = gender;
	}
	
	public Person(int id, String name, int gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
}
