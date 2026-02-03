package tree;

import java.util.Stack;

public class BST {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode point;

    BST(TreeNode root) {
        point = root;
    }

    public TreeNode Next() {
        while (point != null) {
            stack.push(point);
            point = point.left;
        }

        var x = stack.pop();
        point = x.right;

        return x;
    }

    public boolean HasNext() {
        return !stack.isEmpty() || point != null;
    }
}
