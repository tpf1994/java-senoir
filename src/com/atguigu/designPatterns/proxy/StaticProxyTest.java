package com.atguigu.designPatterns.proxy;

public class StaticProxyTest {

	public static void main(String[] args) {
		BasketballPlayer player = new Griffin();
		StaticProxy proxy = new StaticProxy(player);
		proxy.playBasketball();
	}
}
