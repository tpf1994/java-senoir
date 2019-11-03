package com.atguigu.concurrency.notSafeDemo;

import java.util.HashSet;
import java.util.Set;


class HiddenIterator {
	private final Set<Integer> set = new HashSet<>();

	public synchronized void add(Integer i) {
		set.add(i);
	}

	public synchronized void remove(Integer i) {
		set.remove(i);
	}

	public void addTen() {
		for (int i = 0; i < 10; i++) {
			set.add(i);
			System.out.println("...." + set);
		}
	}

}

/**
 * 单线程状态下的concurrentModificationException
 * 
 * @author DETBG23
 *
 */
public class HashSetUnsafe {

	public static void main(String[] args) {
		HiddenIterator hiddenIterator = new HiddenIterator();
		hiddenIterator.addTen();
	}
}
