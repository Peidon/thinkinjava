package recursion;


public class Tree {
	private int j = 0;// point of pre
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstruct(pre,in,0,pre.length);
		return root;
	}
	private TreeNode reConstruct(int[] pre, int[] in, int l, int r) {
		TreeNode root = null;
		if(l >= r ) return null;
		if(j < in.length){
			int index = rangeSearch(in,l,r,pre[j]);
			if(index == -1) return null;
			root = new TreeNode(pre[j++]);
			root.left = reConstruct(pre,in,l,index);
			root.right = reConstruct(pre,in,index,r);
		}
		return root;
	}
	private int rangeSearch(int[] in, int l, int r, int key){
		for(int i = l; i < r; i++){
			if(key == in[i]) 
				return i;
		}
		return -1;
	}
	
	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) { val = x; }
	}
}
