package tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageTest {

    @Test
    @DisplayName("Average of levels")
    void averageOfLevels() {
        var root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Object[] expects = new Object[]{3.0, 14.5, 11.0};
        var a = new Average();
        var x = a.averageOfLevels(root);
        assertArrayEquals(expects, x.toArray());
    }
}