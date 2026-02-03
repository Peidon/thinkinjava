package math.iteration;

public class GaussSeidel implements Iteration {

	public static void main(String[] args) {
		int n = s.nextInt();
		for (; n > 0; n--) {
			for (int i = 0; i < x.length; i++) {
				x[i] = b[i];
				for (int j = 0; j < x.length; j++) {
					if (i == j)
						continue;
					x[i] = x[i] - a[i][j] * x[j];
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
