/**
 * @FileName    BubbleSort.java
 * @Description 
 * @author      looton@163.com
 * @Date        2013-7-28
 */
package com.looyp.sort;

public class BubbleSort {

	public void bubbleSort(int[] sourceArray) {
		for (int i = 0; i < sourceArray.length; i++) {
			for (int j = 0; j < sourceArray.length - i - 1; j++) { // 这里-i主要是每遍历一次把最大的i个数沉到最底，不再替换
				if (sourceArray[j] > sourceArray[j + 1]) {
					int temp = sourceArray[j];
					sourceArray[j] = sourceArray[j + 1];
					sourceArray[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
		System.out.println("before sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		new BubbleSort().bubbleSort(a);

		System.out.println();

		System.out.println("after sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
