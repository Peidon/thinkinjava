package tree;

public class ZiTest extends XyTest {

    // tree.Average Test
    public void Test0() {
        var root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Object[] expects = new Object[]{3.0, 14.5, 11.0};
        var a = new Average();
        var x = a.averageOfLevels(root);
        arrayEqual(expects, x.toArray());
    }

    // tree.BSTIterator Test
    public void Test1() {
        String[] instructions = {"next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"};
        Object[] expects = {3,7,true,9, true, 15, true, 20, false};
        int i = 0;
        var root = buildTree(new Integer[]{7,3,15,null,null,9,20});
        var it = new BSTIterator(root);
        for (String ins: instructions) {
            switch (ins) {
                case "next": {
                    var v = it.next();
                    objEqual(v, expects[i]);
                    break;
                }
                case "hasNext": {
                    var b = it.hasNext();
                    objEqual(b, expects[i]);
                }
            }
            i++;
        }
    }

    // Count Complete Tree
    public void Test2() {
        Integer[] input = {1,2,3,4,5,6};
        var root = buildTree(input);

        var cmp = new CountCmp();
        int count = cmp.countNodes(root);
        assertEqual(count, input.length);
    }

    // Minimum Difference Test
    public void Test3() {
        var root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        var md = new Solution().getMinimumDifference(root);
        assertEqual(md, 1);
    }
}
