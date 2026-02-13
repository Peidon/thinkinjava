package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getMinimumDifference() {
        var root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        var md = new Solution().getMinimumDifference(root);
        assertEquals(1, md);
    }

    @Test
    void kthSmallest() {
    }

    @Test
    void isValidBST() {
    }
}