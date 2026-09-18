import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndirectedGraphCycle {
  public static void main(String[] args) {
    UndirectedGraphCycle ugc = new UndirectedGraphCycle();
    int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
    System.out.println(ugc.isCycle(4, edges));

    int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
    System.out.println(ugc.isCycle(4, edges2));
  }

  public boolean isCycle(int V, int[][] edges) {
    // Code here
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();
    List<List<Integer>> edgeList = new ArrayList<>(V);
    for (int i = 0; i < V; i++)
      edgeList.add(new ArrayList<Integer>());
    for (int i = 0; i < edges.length; i++) {
      int[] e = edges[i];
      edgeList.get(e[0]).add(e[1]);
      edgeList.get(e[1]).add(e[0]);
    }
    for (int i = 0; i < V; i++) {
      if (visited.contains(i))
        continue;
      if (isCycle(i, -1, visited, visiting, edgeList))
        return true;
    }
    return false;
  }

  private boolean isCycle(int n, int parent, Set<Integer> visited, Set<Integer> visiting,
      List<List<Integer>> edgeList) {
    if (visited.contains(n))
      return false;
    visiting.add(n);
    for (int neighbour : edgeList.get(n)) {
      if (neighbour == parent)
        continue;
      if (visiting.contains(neighbour))
        return true;
      if (!visited.contains(neighbour) && isCycle(neighbour, n, visited, visiting, edgeList))
        return true;
    }
    visited.add(n);
    visiting.remove(n);
    return false;
  }
}
