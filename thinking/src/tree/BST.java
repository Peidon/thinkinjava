package tree;

import java.util.ArrayList;
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


    static public TreeNode BuildTree(Integer[] input) {
        var vec = new ArrayList<TreeNode>();
        var root = new TreeNode(input[0]);
        vec.add(root);
        for (int i=1; i < input.length; i++) {
            if (input[i] == null) {
                continue;
            }
            var n = new TreeNode(input[i]);
            vec.add(n);
            int k = (i-1) / 2;
            if ((i & 1) == 1) {
                vec.get(k).left = n;
            } else {
                vec.get(k).right = n;
            }
        }
        return root;
    }
}
