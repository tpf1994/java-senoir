package com.atguigu.designPatterns.proxy;


public class DynamicProxyTest {
	
	public static void main(String[] args) {
	
		BasketballPlayer basketballPlayer = new Griffin();
		BasketballPlayer dynamicPlayer = (BasketballPlayer) new DynamicProxy(basketballPlayer).getProxyObject();
		
		dynamicPlayer.playBasketball();
	}


}
