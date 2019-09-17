package algorithm;

class Jumper {
	
	public static void main(String[] args) {
		System.out.println(jump(new int[] {1,2,3,4}));
	}
	/**
	 * �������������ټ��������յ�
	 * @param nums ����һ����ŵ㣬ÿ������Ԫ�ص�ֵ����������ŵ���������Զ����
	 * @return �����յ�����ٲ���
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
	// �����������ܷ������յ�
	static public boolean canJump(int[] nums) {
		int fur = 0; // ��ǰ����Զ����
		int end = nums.length - 1;
		int jump = 0;// �ӵ� j ��������������Զ����
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
