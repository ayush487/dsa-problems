//Evaluate Division

import java.util.*;

public class Problem155 {
    private class Edge {
        double weight;
        String node;

        public Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    private Map<String, List<Edge>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            graph.computeIfAbsent(equations.get(i).get(0), k -> new ArrayList<>())
                    .add(new Edge(equations.get(i).get(1), values[i]));
            graph.computeIfAbsent(equations.get(i).get(1), k -> new ArrayList<>())
                    .add(new Edge(equations.get(i).get(0), 1 / values[i]));
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Optional<Double> ans = dfs(query.get(0), query.get(1), new HashSet<>());
            result[i] = ans.isEmpty() ? -1.0 : ans.get();
        }
        return result;
    }

    private Optional<Double> dfs(String from, String to, Set<String> visited) {
        if (visited.contains(from)) return Optional.empty();
        visited.add(from);
        if (graph.containsKey(from)) {
            for (Edge edge : graph.get(from)) {
                if (edge.node.equals(to)) return Optional.of(edge.weight);
            }
            for (Edge edge : graph.get(from)) {
                Optional<Double> opt = dfs(edge.node, to, visited);
                if (opt.isPresent()) return Optional.of(opt.get() * edge.weight);
            }
        }
        return Optional.empty();
    }
}
