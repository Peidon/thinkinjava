package main;

import common.TreeNode;

class Solution {
	static public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left != null)
			if (!isValidBST(root.left) || getMax(root.left) >= root.val)
				return false;
		if (root.right != null)
			if (!isValidBST(root.right) || getMin(root.right) <= root.val)
				return false;
		return true;
	}

	static private int getMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.val;
	}

	static private int getMax(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.val;
	}
}
