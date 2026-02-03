package tree;

import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {

    private final LinkedList<TreeNode> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        var point = root;
        Stack<TreeNode> stack = new Stack<>();

        while (point != null) {

            if (point.left == null) {

                list.addLast(point);

                while (point.right == null && !stack.empty()) {
                    point = stack.pop();
                    list.addLast(point);
                }

                point = point.right;

            } else {
                stack.push(point);
                point = point.left;
            }
        }

    }

    public int next() {
        return list.pop().val;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
