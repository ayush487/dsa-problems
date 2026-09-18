public class ReverseLinkedList {
  public static void main(String[] args) {
    Node root = new Node(1);
    ReverseLinkedList r = new ReverseLinkedList();
    r.addNodes(root, 2, 3, 4, 5, 6, 7, 8, 9);
    root = r.reverseList(root);
    while (root!=null) {
      System.out.println(root.data);
      root = root.next;
    }
  }

  Node reverseList(Node head) {
    Node prev = null;
    Node current = head;
    Node next = current.next;
    while (current.next != null) {
      current.next = prev;
      prev = current;
      current = next;
      next = current.next;
    }
    current.next = prev;
    head = current;
    return head;
  }

  private void addNodes(Node root, int... nums) {
    Node temp = root;
    for (int i = 0; i < nums.length; i++) {
      Node newNode = new Node(nums[i]);
      temp.next = newNode;
      temp = temp.next;
    }
  }
}

class Node {
  Node next;
  int data;

  Node(int d) {
    data = d;
    next = null;
  }
}