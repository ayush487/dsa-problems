import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DirectedGraphCycle {
  public static void main(String[] args) {
    DirectedGraphCycle dgc = new DirectedGraphCycle();
    int[][] edges =  {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
    boolean isCycle = dgc.isCyclic(4,edges);
    System.out.println(isCycle);
  }

  public boolean isCyclic(int V, int[][] edges) {
    // code here
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();
    ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>(V);

    for (int i = 0; i < V; i++) {
      edgeList.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      edgeList.get(edge[0]).add(edge[1]);
    }

    for (int i=0;i<V;i++) {
      if (detectCycle(edgeList, i, visited, visiting)) return true;
    }
    
    return false;
  }

  private boolean detectCycle(ArrayList<ArrayList<Integer>> edges, int current, Set<Integer> visiting, Set<Integer> visited) {
    if (visited.contains(current)) return false;
    if (visiting.contains(current)) return true;
    visiting.add(current);
    for (int e : edges.get(current)) {
      if (detectCycle(edges, e, visiting, visited)) return true;
    }
    visited.add(current);
    visiting.remove(current);
    return false;
  }  
}
