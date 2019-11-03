package com.atguigu.designPatterns.proxy1;


/**
 * 动态代理编写步骤
 * @author DETBG23
 *
 */
public class DynamicProxyTest {

	public static void main(String[] args) {
		Benz car = new Benz();
		CarDynamicProxy carDynamicProxy = new CarDynamicProxy(car);
		Car car2= (Car) carDynamicProxy.getProxyObject();
		car2.drive();
		System.out.println("ddd");
	}
}
