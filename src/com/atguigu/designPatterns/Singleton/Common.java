package com.atguigu.designPatterns.Singleton;

public class Common {

	public static Common getCommon() {
		return new Common();
	}
	
	public static void main(String[] args) {
		Common c = Common.getCommon();
		Common c2 = Common.getCommon();
		System.out.println(c==c2);
		System.out.println("c---->"+c);
		System.out.println("c2---->"+c2);
	}
}
