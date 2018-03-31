package com.flouis.mybatis.entity;

import java.util.List;

public class Classes {
	
	private int id;
	private String classCode;
	private Major major;
	private List<Student> studentList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public Classes(){}
	
	public Classes(String classCode, Major major,
			List<Student> studentList) {
		this.classCode = classCode;
		this.major = major;
		this.studentList = studentList;
	}
	
	public Classes(int id, String classCode, Major major,
			List<Student> studentList) {
		this.id = id;
		this.classCode = classCode;
		this.major = major;
		this.studentList = studentList;
	}
}
