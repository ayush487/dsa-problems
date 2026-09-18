//Remove Nth Node From End of List

public class Problem075 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp!=null) {
            temp = temp.next;
            size++;
        }
        if (size==n) {
            head = head.next;
            return head;
        }
        int deletionIdx = size - n;
        int i = 0;
        temp = head;
        ListNode prev = null;
        while (i!=deletionIdx) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        return head;
    }
}
