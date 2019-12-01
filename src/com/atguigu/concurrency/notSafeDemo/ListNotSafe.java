package com.atguigu.concurrency.notSafeDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 浠ｇ爜璇佹槑ArrayList绾跨▼涓嶅畨鍏�
 * 
 * @author DETBG23
 *
 */
public class ListNotSafe {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> list = new ArrayList<Integer>();

		// 璇诲啓鍚屾椂杩涜锛宩ava.util.concurrentModificationException
		
		  for(int i = 0;i<=5;i++) { new Thread(()->{ list.add(2); }).start(); }
		  
		 System.out.println(list);
		 

		// 浣跨敤Collections宸ュ叿绫荤殑鍚屾鏂规硶淇濊瘉绾跨▼瀹夊叏
		
//		  List<Integer> list2 = Collections.synchronizedList(list);
//		  
//		  for (int i = 0; i <= 5; i++) { new Thread(() -> { list2.add(2); }).start(); }
//		   
//		  System.out.println(list2); Thread.sleep(200); System.out.println(list2);
//		 

		// CopyOnWriteArrayList 鐨刟dd鏂规硶鐢ㄧ殑灏辨槸鍙噸鍏ラ攣
//		List<Integer> coList = new CopyOnWriteArrayList<Integer>();
//		for (int i = 0; i <= 5; i++) {
//			new Thread(() -> {
//				coList.add(2);
//			}).start();
//		}
//
//		System.out.println(coList);
//		Thread.sleep(200);
//		System.out.println(coList);

	}
}
