package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class SwapCharacters {
	// 字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
	// 询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] chas = sc.next().toCharArray();
		int m = sc.nextInt();
		Object [] indexList = new Object[26];//记录每个字符出现的位置
		int fmax = 1;//在不超过移动次数 m 的情况下，连续相同字符的最大长度，最终的答案
		int i = 0;//当前扫描位置
		ArrayList<Integer> al = null;
		for(char c : chas){
			if(indexList[c - 'a'] == null){
				indexList[c - 'a'] = new ArrayList<Integer>();
			}
			al = (ArrayList<Integer>) indexList[c - 'a'];
			al.add(i);
			final int len = al.size();
			int max = 1;//在不超过移动次数 m 的情况下，连续相同字符的最大长度
			while(len > max){
				int off = len - max - 1;//截取末尾 max + 1 个位置，开始位置off = len - 1 - (max + 1 - 1)
				int move = 0;// max + 1 个连续字符需要移动的次数
				int centre = (max + 1) >> 1;
				int k = 0;
				for(;k < centre; k++){
					move += (al.get(k + 1 + off) - al.get(k + off) - 1) * (k+1);
				}
				for(int j = max - centre;k < max; k++,j--){// max - centre : 右侧剩余位置数
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