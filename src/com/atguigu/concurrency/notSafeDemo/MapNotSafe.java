package com.atguigu.concurrency.notSafeDemo;

import java.util.HashMap;

public class MapNotSafe {

	private static HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);

	public static void main(String[] args) {
		map.put(5, "C");

		for (int i = 0; i < 10; i++) {
			new Thread("Thread1") {
				public void run() {
					map.put(7, "B");
					System.out.println(map);
				};
			}.start();
		}
		for (int i = 0; i < 10; i++) {
			new Thread("Thread2") {
				public void run() {
					map.put(3, "A");
					System.out.println(map);
				};
			}.start();
		}
		System.out.println(map);
	}
}
