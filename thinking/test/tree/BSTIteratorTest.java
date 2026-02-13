package tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {

    @Test
    void Test0() {
        String[] instructions = {"next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"};
        Object[] expects = {3,7,true,9, true, 15, true, 20, false};
        int i = 0;
        var root = BST.BuildTree(new Integer[]{7,3,15,null,null,9,20});
        var it = new BSTIterator(root);
        for (String ins: instructions) {
            switch (ins) {
                case "next": {
                    var v = it.next();
                    assertEquals(v, expects[i]);
                    break;
                }
                case "hasNext": {
                    var b = it.hasNext();
                    assertEquals(b, expects[i]);
                }
            }
            i++;
        }
    }

}