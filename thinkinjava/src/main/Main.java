package main;

import java.util.Scanner;

public class Main {
	/*
	input: n d local[], n = local.len, any j > i, local[j] - local[i] <= d
	output: summary of combinations of three in local
	 */

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		final int n = cin.nextInt();
		final int d = cin.nextInt();
		final int[] local = new int[n];
		for(int i = 0; i < n; i++) local[i] = cin.nextInt();
		cin.close();

		long count = 0;
		int right = 2;
		int left = 0;
		while(right < n){
			while(left < right && local[right] - local[left] > d) left ++;
			final int m = right - left;
			if(m >= 2) count += m * (m -1) / 2;
			right ++;
		}
		System.out.println(count % 99997867);
	}
}