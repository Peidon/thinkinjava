package evaluate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestEvaluate {

    Solution so = new Solution();

    public void Test0() {
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
        assert Arrays.equals(answers, new double[]{6, 0.5, -1, 1, -1});
        IO.println(Arrays.toString(answers));
    }
}
