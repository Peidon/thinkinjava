package main;

class Solution {
	public static void main(String[] args) {
		System.out.println(jump(new int[] {0}));
	}
	
	static private int jump(int[] nums) {
		int step = 0, location = 0;
		final int end = nums.length - 1;
		if(end > 0) step = 1;
		int furthest = location + nums[0]; // temp value in every span
		while(furthest < end){
			step ++;
			for(int i = location + 1, len = furthest; i <= len; i++){
				if(nums[i] + i > furthest){
					furthest = nums[i] + i;
					location = i;
				}
			}
		}
		return step;
	}
}
