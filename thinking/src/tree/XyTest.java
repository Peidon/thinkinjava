package tree;

import java.util.ArrayList;

public class XyTest {

    protected void assertEqual(int a, int b) {
        if (a == b) {
            IO.println("√");
        } else {
            IO.println("x");
        }
    }

    protected void objEqual(Object a, Object b) {
        if (a.equals(b)) {
            IO.println("√");
        } else {
            IO.println("x");
        }
    }

    protected void arrayEqual(Object[] a, Object[] b) {
        if (a.length != b.length) {
            return;
        }
        for (int i=0; i<a.length; i++) {
            if (!a[i].equals(b[i])) {
                return;
            }
        }
    }

    protected TreeNode buildTree(Integer[] input) {
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
