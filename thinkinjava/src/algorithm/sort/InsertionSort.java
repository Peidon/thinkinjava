package algorithm.sort;

public class InsertionSort extends SortStrategy{

	@Override
	public void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++){
			int j = i;// find the position of Insertion at range[0, j]
			int cur = arr[i]; // range[i, arr.length) haven't yet been sort
			for(;j > 0 && arr[j - 1] > cur; j --){
				arr[j] = arr[j - 1];
			}
			arr[j] = cur;
		}
	}

}
