/**
 * @FileName    PrimeNumTest.java
 * @Description 判断两个数之间的素数个数
 * @author      looton@163.com
 * @Date        2013-7-27
 */
package com.looyp.typical40topic;

import java.util.Vector;

public class PrimeNumTest {
	public Vector primeNum(int smallNum, int largeNum) {
		Vector v = new Vector();
		if (largeNum <= smallNum) {
			System.out.println("error input ");
			System.exit(0);
		}
		for (int i = smallNum; i <= largeNum; i++) {
			boolean flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				v.add(i);
			}
		}
		return v;
	}

	public static void main(String[] args) {
		Vector vector = new PrimeNumTest().primeNum(1, 17);
		System.out.println(vector);
	}
}
