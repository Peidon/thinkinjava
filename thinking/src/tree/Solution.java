package tree;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        var bst = new BST(root);

        int min = Integer.MAX_VALUE;
        int pre = (int) -10e5;

        while (bst.HasNext()) {
            TreeNode x = bst.Next();
            int diff = x.val - pre;
            pre = x.val;
            min = Math.min(diff, min);
        }

        return min;
    }

    public int kthSmallest(TreeNode root, int k) {
        var bst = new BST(root);
        while (k > 1) {
            bst.Next();
            k--;
        }
        var n = bst.Next();
        return n.val;
    }

    public boolean isValidBST(TreeNode root) {
        var bst = new BST(root);
        int pre = bst.Next().val;
        while (bst.HasNext()) {
            int current = bst.Next().val;
            if (current <= pre) {
                return false;
            }

            pre = current;
        }
        return true;
    }
}
