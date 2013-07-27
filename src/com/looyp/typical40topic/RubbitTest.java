/**
 * @FileName    Topic01.java
 * @Description 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，
 *              假如兔子都不死，问每个月的兔子总数为多少？   
 * @author      lyp3314@gmail.com
 * @Time        
 */

//程序分析：   兔子的规律为数列1,1,2,3,5,8,13,21....  斐波那契数列 Sn = Sn-1+Sn-2
package com.looyp.typical40topic;

public class RubbitTest {
	public static void main(String args[]) {
		int i = 0;
		for (i = 1; i <= 24; i++)
			System.out.println("第" + i + "个月的兔子总数: " + f(i));
	}

	public static int f(int x) {
		if (x == 1 || x == 2)
			return 1;
		else
			return f(x - 1) + f(x - 2);
	}
}
