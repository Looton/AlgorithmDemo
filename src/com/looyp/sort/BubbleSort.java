/**
 * @FileName    BubbleSort.java
 * @Description 
 * @author      looton@163.com
 * @Date        2013-7-28
 */
package com.looyp.sort;

public class BubbleSort {

	public void bubbleSort(int[] iArray) {
		// 接受数组作为参数，数组传递的是地址，因此直接修改数组内的数据
		for (int i = 0; i < iArray.length; i++) {
			// 外循环，循环的次数为数组的长度
			for (int j = 0; j < iArray.length - i - 1; j++) {
				// 内循环，对相邻元素比较.这里-i主要是每遍历一次把最大的i个数沉到最底，不再替换
				if (iArray[j] > iArray[j + 1]) {
					int temp = iArray[j];
					iArray[j] = iArray[j + 1];
					iArray[j + 1] = temp;
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
