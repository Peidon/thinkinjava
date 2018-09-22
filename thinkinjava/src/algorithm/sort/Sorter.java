package algorithm.sort;

public class Sorter {
	public void sort(int arr[]) {
		sortStrategy.sort(arr);
	}

	public void setSortStrategy(SortStrategy sort) {
		this.sortStrategy = sort;
	}

	/**
	 * @link aggregation
	 * @directed
	 */
	private SortStrategy sortStrategy;

	public static void main(String[] args) {
		int[] arr = new int[] { 38, 5, 47, 26, 27, 44, 46, 55, 34, 2, 11 };
		Sorter sorter = new Sorter();
		sorter.setSortStrategy(new HeapSort());
		sorter.sort(arr);
		for (int i = 0; arr.length > i; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
