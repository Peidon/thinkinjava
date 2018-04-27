package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class TwoCPU {// 其实是个背包问题
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
			Arrays.sort(a);
			int[][] F = new int[n][(sum >> 1) + 1];
			for (i = 1; i < n; i++) {

				if (a[i] > (sum >> 1)) {
					F[n - 1][sum >> 1] = sum - a[i];
					break;
				}
				for (int j = a[0]; j <= (sum >> 1); j++) {// 其实这里可以直接令j =
															// 0,而我是令他等于最小的值，可以少计算一些不必要的
					if (j < a[i]) // 如果a[i]比边界都大，那肯定就不是子集
						F[i][j] = F[i - 1][j];
					else
						F[i][j] = Math.max(F[i - 1][j], F[i - 1][j - a[i]]
								+ a[i]);
				}
			}
			int c = (sum - F[n - 1][sum >> 1]) << 10;
			System.out.println(c);
		}
	}
}
