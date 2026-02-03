package algorithm;

class Jumper {
	
	public static void main(String[] args) {
		System.out.println(jump(new int[] {1,2,3,4}));
	}
	/**
	 * 给定数组求最少几步跳到终点
	 * @param nums 代表一组落脚点，每个数组元素的值代表从这个落脚点起跳的最远距离
	 * @return 到达终点的最少步数
	 */
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
	// 给定数组求能否跳到终点
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
