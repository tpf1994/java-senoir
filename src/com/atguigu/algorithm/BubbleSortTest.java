package com.atguigu.algorithm;

import java.util.Arrays;

public class BubbleSortTest {

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		System.out.println("Before sort:"+Arrays.toString(arr));
		for(int i=0;i<n;i++) {
			boolean flag = true;
			for(int j=0;j<n-i-1;j++) {
				int temp;
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
			System.out.println("After sort:"+Arrays.toString(arr));
		}
	}
	public static void main(String[] args) {
		int [] arr= {3,6,8,2,4,1,7,0};
		BubbleSortTest.bubbleSort(arr);
	}
}
