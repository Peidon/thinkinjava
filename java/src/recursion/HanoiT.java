package recursion;

import java.util.Scanner;

public class HanoiT {
	void move(char chSour , char chDest){
		System.out.println("Move the Top plate of " + chSour + 
				"-->" + chDest);
	}
	void hanoi(int n,char a,char b,char c){
		if( n == 1 ){
			move(a,c);
		}else{
			hanoi(n-1,a,c,b);
			this.move(a,c);
			hanoi(n-1,b,a,c);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please Input the number of plate :");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HanoiT tower = new HanoiT();
		tower.hanoi(n,'a','b','c');
	}

}
