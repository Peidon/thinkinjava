package math.iteration;

import java.util.Arrays;

public class Jacobi implements Iteration {
	public static void main(String[] args) {
		int n = s.nextInt();
		for (; n > 0; n--) {
			double y[] = Arrays.copyOf(x, x.length);
			for (int i = 0; i < x.length; i++) {
				x[i] = b[i];
				for (int j = 0; j < x.length; j++) {
					if (i == j)
						continue;
					x[i] = x[i] - a[i][j] * y[j];
				}
				x[i] = x[i] / a[i][i];
			}
		}
		System.out.print("x = (");
		for (double d : x) {
			System.out.print("  " + d);
		}
		System.out.print("  )T");
	}
}