import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by arnab.ray on 07/10/17.
 */
public class BfsApplication {

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static void printRightView(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                Node temp = queue.poll();

                if(i == n-1)
                    System.out.print(temp.data + " ");
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    private static void printLeftView(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                Node temp = queue.poll();
                if(i == 0)
                    System.out.print(temp.data + " ");
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);

        System.out.print("Left view : ");
        printLeftView(root);
        System.out.println();
        System.out.print("Right view : ");
        printRightView(root);
    }
}
