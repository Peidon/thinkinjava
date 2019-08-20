package algorithm;

import java.util.Scanner;

/**
 * 六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 * 
 */
public class Coins {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		long[] F = new long[n + 1];
		int[] coins = new int[] { 1, 5, 10, 20, 50, 100 };
		F[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= n; j++) {
				// 前 i 种纸币组成 j 元的组合个数 = 组成 j 元的纸币中 _包含_ 第 i 个时的组合个数 + _不包含_ 第 i 个时的组合个数
				// 所谓 _包含_ 第 i 个 的情况， 就是确定至少有一个 coins[i]的情况，
				// 即包括了有一个coins[i]的情况、两个coins[i]的情况、三个coins[i]的情况... 直到 k 个的时候大于 j 为止
				F[j] = F[j] + F[j - coins[i]];
			}
		}
		System.out.println("F[] : " + F[n]);
		System.out.println("f() : " + Coins.f(coins, 5, n));
		cin.close();
	}

	static int f(int[] coins, int i, int j){
		if(i == 0 || j == 0) return 1;
		int sum = 0;
		int k = 1;
		int tmp = j;
		while(tmp >= 0){
			sum += f(coins,i - 1, tmp);
			tmp = j - k * coins[i];
			k++;
		}
		return sum;
	}
}