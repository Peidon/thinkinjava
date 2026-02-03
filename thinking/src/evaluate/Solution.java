package evaluate;

import java.util.*;

class Solution {

    public Map<String, List<Equation>> build(List<List<String>> equations, double[] values) {

        Map<String, List<Equation>> matrix = new HashMap<>();

        for (int i=0; i<values.length; i++) {
            var equation = equations.get(i);
            String x = equation.getFirst();
            String y = equation.getLast();

            var xy = new Equation(x, y, values[i]);
            var yx = new Equation(y, x, 1/values[i]);

            Object _ = matrix.containsKey(x) ? matrix.get(x).add(xy) : matrix.put(x, new ArrayList<>(List.of(xy)));
            Object _ = matrix.containsKey(y) ? matrix.get(y).add(yx) : matrix.put(y, new ArrayList<>(List.of(yx)));
        }

        return matrix;
    }

    public Double calculate(Map<String, List<Equation>> matrix, List<String> query, Set<String> visited) {
        String first = query.getFirst();
        String last = query.getLast();
        
        if ( !matrix.containsKey(first) || visited.contains(first) ){
            return -1.0;
        }

        var list = matrix.get(first);

        for (Equation e: list) {
            visited.add(e.name);
            double v = this.calculate(matrix, new ArrayList<>(List.of(e.divideBy, last)), visited);
            if (v > 0) {
                return e.value * v;
            }
            visited.remove(e.name);
        }

        return (first.equals(last)) ? 1.0 : -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Equation>> matrix = build(equations, values);
        double[] answers = new double[queries.size()];

        for (int i=0; i<queries.size(); i++) {
            var query = queries.get(i);
            Set<String> visited = new HashSet<>();
            var answer = calculate(matrix, query, visited);
            answers[i] = answer;
        }
        return answers;
    }
}
