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
	static public int jump(int[] nums) {
		int fur = 0,end = nums.length - 1, jump = 0, step = 1,span = nums[0];
		//span 代表一个位置，到达这之后必须再加一步才能到更远的位置
		//end 代表当前位置与终点的距离
		if(end == 0)
			return 0;
		if(span >= end)
			return 1;
		for (int i = 1; i < end; i++) { 
			jump = nums[i] + i; //遍历第Step + 1步能达到的位置
			if(jump > fur){
				fur = jump;
			}
			if(fur >= end)
				return step + 1;
			if(i == span){//实际遍历到 i 之前的最远距离(span)时，step + 1
				step = step + 1;
				span = fur;
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
