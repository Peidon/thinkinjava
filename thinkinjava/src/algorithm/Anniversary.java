package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Anniversary {

	/**
	 * 一个树状结构
	 * 
	 * 1. 每个城市是树的一个节点；
	 * 2. 城市之间的道路是树的一条边；
	 * 3. 树的根节点是首都。
	 * 
	 * 约束
	 * 
	 * 1. 一条道路要么不布置花灯，要么整条布置花灯，不能选择其中的某一段布置；
	 * 
	 * 2. 除非没有道路通向首都，否则至少为一条通向首都的道路布置花灯；
	 * 
	 * 3. 所有布置花灯的道路构成的子图是连通的，这保证国王从首都出发，能通过只走布置了花灯的道路，把所有的花灯游览完； 
	 * 
	 * 4. 如果某个城市（包括首都）有大于等于2条道路通向子城市，为了防止铺张浪费，最多只能选择其中的两条路布置花灯；
	 * 
	 * 5. 布置花灯的道路的总长度设定一个上限。
	 * 
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int m = cin.nextInt(), n = cin.nextInt();
		Vertex[] vset = new Vertex[n]; // 邻接列表
		// 初始化邻接表
		for (int i = 0; i < n; i++) {
			vset[i] = new Vertex();
		}
		int[] weights = new int[n]; // 节点入度的权重
		int u = cin.nextInt(), v = cin.nextInt(), d = cin.nextInt();
		int root = u; // 输入第一行路径信息，记下根节点
		vset[u].subs.add(v);
		weights[v] = d;
		for (int i = 1; i < n - 1; i++) {
			u = cin.nextInt();
			v = cin.nextInt();
			d = cin.nextInt();
			vset[u].subs.add(v);
			weights[v] = d;
		}
		TreeSet<Integer> set = vset[root].weight(vset, weights, m);
		System.out.println(set.last());
		cin.close();
	}

	static class Vertex {
		List<Integer> subs = new ArrayList<>(); // 子节点的标记集合
		TreeSet<Integer> wList = new TreeSet<>(); // 枚举出来的所有可能的权重值

		public TreeSet<Integer> weight(final Vertex[] vset, final int[] w,
				final int limit) {
			TreeSet<Integer> treeSet = new TreeSet<>();
			treeSet.add(0);// 哨兵
			int d;
			if (subs.isEmpty())
				return treeSet;
			Vertex v;
			for (int sub : subs) {
				v = vset[sub];
				d = w[sub];
				if (d <= limit) {
					v.wList = v.weight(vset, w, limit - d);// limit - d
					treeSet.add(d);
				}
				for (int i : v.wList) {
					if (d + i <= limit && i > 0)// 有 0 的话会造成重复
						treeSet.add(d + i);
				}
			}
			Vertex v2;
			int en;
			for (int i = 0, l = subs.size(), sub1, sub2; i < l; i++) {
				for (int j = i + 1; j < l; j++) {
					sub1 = subs.get(i);
					sub2 = subs.get(j);
					v = vset[sub1];
					v2 = vset[sub2];
					en = w[sub1] + w[sub2];
					for (int w1 : v.wList) 
						for (int w2 : v2.wList) 
							if (en + w1 + w2 <= limit)
								treeSet.add(en + w1 + w2);
				}
			}
			return treeSet;
		}
	}
}
