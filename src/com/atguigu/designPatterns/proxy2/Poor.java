package com.atguigu.designPatterns.proxy2;

public class Poor implements Books{

	@Override
	public void read() {
		System.out.println("I'm reading PoorCharlie!!!");
	}
}
