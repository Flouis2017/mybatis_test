package com.flouis.mybatis.entity;

public class Order {
	
	private int id;
	private String orderCode;
	private float orderPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public Order(){}
	
	public Order(String orderCode, float orderPrice) {
		this.orderCode = orderCode;
		this.orderPrice = orderPrice;
	}
	
	public Order(int id, String orderCode, float orderPrice) {
		this.id = id;
		this.orderCode = orderCode;
		this.orderPrice = orderPrice;
	}
}
