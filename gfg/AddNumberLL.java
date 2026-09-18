class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class AddNumberLL {
    public static void main(String[] args) {

    }

    public Node addTwoLists(Node head1, Node head2) {
        Node revHead1 = reverse(head1);
        Node revHead2 = reverse(head2);
        Node result = null;
        Node resultHead = null;
        int extraCarry = 0;
        Node curr1 = revHead1;
        Node curr2 = revHead2;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.data + curr2.data + extraCarry;
            int ones = sum % 10;
            int tens = sum / 10;
            extraCarry = tens;
            if (result == null) {
                result = new Node(ones);
                resultHead = result;
            } else {
                Node newNode = new Node(ones);
                result.next = newNode;
                result = newNode;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null) {
            int sum = curr1.data + extraCarry;
            int ones = sum % 10;
            int tens = sum / 10;
            extraCarry = tens;
            if (result == null) {
                result = new Node(ones);
                resultHead = result;
            } else {
                Node newNode = new Node(ones);
                result.next = newNode;
                result = newNode;
            }
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            int sum = curr2.data + extraCarry;
            int ones = sum % 10;
            int tens = sum / 10;
            extraCarry = tens;
            if (result == null) {
                result = new Node(ones);
                resultHead = result;
            } else {
                Node newNode = new Node(ones);
                result.next = newNode;
                result = newNode;
            }
            curr2 = curr2.next;
        }
        if (extraCarry > 0) {
            Node newNode = new Node(extraCarry);
            result.next = newNode;
            result = newNode;
        }
        return trimZeros(reverse(resultHead));
    }

    Node trimZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
