//Redundant Connection

import java.util.*;

public class Problem151 {
    private Map<Integer, List<Integer>> edgeMap;
    private Map<Integer, Set<Integer>> memo;

    public int[] findRedundantConnection(int[][] edges) {
        this.edgeMap = new HashMap<>();
        this.memo = new HashMap<>();
        for (int[] edge : edges) {
            if (canGo(edge[0], edge[1], -1)) return edge;
            edgeMap.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }
        return new int[]{1, 2};
    }

    private boolean canGo(int from, int to, int fromParent) {
        if (!edgeMap.containsKey(from)) return false;
        if (memo.containsKey(from) && memo.get(from).contains(to)) return true;
        for (int edge : edgeMap.get(from)) {
            if (edge == to) return true;
            if (edge == fromParent) continue;
            if (memo.containsKey(edge) && memo.get(edge).contains(to)) return true;
            if (canGo(edge, to, from)) {
                memo.computeIfAbsent(edge, e -> new HashSet<>()).add(to);
                memo.computeIfAbsent(to, e -> new HashSet<>()).add(edge);
                return true;
            }
        }
        return false;
    }
}
