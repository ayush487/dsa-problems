
class Node {
  int data;
  Node left;
  Node right;

  Node(int val) {
    data = val;
    left = right = null;
  }
}

public class CheckForBST {

  public static void main(String[] args) {
    // [2, 1, 3, N, N, N, 5

    CheckForBST cfbst = new CheckForBST();
    Node root = new Node(2);
    root.right = new Node(7);
    root.right.right = new Node(6);
    root.right.right.right = new Node(9);
    System.out.println(cfbst.isBST(root));

  }

  public boolean isBST(Node root) {
    
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBST(Node root, int min, int max) {
    if (root == null)
      return true;
    if (root.data >= max || root.data <= min)
      return false;
    boolean isLeftBST = isBST(root.left, min, root.data);
    boolean isRightBST = isBST(root.right, root.data, max);
    return isLeftBST && isRightBST;
  }
}
