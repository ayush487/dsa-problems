//Reverse Nodes in K-Group

public class Problem083 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevHead = null;
        ListNode nodeAtLast = checkForKNodes(head, k);
        boolean isFirst = true;
        while (nodeAtLast != null) {
            ListNode nodeAfterK = nodeAtLast.next;
            ListNode temp = curr;
            if (isFirst) {
                prevHead = head;
                head = reverse(curr, k);
            } else {
                prevHead.next = reverse(curr, k);
                prevHead = curr;
            }
            temp.next = nodeAfterK;
            curr = nodeAfterK;
            nodeAtLast = checkForKNodes(curr, k);
            isFirst = false;
        }
        return head;

    }

    private ListNode reverse(ListNode curr, int k) {
        if (curr == null) return null;
        int i = 0;
        ListNode prev = null;
        while (i < k) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }
        return prev;
    }

    private ListNode checkForKNodes(ListNode node, int k) {
        int i = 0;
        ListNode prev = null;
        while (node != null && i < k) {
            prev = node;
            node = node.next;
            i++;
        }
        if (i == k) return prev;
        else return null;
    }
}
