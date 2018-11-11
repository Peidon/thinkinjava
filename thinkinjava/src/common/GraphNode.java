package common;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphNode {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		GraphNode[] g = new  GraphNode[n + 1];// g[0] is not used
		for (int i = 1; i <= n; i++) {
			g[i] = new GraphNode(i);
		}
		for (int i = 0; i < n - 1; i++) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			g[a].add(b);
			g[b].add(a);
		}
		int hi = g[1].height();
		System.out.println(2 * (n - 1) - hi);
		cin.close();
	}
	private LinkedList<GraphNode> list = new LinkedList<>();
	int[] exclusion; // exclude the previous node
	public int val;
	public GraphNode(int n) {
		exclusion = new int[n];
	}
	
	public int height(){
		int hi = 1;
		if(!list.isEmpty()) {
			Iterator<GraphNode> it = list.iterator();
			while(it.hasNext()){
				GraphNode next = it.next();
				if(exclusion[next.val] != 1){
					hi += next.height();
					exclusion[next.val] = 1;
				}
			}
		}
		return hi;
	}
	public LinkedList<GraphNode> getNext() {
		return list;
	}

	public void add(int val) {
		list.add(new GraphNode(val));
	}
}
