package tree;

public class CountCmp {
    public int countNodes(TreeNode root) {
        int count = 0;
        var point = root;
        int hi = height(root);

        while (point != null) {
            if (height(point.right) == hi - 1) {
                count += 1 << hi;
                point = point.right;
            } else {
                count += 1 << (hi - 1);
                point = point.left;
            }
            hi--;
        }

        return count;
    }

    private int height(TreeNode node) {
        return node == null ? -1 : 1+ height(node.left);
    }
}


