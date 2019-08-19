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
	static public int jump(int[] nums) {
		int fur = 0,end = nums.length - 1, jump = 0, step = 1,span = nums[0];
		//span ����һ��λ�ã�������֮������ټ�һ�����ܵ���Զ��λ��
		//end ����ǰλ�����յ�ľ���
		if(end == 0)
			return 0;
		if(span >= end)
			return 1;
		for (int i = 1; i < end; i++) { 
			jump = nums[i] + i; //������Step + 1���ܴﵽ��λ��
			if(jump > fur){
				fur = jump;
			}
			if(fur >= end)
				return step + 1;
			if(i == span){//ʵ�ʱ����� i ֮ǰ����Զ����(span)ʱ��step + 1
				step = step + 1;
				span = fur;
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
