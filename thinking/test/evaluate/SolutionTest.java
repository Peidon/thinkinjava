package evaluate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    Solution so = new Solution();

    @Test
    void calcEquation() {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a","b")));
        equations.add(new ArrayList<>(Arrays.asList("b","c")));

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "e")));
        queries.add(new ArrayList<>(Arrays.asList("a", "a")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));
        var answers = so.calcEquation(equations, new double[]{2, 3}, queries);
        assertArrayEquals(new double[]{6, 0.5, -1, 1, -1}, answers);
    }
}