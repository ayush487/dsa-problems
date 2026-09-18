public class PalindromeLinkedList {
  public static void main(String[] args) {
    Node root = new Node(1);
    PalindromeLinkedList pl = new PalindromeLinkedList();
    pl.addNodes(root, 2,2);
    System.out.println(pl.isPalindrome(root));
  }

  public boolean isPalindrome(Node head) {
    Node slow = head;
    Node fast = head;
    boolean isEven = false;
    while(true) {
      if (fast.next==null) {
        isEven = false;
        break;
      }
      if (fast.next.next == null) {
        isEven = true;
        break;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    if (isEven) {
      slow = slow.next;
    }
    Node nextHalfNode = reverseLL(slow);
    while (true) {
      if (nextHalfNode==null) break;
      if (head.data!=nextHalfNode.data) return false;
      head = head.next;
      nextHalfNode = nextHalfNode.next;
    }
    return true;
  }

  private Node reverseLL(Node head) {
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
    for (int i=0;i<nums.length;i++) {
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