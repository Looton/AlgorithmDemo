/**
 * @FileName    QuickSort.java
 * @Description 快速排序
 * @author      looton@163.com
 * @Date        2013-7-31
 */
package com.looyp.sort;

public class QuickSort {
	public void quickSort(int[] iArray, int low, int high) {
		// 方法接受三个参数，待排数组，低端下标，高端下标
		if (low < high) {
			int i = low;
			int j = high;
			int temp = iArray[i];
			while (i < j) {
				while (i < j && iArray[j] > temp) {// 从右端扫描，与标准数据元素temp比较，如果a[j]>temp,数据位置不变，继续向左端扫描
					j--;
				}
				if (i < j) {// 数据元素a[j]<temp,则与a[i]交换,使小于temp的元素在temp的左边，并把i值加1，并从数组的左端向右端扫描
					iArray[i] = iArray[j];
					i++;
				}
				while (i < j && iArray[i] < temp) {// 数组的左端向右端扫描
					i++;
				}
				if (i < j) {// 数据元素a[i]>emp,则与a[j]交换,使大于temp的元素在temp的右边边，并把j值减1，并从数组的由端向左端扫描
					iArray[j] = iArray[i];
					j--;
				}
			}
			iArray[i] = temp;
			quickSort(iArray, low, i - 1);// 对左端子集合进行递归
			quickSort(iArray, i + 1, high); // 对右端子集合进行递归

		}
	}

	public static void main(String[] args) {
		int[] test = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
		System.out.println("before sort:");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}

		new QuickSort().quickSort(test, 0, test.length - 1);

		System.out.println();

		System.out.println("after sort:");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
}
