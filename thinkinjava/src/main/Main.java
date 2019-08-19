package main;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		final int n = 10;
		int a[][] = new int[n][n];
		LinkedList<Node> coders = new LinkedList<>();
		int count = 0; // 记录PM个数
		//输入
		int i = 0,j = 0;
		while(cin.hasNextLine()){
			j = 0;
			String line = cin.nextLine();
			if(line.equals("")) break;
			String[] v = line.split(" ");
			while(j < v.length){
				a[i][j] = Integer.parseInt(v[j]);
				if (a[i][j] == 1) {
					count++;
				}
				if (a[i][j] == 2) {
					coders.add(new Node(i, j));
				}
				j++;
			}
			i++;
		}
		//输入结束
		int step = 0;
		LinkedList<Node> que = new LinkedList<>();// que 存放新产生的 coder
		while (true) {
			que.clear();
			while (!coders.isEmpty()) {
				Node node = coders.removeFirst();
				if (node.y > 0)
					if (a[node.x][node.y - 1] == 1) {
						que.add(new Node(node.x, node.y - 1));
						a[node.x][node.y - 1] = 2;
						count--;
					}
				if (node.y < n - 1)
					if (a[node.x][node.y + 1] == 1) {
						que.add(new Node(node.x, node.y + 1));
						a[node.x][node.y + 1] = 2;
						count--;
					}
				if (node.x > 0)
					if (a[node.x - 1][node.y] == 1) {
						que.add(new Node(node.x - 1, node.y));
						a[node.x - 1][node.y] = 2;
						count--;
					}
				if (node.x < n - 1)
					if (a[node.x + 1][node.y] == 1) {
						que.add(new Node(node.x + 1, node.y));
						a[node.x + 1][node.y] = 2;
						count--;
					}
			}
			if(que.isEmpty()) break;
			step++;
			coders.addAll(que);//更新下一轮最外层的coder
		}
		if(count == 0) System.out.println(step);
		else System.out.println(-1);
		cin.close();
	}

	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}