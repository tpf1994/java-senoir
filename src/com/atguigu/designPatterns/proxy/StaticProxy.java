package com.atguigu.designPatterns.proxy;

/**
 * 静态代理类，代理类和委托类一样实现同一个接口，篮球运动员
 * @author DETBG23
 *
 */
public class StaticProxy implements BasketballPlayer{

	private BasketballPlayer player;
	
	public StaticProxy(BasketballPlayer BasketballPlayer) {
		super();
		this.player = BasketballPlayer;
	}

	@Override
	public void playBasketball() {
		System.out.println("比赛热场中。。。");
		player.playBasketball();
		System.out.println("比赛结束，mvp...");
	}

}
