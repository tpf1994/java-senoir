package com.atguigu.designPatterns.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class CarDynamicProxy {

	private Car car;
	public CarDynamicProxy(Car car) {
		this.car = car;
	}
	
	public Object getProxyObject() {
		return Proxy.newProxyInstance(car.getClass().getClassLoader()
				,car.getClass().getInterfaces(),new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("引擎启动"); 
						Object res = method.invoke(car,args); 
						System.out.println("起飞咯！！");
						return res;
					}
				});
	}
}

/*
 * new InvocationHandler() { public Object invoke(Object proxy,Method
 * method,Object[] args) throws Throwable{ System.out.println("引擎启动"); Object
 * res = method.invoke(car,args); System.out.println("起飞咯！！"); return res; } }
 */