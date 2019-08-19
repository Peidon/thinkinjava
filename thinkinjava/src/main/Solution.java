package main;

class Solution {
	public static void main(String[] args) {
		System.out.println(jump(new int[] {1,2,3,4}));
	}
	
	static public int jump(int[] nums) {
		int fur = 0,end = nums.length - 1, jump = 0, step = 1,span = nums[0];
		if(end == 0)
			return 0;
		if(span >= end)
			return 1;
		for (int i = 1; i < end; i++) {
			jump = nums[i] + i;
			if(jump > fur){
				fur = jump;
			}
			if(fur >= end)
				return step + 1;
			if(i == span){
				step = step + 1;
				span = fur;
			}
		}
		return step;
	}

	static public boolean canJump(int[] nums) {
		int fur = 0; // 此前的最远距离
		int end = nums.length - 1;
		int jump = 0;// 从第 j 点起跳，更新最远距离
		for (int j = 0; j <= fur && j <= end; j++) {// j <= fur
			jump = nums[j] + j;
			if (jump >= end) {
				return true;
			}
			if (jump > fur) {
				fur = jump;
			}
		}
		return false;
	}
}
