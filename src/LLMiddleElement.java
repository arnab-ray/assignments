public class LLMiddleElement {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node getMiddleElement(Node start) {
        if(start == null)
            return null;

        Node slowPtr, fastPtr;
        slowPtr = fastPtr = start;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next = new Node(4);
        start.next.next.next = new Node(5);
        start.next.next.next.next = new Node(6);

        Node node = getMiddleElement(start);
        System.out.println("Middle element is: " + node.val);
    }
}
