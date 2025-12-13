import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSUndirectedGraph {
  public static void main(String[] args) {
    
    BFSUndirectedGraph bfs = new BFSUndirectedGraph();

    // [[2, 3, 1], [0], [0, 4], [0], [2]]
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    ArrayList<Integer> row0 = new ArrayList<>();
    ArrayList<Integer> row1 = new ArrayList<>();
    ArrayList<Integer> row2 = new ArrayList<>();
    ArrayList<Integer> row3 = new ArrayList<>();
    ArrayList<Integer> row4 = new ArrayList<>();
    row0.add(2);
    row0.add(3);
    row0.add(1);
    row1.add(0);
    row2.add(0);
    row2.add(4);
    row3.add(0);
    row4.add(2);
    adj.add(row0);
    adj.add(row1);
    adj.add(row2);
    adj.add(row3);
    adj.add(row4);
    var list = bfs.bfs(adj);
    list.forEach(i -> System.out.print(i + " "));

    System.out.println();

    ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
    ArrayList<Integer> row0_ = new ArrayList<>();
    ArrayList<Integer> row1_ = new ArrayList<>();
    ArrayList<Integer> row2_ = new ArrayList<>();
    ArrayList<Integer> row3_ = new ArrayList<>();
    ArrayList<Integer> row4_ = new ArrayList<>();
    // [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
    row0_.add(1);
    row0_.add(2);
    row1_.add(0);
    row1_.add(2);
    row2_.add(0);
    row2_.add(1);
    row2_.add(3);
    row2_.add(4);
    row3_.add(2);
    row4_.add(2);
    adj2.add(row0_);
    adj2.add(row1_);
    adj2.add(row2_);
    adj2.add(row3_);
    adj2.add(row4_);
    var list2 = bfs.bfs(adj2);
    list2.forEach(i -> System.out.print(i + " "));
  }

  public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
    // code here
    if (adj.size() == 0)
      return new ArrayList<Integer>();
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> bfsTraversal = new ArrayList<>();
    queue.add(0);
    visited.add(0);
    bfsTraversal.add(0);

    while (!queue.isEmpty()) {
      int e = queue.poll();
      List<Integer> edges = adj.get(e);
      for (int edge : edges) {
        if (!visited.contains(edge)) {
          visited.add(edge);
          bfsTraversal.add(edge);
          queue.add(edge);
        }
      }
    }
    return bfsTraversal;
  }
}
