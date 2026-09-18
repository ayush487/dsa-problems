// Reorder List

public class Problem074 {
    public void reorderList(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        ListNode[] arr = new ListNode[length];

        curr = head;
        int i = 0;
        while (curr != null) {
            arr[i++] = curr;
            curr = curr.next;
        }
        for (ListNode node : arr) node.next = null;
        for (var node : arr) System.out.println(node);
        int l = 1, r = length - 1;
        curr = arr[0];
        boolean temp = true;
        while (l <= r) {
            if (temp) curr.next = arr[r--];
            else curr.next = arr[l++];
            temp = !temp;
            curr = curr.next;
        }
        for (var node : arr) System.out.println(node);
    }
}
