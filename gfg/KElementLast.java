class Node {
  Node next;
  int data;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class KElementLast {
  public static void main(String[] args) {
    KElementLast obj = new KElementLast();
    Node root = new Node(1);
    obj.addNodes(root, 2,3,4,5,6,7,8,9);
    System.out.println(obj.getKthFromLast(root, 2));
  }

  int getKthFromLast(Node head, int k) {
    Node fast = head;
    Node slow = head;
    for (int i=0;i<k;i++) {
      if (fast==null) return -1;
      fast = fast.next;
    }
    while (fast!=null) {
      fast=fast.next;
      slow= slow.next;
    }
    return slow.data;
  }

  private void addNodes(Node root, int... nums) {
    Node temp = root;
    for (int i=0;i<nums.length;i++) {
      Node newNode = new Node(nums[i]);
      temp.next = newNode;
      temp = temp.next;
    }
  }
}
