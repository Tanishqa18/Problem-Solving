class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, val));
            graph.get(v).add(new Pair(u, 1.0 / val));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(start, end, graph, new HashSet<>(), 1.0);
            }
        }

        return result;
    }

    private double dfs(String curr, String target, Map<String, List<Pair>> graph,
                       Set<String> visited, double product) {
        
        if (curr.equals(target)) return product;

        visited.add(curr);

        for (Pair nei : graph.get(curr)) {
            if (!visited.contains(nei.node)) {
                double res = dfs(nei.node, target, graph, visited, product * nei.value);
                if (res != -1.0) return res;
            }
        }

        return -1.0;
    }
}

class Pair {
    String node;
    double value;

    Pair(String node, double value) {
        this.node = node;
        this.value = value;
    }
}
