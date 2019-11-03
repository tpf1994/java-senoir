package com.atguigu.designPatterns.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	private Notebook notebook;
	public DynamicProxy (Notebook notebook) {
		this.notebook = notebook;
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(notebook.getClass().getClassLoader(),notebook.getClass().getInterfaces(),
				new InvocationHandler() {
			@Override
			public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
				System.out.println("敲代码之前的通知。。。。");
				Object res = method.invoke(notebook,args);
				
				System.out.println("敲代码之后的通知。。。。");
				return res;
			}
		});
	}
	
	public static void main(String[] args) {
		Notebook notebook = new ThinkPad();
		DynamicProxy dynamicProxy = new DynamicProxy(notebook);
		Notebook note = (Notebook)dynamicProxy.getProxyInstance();
		note.code();
	}
}
