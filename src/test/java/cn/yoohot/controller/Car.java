package cn.yoohot.controller;

import org.springframework.beans.factory.annotation.Value;


public class Car {
	@Value("#{loadProperties['carName']}")
	private String name;
	
	@Value("#{loadProperties['price']}")
	private Integer price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}
	
	
	

}
