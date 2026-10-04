//Course Schedule IV

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem150 {
    private Map<Integer, List<Integer>> edges;
    private boolean[][] canReach;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        edges = new HashMap<>();
        canReach = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            edges.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(canReach(query[1], query[0]));
        }
        return ans;
    }

    private boolean canReach(int current, int target) {
        if (edges.get(current)==null) return false;
        for (int edge : edges.get(current)) {
            if (edge==target) {
                canReach[edge][target] = true;
                return true;
            }
            if (canReach[edge][target]) return true;
            if (canReach(edge, target)) {
                canReach[edge][target] = true;
                return true;
            }
        }
        return false;
    }
}
