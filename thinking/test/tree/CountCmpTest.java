package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountCmpTest {

    @Test
    void countNodes() {
        Integer[] input = {1,2,3,4,5,6};
        var root = BST.BuildTree(input);

        var cmp = new CountCmp();
        int count = cmp.countNodes(root);
        assertEquals(count, input.length);
    }
}