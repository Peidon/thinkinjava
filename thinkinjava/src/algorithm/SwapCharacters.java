package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class SwapCharacters {
	// �ַ���S��Сд��ĸ���ɣ�����Ϊn������һ�ֲ�����ÿ�ζ�������ѡ�ַ��������������������ĸ���н�����
	// ѯ�������ཻ��m��֮���ַ���������ж��ٸ�������λ���ϵ���ĸ��ͬ��
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] chas = sc.next().toCharArray();
		int m = sc.nextInt();
		Object [] indexList = new Object[26];//��¼ÿ���ַ����ֵ�λ��
		int fmax = 1;//�ڲ������ƶ����� m ������£�������ͬ�ַ�����󳤶ȣ����յĴ�
		int i = 0;//��ǰɨ��λ��
		ArrayList<Integer> al = null;
		for(char c : chas){
			if(indexList[c - 'a'] == null){
				indexList[c - 'a'] = new ArrayList<Integer>();
			}
			al = (ArrayList<Integer>) indexList[c - 'a'];
			al.add(i);
			final int len = al.size();
			int max = 1;//�ڲ������ƶ����� m ������£�������ͬ�ַ�����󳤶�
			while(len > max){
				int off = len - max - 1;//��ȡĩβ max + 1 ��λ�ã���ʼλ��off = len - 1 - (max + 1 - 1)
				int move = 0;// max + 1 �������ַ���Ҫ�ƶ��Ĵ���
				int centre = (max + 1) >> 1;
				int k = 0;
				for(;k < centre; k++){
					move += (al.get(k + 1 + off) - al.get(k + off) - 1) * (k+1);
				}
				for(int j = max - centre;k < max; k++,j--){// max - centre : �Ҳ�ʣ��λ����
					move += (al.get(k + 1 + off) - al.get(k + off) - 1) * j;
				}
				if (move > m)
					break;
				max++;
			}
			i++;
			fmax = Math.max(fmax, max);
		}
		System.out.println(fmax);
		sc.close();
	}
}