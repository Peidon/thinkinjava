package tree;

import java.util.*;

public class BinaryTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {return new ArrayList<>();};
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();

        int levelNo = 0;

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int i = queue.size();

            var qv =  ((levelNo & 1) == 1) ? queue.reversed(): queue;
            for (TreeNode node: qv) {
                level.add(node.val);
            }
            while (i > 0) {
                TreeNode node = queue.poll();
                assert node != null;


                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                i--;
            }
            list.add(level);
            levelNo++;
        }

        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {return new ArrayList<>();};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int i = queue.size();
            while (i > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                i--;
            }
            list.add(level);
        }

        return list;
    }
}
