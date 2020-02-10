public class ReverseLL {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node revList(Node head) {
        if(head == null || head.next == null)
            return head;

        Node rest = revList(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    private static Node revListIter(Node head) {
        if(head == null || head.next == null)
            return head;

        Node prev = null, next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    private static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);

        head = revList(head);
        printList(head);

        head = revListIter(head);
        printList(head);
    }
}
