package algorithm;

import java.util.Scanner;

public class DictSequence {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt(), m = cin.nextInt();
		long k = cin.nextInt();
		cin.close();
		long len = count(n, m);
		if (k <= len) {
			while (n > 0 && m > 0) {
				len = count(n - 1, m);
				if (k <= len) {
					System.out.print('a');
					n--;
				} else {
					System.out.print('z');
					k = k - len;
					m--;
				}
			}
			while (n > 0) {
				System.out.print('a');
				n--;
			}
			while (m > 0) {
				System.out.print('z');
				m--;
			}
		} else
			System.out.println(-1);
	}

	static long count(int i, int j) {
		if (i == 0 || j == 0)
			return 1;
		double a = Math.min(i, j), b = a - 1, c = j + i;
		double d = c;
		double e = 0;
		while (b > 0) {
			d = d * (c - b);
			a = a * b;
			// 防止数值溢出
			e = gcd(d, a);
			d = d / e;
			a = a / e;
			// ///////////
			b--;
		}
		return (long)(d / a);
	}

	static double gcd(double d, double a) {// 求最大公约数
		double r = d % a;
		if (r == 0)
			return a;
		return gcd(a, r);
	}
}
