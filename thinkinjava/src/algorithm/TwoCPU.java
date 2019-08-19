package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一种双核CPU的两个核能够同时处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 * 
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
 * 
 * n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少， 求这个最小的时间。
 * 
 * 思路：在不超过总任务的1/2的情况下，拼凑出最大值。
 * 
 */
public class TwoCPU {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = Integer.parseInt(s) + 1;
		if (n > 1) {
			int a[] = new int[n];
			int sum = 0;
			int i = 1;
			while (n > i) {
				a[i] = Integer.parseInt(sc.next()) >> 10;
				sum += a[i];
				i++;
			}
			sc.close();
			Arrays.sort(a);// 这一步是必须的
			final int len = sum >> 1;
			int[][] F = new int[n][(len) + 1];//必须是二维数组
			if (a[n - 1] > len) {
				System.out.println(sum - a[n - 1]);
				return;
			}
			for (i = 1; i < n; i++) {
				for (int j = a[i]; j <= len; j++) {
					F[i][j] = Math.max(F[i - 1][j], F[i - 1][j - a[i]] + a[i]);
				}
			}
			int c = (sum - F[n - 1][len]) << 10;
			System.out.println(c);
		}
	}
}
