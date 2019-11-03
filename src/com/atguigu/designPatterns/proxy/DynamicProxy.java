package com.atguigu.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	private BasketballPlayer basketballPlayer;

	public DynamicProxy(BasketballPlayer basketballPlayer) {
		this.basketballPlayer = basketballPlayer;
	}

	public Object getProxyObject() {
		return Proxy.newProxyInstance(basketballPlayer.getClass().getClassLoader(),
				basketballPlayer.getClass().getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("前置通知");
						Object res = method.invoke(basketballPlayer, args);
						System.out.println("后置通知");
						return res;
					}
				});
	}
}
