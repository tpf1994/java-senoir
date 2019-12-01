package com.atguigu.concurrency.unsafe;

import sun.misc.Unsafe;

class VO {
	public int a = 0;

	public long b = 0;

	public static String c = "123";

	public static Object d = null;

	public static int e = 100;
}

public class UnsafeDemo {
	public static void main(String[] args) throws Exception {
		Unsafe unsafe = Unsafe.getUnsafe();
		// 获取实例字段的偏移地址,偏移最小的那个字段(仅挨着头部)就是对象头的大小
		System.out.println(unsafe.objectFieldOffset(VO.class.getDeclaredField("a")));
		System.out.println(unsafe.objectFieldOffset(VO.class.getDeclaredField("b")));

		// fieldOffset与objectFieldOffset功能一样,fieldOffset是过时方法,最好不要再使用
		System.out.println(unsafe.fieldOffset(VO.class.getDeclaredField("b")));

	}
}
