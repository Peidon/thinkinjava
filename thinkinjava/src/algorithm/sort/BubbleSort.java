package algorithm.sort;

public class BubbleSort extends SortStrategy {

	@Override
	public void sort(int arr[]) {
		int len = arr.length;
		for (int j = 0; len > j; j++) {
			for (int i = 0; len - 1 - j > i; i++) {
				if (arr[i] > arr[i + 1]) {
					arr[i] = arr[i] + arr[i + 1];
					arr[i + 1] = arr[i] - arr[i + 1];
					arr[i] = arr[i] - arr[i + 1];
				}
			}
		}
	}
}
