package algorithm.sort;

public class HeapSort extends SortStrategy {
	public void sort(int arr[]) {
		for(int l = arr.length; l > 0; l--){
			heap(arr,l);
			swap(arr,0,l - 1);
		}
	}

	private int[] heap(int[] a,int l) {// construct a heap
		for (int i = l / 2 - 1; i >= 0; i--) {
			percolateDown(a, i, l);
		}
		return a;
	}

	private void percolateDown(int[] a, int i, int l) {
		while (i * 2 + 1 < l) {
			int j = i * 2 + 1;
			int max = a[j];
			if (j + 1 < l && max < a[j + 1]){
				j = i * 2 + 2;
				max = a[j];
			}
			if(max <= a[i]) break;
			swap(a,i,j);
			i = j;
		}
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
