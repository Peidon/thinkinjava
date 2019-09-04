package algorithm;

import java.util.Scanner;
/**
 *  这个字典内的每个单词都包含n个'a'和m个'z', 并且所有单词按照字典序排列，找出第k个单词。
 *  
 */
public class DictSequence {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt(), m = cin.nextInt();
		long k = cin.nextInt();
		cin.close();
		long len = combine(n, m);
		if (k <= len) {
			while (n > 0 && m > 0) {
				len = combine(n - 1, m);
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
	
	//计算组合数C(r , n) = n! / ( r! * (n - r)! )
	private static long combine(int i, int j) {
		if (i == 0 || j == 0)
			return 1;
		double a = Math.min(i, j), b = a - 1, c = j + i;
		double d = c;
		double e;
		while (b > 0) {
			d = d * (c - b); // (j + 1) * (j + 2) * ... * (j + i) = (j + i) ! / j !
			a = a * b; //  i !
			// 防止数值溢出 --
			e = gcd(d, a);
			d = d / e;
			a = a / e;
			// --
			b--;
		}
		return (long)(d / a);
	}

	private static double gcd(double d, double a) {// 求最大公约数
		double r = d % a;
		if (r == 0)
			return a;
		return gcd(a, r);
	}
}
