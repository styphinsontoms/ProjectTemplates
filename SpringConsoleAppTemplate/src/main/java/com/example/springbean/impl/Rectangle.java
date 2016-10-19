package com.example.springbean.impl;

import org.springframework.stereotype.Component;

import com.example.springbean.Shape;

@Component
public class Rectangle implements Shape {
	private String shapeName="RECTANGLE";
	@Override
	public void draw() {
		System.out.println("Inside Rectangle >> draw() method."+shapeName);
	}
	@Override
	public String toString() {
		return "Rectangle [shapeName=" + shapeName + "]";
	}
	
}