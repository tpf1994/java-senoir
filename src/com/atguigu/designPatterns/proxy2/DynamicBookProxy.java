package com.atguigu.designPatterns.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicBookProxy {

//	private Books book;
	private Movie movie;
//	public DynamicBookProxy(Books book) {
//		this.book = book;
//	}
	public DynamicBookProxy(Movie movie) {
		this.movie = movie;
	}
	public Object createProxy() {
		return Proxy.newProxyInstance(movie.getClass().getClassLoader(),movie.getClass().getInterfaces(),
								new InvocationHandler() {
			@Override
			public Object invoke(Object proxy,Method method,Object[] args)throws Throwable {
				System.out.println("书店买书");
				Object res = method.invoke(movie,args);
				System.out.println("读后感。。。");
				return res;
			}
		});
	}
	
	public static void main(String[] args) {
//		Books book = new Poor();
		Movie movie = new GodFather();
		DynamicBookProxy proxy = new DynamicBookProxy(movie);
		((Movie) proxy.createProxy()).watchMovie();
	}
}
