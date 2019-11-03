package com.atguigu.designPatterns.proxy1;

public class CarStaticProxy implements Car{

	private Car car;
	
	public CarStaticProxy(Car car) {
		this.car = car;
	}
	@Override
	public void drive() {
		System.out.println("启动引擎");
		car.drive();
		System.out.println("飙起来啦！！！");
	}

}
