package com.atguigu.designPatterns.proxy4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	private Teacher teacher;
	public DynamicProxy(Teacher teacher) {
		this.teacher = teacher;
	}
	public Object createProxy() {
		return Proxy.newProxyInstance(teacher.getClass().getClassLoader(),teacher.getClass().getInterfaces(),
				new InvocationHandler() {
			@Override
			public Object invoke(Object proxy,Method method,Object[] args)throws Exception {
				System.out.println("老师在路上");
				Object res = method.invoke(teacher,args);
				System.out.println("下课，全体起立");
				return res;
			}
		});
	}
	public static void main(String[] args) {
		Teacher teacher = new Daming();
		DynamicProxy dp = new DynamicProxy(teacher);
		Teacher tProxy = (Teacher) dp.createProxy();
		tProxy.teach();
	}
}
