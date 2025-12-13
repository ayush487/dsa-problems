import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.right.left = new Node(4);
    root.right.left.right = new Node(5);
    LeftViewBinaryTree lbt = new LeftViewBinaryTree();
    ArrayList<Integer> l = lbt.leftView(root);
    l.forEach(i -> System.out.println(i));
  }

  public ArrayList<Integer> leftView(Node root) {
    Queue<NodeEntry> queue = new LinkedList<>();
    ArrayList<Integer> list = new ArrayList<>();
    if (root==null) return list;
    queue.add(new NodeEntry(root, 0));
    while (!queue.isEmpty()) {
      NodeEntry entry = queue.poll();
      if (entry.node.left!=null) queue.offer(new NodeEntry(entry.node.left, entry.level+1));
      if (entry.node.right!=null) queue.offer(new NodeEntry(entry.node.right, entry.level+1));
      if (list.size()==entry.level) list.add(entry.node.data);
    }
    return list;
  }
}

class Node {
    int data;
    Node left, right;
    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class NodeEntry {
    public Node node;
    public int level;
    public NodeEntry(Node node, int level) {
        this.node = node; this.level = level;
    }
}
