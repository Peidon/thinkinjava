package algorithm;

import java.util.Scanner;
/**
 * ����һ���������飬����������������0��Ҫ������ҳ�3�����ĳ˻���ʹ�ó˻����Ҫ��ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(1)
 */
public class MaxMultiply {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = cin.nextInt();
		}
		cin.close();
		long ret = multiMax(nums, n);
		System.out.println(ret);
	}

	private static long multiMax(int[] nums, int n) {
		long maxPos = 1, minNeg = -1, maxTwo = Integer.MIN_VALUE, minTwo = Integer.MAX_VALUE, max = 1;
		int i = 0;
		for (; i < 3; i++) {
			maxPos = Math.max(nums[i], maxPos);
			minNeg = Math.min(nums[i], minNeg);
			max = max * nums[i];
			for (int j = i + 1; j < 3; j++) {
				maxTwo = Math.max(nums[j] * nums[i], maxTwo);
				minTwo = Math.min(nums[j] * nums[i], minTwo);
			}
		}
		for (; i < n; i++) {
			if (nums[i] > 0) {
				max = Math.max(max, nums[i] * maxTwo);
				maxTwo = Math.max(maxTwo, maxPos * nums[i]);
				minTwo = Math.min(minTwo, minNeg * nums[i]);
				maxPos = Math.max(maxPos, nums[i]);
			} else if (nums[i] < 0) {
				max = Math.max(max, minTwo * nums[i]);
				maxTwo = Math.max(maxTwo, minNeg * nums[i]);
				minTwo = Math.min(minTwo, maxPos * nums[i]);
				minNeg = Math.min(minNeg, nums[i]);
			}
		}
		return max;
	}
}
