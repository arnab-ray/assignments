public class RotateLL {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node rotate(Node head, int k) {
        if(head == null || head.next == null)
            return head;

        Node temp = head;
        for(int i = 0; i < k - 1; i++)
            temp = temp.next;

        //store current head
        Node curr = head;

        // move head to the (k + 1) element
        head = temp.next;
        temp.next = null;

        temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = curr;

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
        Node head = new Node(2);
        head.next = new Node(6);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);

        head = rotate(head, 2);
        printList(head);
    }
}
