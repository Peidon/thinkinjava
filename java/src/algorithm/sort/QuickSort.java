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
		int pivot = a[l];
		while (l < r) {
			while (l < r && pivot <= a[r])
				r--;
			a[l] = a[r];
			while (l < r && a[l] <= pivot)
				l++;
			a[r] = a[l];
		}
		a[l] = pivot;
		return l;
	}
}
