package algorithm;

import java.util.Scanner;

/**
 * ������� 1��5��10��20��50��100 Ԫ��ֽ�ң�����ÿ�ֱ�ֵ���������㹻�࣬��д���������NԪ��NΪ0~10000�ķǸ��������Ĳ�ͬ��ϵĸ�����
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
				// ǰ i ��ֽ����� j Ԫ����ϸ��� = ��� j Ԫ��ֽ���� _����_ �� i ��ʱ����ϸ��� + _������_ �� i ��ʱ����ϸ���
				// ��ν _����_ �� i �� ������� ����ȷ��������һ�� coins[i]�������
				// ����������һ��coins[i]�����������coins[i]�����������coins[i]�����... ֱ�� k ����ʱ����� j Ϊֹ
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