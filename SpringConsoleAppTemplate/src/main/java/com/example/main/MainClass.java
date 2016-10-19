package com.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springbean.Shape;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/app-context.xml");
		Shape shape = (Shape) context.getBean("rectangle");
		System.out.println("Shape object is :" + shape);
		((ConfigurableApplicationContext) context).close();
	}

}
