package com.atguigu.designPatterns.Singleton;

public class NotSafeTest {

	public static void main(String[] args) {

		
		/*
		 * for (int i = 0; i < 10; i++) { new Thread(()->{ SingletonLazyNotSafe notSafe
		 * = SingletonLazyNotSafe.getInstance(); System.out.println(notSafe);
		 * },"A").start();
		 * 
		 * }
		 */
		 
		
		  for (int i = 0; i < 110; i++) { new Thread(()->{ SingletonLazy safe =
		  SingletonLazy.getInstance(); System.out.println(safe); },"A").start();
		  
		  }
		 

	}
}
