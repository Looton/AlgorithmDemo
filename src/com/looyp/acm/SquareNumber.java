/**
 * @FileName    SquareNumber.java
 * @Description 
 * @author      lyp3314@gmail.com
 * @Time        2013-5-28:上午10:22:54
 */
package com.looyp.acm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 本解决方案假定M个整数均>0, 输入格式严整正确且在int32范围内
 */
public class SquareNumber {

	int N;
	int M;
	int[] NPs = new int[30]; // N个质子
	int[] MIs = new int[30000]; // M个整数
	byte[][] PCs = new byte[30000][30]; // 每个整数里的每个质因子个数的奇偶性
	byte[] totalPCs = new byte[30]; // 全体奇偶性
	byte[] totalPCsTmp = new byte[30];

	/**
	 * 计算一组数据(三行)的最大完全平方数的子数列坐标
	 */
	public void analyzeThisRace() {
		int tmp;
		byte b = 0;
		for (int i = 0; i < M; i++) {
			tmp = MIs[i];
			for (int j = 0; j < N; j++) {
				while (tmp % NPs[j] == 0) {
					tmp = tmp / NPs[j];
					PCs[i][j] ^= 1;
				}
				totalPCs[j] ^= PCs[i][j];
				if (tmp == 1) {
					break;
				}
			}
		}

		int headC, tailC;
		for (int i = 0; i <= M; i++) {// 去掉头尾总计i个整数后,看看是否是完全平方数
			if (i == (M - 1)) { // 只检查一个数是不是完全平方数 (此判断直接i==M输出NONE也可以)
				boolean find = false;
				for (int index = 0; index < M; index++) {
					b = 0;
					for (int ni = 0; ni < N; ni++) {
						b += PCs[index][ni];
					}
					if (b == 0) {
						System.out.println((index + 1) + " " + (index + 1));
						find = true;
					}
				}
				if (!find) {
					System.out.println("None");
				}
				break;
			}
			else if (i == 0) { // 没有去,检查是否此M个整数积就是完全平方数
				b = 0;
				for (int j = 0; j < N; j++) {
					b += totalPCs[j];
				}
				if (b == 0) {
					System.out.println("1 " + M);
					break;
				}
			}
			for (headC = 0; headC <= i; headC++) {
				tailC = i - headC;
				System.arraycopy(totalPCs, 0, totalPCsTmp, 0, N);
				for (int j = 0; j < headC; j++) {
					for (int ni = 0; ni < N; ni++) {
						totalPCsTmp[ni] ^= PCs[j][ni];
					}
				}
				for (int j = 0; j < tailC; j++) {
					for (int ni = 0; ni < N; ni++) {
						totalPCsTmp[ni] ^= PCs[M - j - 1][ni];
					}
				}
				b = 0;
				for (int j = 0; j < N; j++) {
					b += totalPCsTmp[j];
				}
				if (b == 0) {
					System.out.println((headC + 1) + " " + (M - tailC));
					i = M; // 如此可以跳出整个循环
					break;
				}
			}
		}

		// 为下一次计算奇偶性清空标志
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				PCs[i][j] = 0;
			}
		}
		for (int j = 0; j < N; j++) {
			totalPCs[j] = 0;
		}
	}

	// 读文件 载入数据用
	public void startByReadFile(BufferedReader reader) {
		String line1;
		String line2;
		String line3;
		String[] splits;
		int from = 0, to = 0, count = 0;
		try {
			while (reader.ready()) {
				line1 = reader.readLine();
				splits = line1.split(" ");
				N = Integer.parseInt(splits[0]);
				M = Integer.parseInt(splits[1]);
				if (N == 0 && M == 0) {
					break;
				}
				if (N == 0 || M == 0) {
					System.out.println("None");
					continue;
				}
				line2 = reader.readLine();
				line3 = reader.readLine();

				// 读入N个质因子
				count = 0;
				from = 0;
				to = 0;
				while (count < N) {
					while (to < line2.length() && line2.charAt(to) != ' ') {
						to++;
					}
					NPs[count] = Integer.parseInt(line2.substring(from, to));
					from = ++to;
					count++;
				}

				// 读入M个整数
				count = 0;
				from = 0;
				to = 0;
				while (count < M) {
					while (to < line3.length() && line3.charAt(to) != ' ') {
						to++;
					}
					MIs[count] = Integer.parseInt(line3.substring(from, to));
					from = ++to;
					count++;
				}

				analyzeThisRace();
			}
			reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 *            测试中E:\\01.txt文件中存着测试数据
	 */
	public static void main(String[] args) {
		try {
			SquareNumber sn = new SquareNumber();
			BufferedReader reader = new BufferedReader(new FileReader("E:/squareNumberData.txt"));
			sn.startByReadFile(reader);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
