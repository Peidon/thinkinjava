package algorithm;

import java.util.Scanner;
   
public class MaxArea {
	/**
	* ����һ����������, ��Ҫ��ѡ��һ������, ʹ�ø����������������о������¼����ֵ����һ����
	�����е���С�� * �����������ĺ�����������������������ֵ���ɣ�����Ҫ�����������䡣
	���������  [6 2 1]�����������ʽ, �ɵõ����п���ѡ����������ļ���ֵ:
	[6] = 6 * 6 = 36;
	[2] = 2 * 2 = 4;
	[1] = 1 * 1 = 1;
	[6,2] = 2 * 8 = 16;
	[2,1] = 1 * 3 = 3;
	[6, 2, 1] = 1 * 9 = 9;
	����������ɼ�ѡ������ [6] ������ֵΪ 36�� ��������Ϊ 36��
	�����ڵ��������ֶ���[0, 100]�ķ�Χ��;
	*/
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int array[] = new int[n];
        for(int i = 0; i < n; i++){
        	array[i] = cin.nextInt();
        }
        cin.close();
        int maxpro = 0;
        for(int i = 0, l, r, sum; i < n; i++){
        	l = i - 1;
        	r = i + 1;
        	sum = array[i];
        	while(l >= 0 && array[l] >= array[i]){
        		sum += array[l];
        		l--;
        	}
        	while(r < n && array[r] >= array[i]){
        		sum += array[r];
        		r++;
        	}
        	maxpro = Math.max(maxpro, array[i] * sum);
        }
        System.out.println(maxpro);
    }
}
