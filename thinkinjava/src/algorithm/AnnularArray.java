package algorithm;

import java.util.Scanner;

public class AnnularArray {
/** 
 * 给定N,K以及一个环：A[1],A[2],A[3],...A[N]，其中A[1]的左边是A[N],求该环上最大的连续子段和，要求选出的子段长度不超过M。
 * 
 * 思路：先考虑没有 M 限制会怎么样，要善于转化问题。
 * 
 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		final int len = n + m - 1;
		int[] list = new int[len];
		for (int i = 0; i < n; i++) {
			list[i] = cin.nextInt();
		}
		cin.close();
		System.arraycopy(list, 0, list, n, m - 1);
		int max = Integer.MIN_VALUE;
		int i = 0;
		while(list[i] < 0 && i++ < n);// 找到第一个正数
		if(i == n){// 没有正数, 就找最大的数
			for(i = 0; i < n; i++){
				if(list[i] > max){
					max = list[i];
				}
			}
		}else{
			int sum[] = new int[len];// sum[i]代表以 i 为右边界的数组片段和，这个片段长度是未知的，但是必须保证小于m
			max = sum[i] = list[i];
			int tag = i - 1;// 令 x < tag 时 , 逻辑上 sum[x] = 0
			while(++i < len){
				if(sum[i - 1] + list[i] <= 0){
				// 前 i个元素不参与之后的计算,那么前 i 个 sum 全都要清零，sum[i] = 0，sum[i - 1] = 0...但是这样写麻烦，所以有tag
				tag = i;
				}else{
					// 关键的一步, m 个元素之和转化为 sum[i] - sum[i-m]，而sum[i] = sum[i - 1] + list[i];
					if(i - m > tag)
						sum[i] = sum[i - 1] + list[i] - sum[i - m];
					else
						sum[i] = sum[i - 1] + list[i];
					max = Math.max(sum[i], max);
				}
			}
		}
		System.out.println(max);
	}
}