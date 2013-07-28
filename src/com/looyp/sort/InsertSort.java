/**
 * @FileName    InsertSort.java
 * @Description 
 * @author      looton@163.com
 * @Date        2013-7-28
 */
package com.looyp.sort;

public class InsertSort {
	public void insertSort(int[] sourceArray) {
		for (int i = 1; i < sourceArray.length; i++) {
			int temp = sourceArray[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				if (sourceArray[j] > temp) {
					sourceArray[j + 1] = sourceArray[j];
				}
				else {
					break;
				}
			}
			sourceArray[j + 1] = temp;// 注意这里j+1 与上面for里的j+1的区别
		}
	}

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
		System.out.println("before sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		new InsertSort().insertSort(a);

		System.out.println();
		System.out.println("after sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
