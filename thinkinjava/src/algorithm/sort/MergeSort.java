package algorithm.sort;


public class MergeSort extends SortStrategy {

	@Override
	public void sort(int[] arr) {
		int l = arr.length;
		int[] b = new int[l];
		mergeSort(arr, 0, l - 1, b);
	}
	/* [start, end] */
	private void mergeSort(int[] origin, int start, int end, int[] target) {
		if (start < end) {
			int m = start + (end - start) / 2;
			mergeSort(origin, start, m, target);
			mergeSort(origin, m + 1, end, target);
			merge(origin, start, m, end, target);
		}
	}

	/* O(e - m) --> O(n) */
	private void merge(int[] origin, int start, int m, int end, int[] target) {
		int p1 = start, p2 = m + 1, pb = 0;
		while( p1 <= m && p2 <= end){
			if(origin[p1] < origin[p2]){
				target[pb++] = origin[p1++];
			}else{
				target[pb++] = origin[p2++];
			}
		}
		while( p1 <= m ){
			target[pb++] = origin[p1++];
		}
		while( p2 <= end ){
			target[pb++] = origin[p2++];
		}
		System.arraycopy(target, 0, origin, start, end - start + 1);
	}
}
