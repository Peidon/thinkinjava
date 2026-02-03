package math.iteration;

import java.util.Arrays;

public class SOR{
	
	public static void main(String[] args) {
		double a[][] = { { 5.0, 2.0, 1.0 }, 
				 		{ -1.0, 4.0, 1.0 },
				 		{ 2.0, -3.0, -4.0 } };
		double[] b = { 5.2, -6.2, -4.9 };
		double[] x = { 0, 0, 0 };
		double w = 1.25;
		int n = 0;
		boolean c;
		do{
			c = false;
			double y[] = Arrays.copyOf(x, x.length);
			for (int i = 0; i < x.length; i++) {
				x[i] = b[i];
				for (int j = 0; j < x.length; j++) {
					if(i == j) continue;
					x[i] = x[i] - a[i][j] * x[j];
				}
				x[i] = x[i] * w / a[i][i];
				x[i] = (1 - w) * y[i] + x[i];
				if(Math.abs(x[i] - y[i]) >= 0.01){
					c = true;
				}
			}
			n ++;
		}while( c );
		System.out.println("µü´ú´ÎÊý£º" + n);
		System.out.print("x = (");
		for (double d : x) {
			System.out.print("  " + d);
		}
		System.out.print("  )T");
	}

}
