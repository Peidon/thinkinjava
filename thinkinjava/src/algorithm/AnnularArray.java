package algorithm;

import java.util.Scanner;

public class AnnularArray {
/** 
 * ����N,K�Լ�һ������A[1],A[2],A[3],...A[N]������A[1]�������A[N],��û������������Ӷκͣ�Ҫ��ѡ�����Ӷγ��Ȳ�����M��
 * 
 * ˼·���ȿ���û�� M ���ƻ���ô����Ҫ����ת�����⡣
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
		while(list[i] < 0 && i++ < n);// �ҵ���һ������
		if(i == n){// û������, ����������
			for(i = 0; i < n; i++){
				if(list[i] > max){
					max = list[i];
				}
			}
		}else{
			int sum[] = new int[len];// sum[i]������ i Ϊ�ұ߽������Ƭ�κͣ����Ƭ�γ�����δ֪�ģ����Ǳ��뱣֤С��m
			max = sum[i] = list[i];
			int tag = i - 1;// �� x < tag ʱ , �߼��� sum[x] = 0
			while(++i < len){
				if(sum[i - 1] + list[i] <= 0){
				// ǰ i��Ԫ�ز�����֮��ļ���,��ôǰ i �� sum ȫ��Ҫ���㣬sum[i] = 0��sum[i - 1] = 0...��������д�鷳��������tag
				tag = i;
				}else{
					// �ؼ���һ��, m ��Ԫ��֮��ת��Ϊ sum[i] - sum[i-m]����sum[i] = sum[i - 1] + list[i];
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