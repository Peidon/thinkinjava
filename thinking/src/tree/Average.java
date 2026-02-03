package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average {

    public List<Double> averageOfLevels(TreeNode root) {

        ArrayList<Double> aves = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        aves.add((double) root.val);

        while (!queue.isEmpty()) {

            Queue<TreeNode> q = new LinkedList<>();
            while (!queue.isEmpty()) {
                var node = queue.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            if (q.isEmpty()) {
                continue;
            }
            Double x = q.stream().reduce(0.0, (a, b) -> a + (double) (b.val), Double::sum);
            aves.add(x / q.size());
            queue = q;
        }


        return aves;
    }
}
