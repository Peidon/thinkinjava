package algorithm.sort;

/* T(n) = O(N*lnN) */
public class ShellSort extends SortStrategy {

	@Override
	public void sort(int[] arr) {

		int d = arr.length >> 1;
		while (d > 0) {
			for (int i = d; i < arr.length; i++) {
				int temp = arr[i];
				int j = i;
				for (;j > d - 1 && temp < arr[j - d]; j -= d) {
					arr[j] = arr[j - d];
				}
				arr[j] = temp;
			}
			d >>= 1;
		}
	}

}
