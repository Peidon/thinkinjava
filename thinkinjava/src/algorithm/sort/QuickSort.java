package algorithm.sort;



public class QuickSort extends SortStrategy {
	
	public void sort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] a, int l, int r) {
		if (l >= r)
			return;
		int mi = createPivot(a, l, r);
		quickSort(a, 0, mi - 1);
		quickSort(a, mi + 1, r);
	}
	private int createPivot(int[] a, int l, int r) {
		while (l < r) {
			while (l < r && a[l] <= a[r])
				r--;
			swap(a, l, r);
			while (l < r && a[l] <= a[r])
				l++;
			swap(a, l, r);
		}
		return l;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
