import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinOps {

    private static class Node {
        int val;
        int steps;

        Node(int val, int steps) {
            this.val = val;
            this.steps = steps;
        }
    }

    private static void printQueue(Queue<Node> nodes) {
        for(Node node : nodes)
            System.out.print(node.val + " ");
        System.out.println();
    }

    private static int getSteps(Node root, int target) {
        Queue<Node> nodeQueue = new LinkedList<>();
        Set<Integer> nodeSet = new HashSet<>();

        nodeQueue.add(root);
        nodeSet.add(root.val);

        while (!nodeQueue.isEmpty()) {

            printQueue(nodeQueue);

            Node node = nodeQueue.poll();
            if(node.val == target)
                return node.steps;

            int mulVal = node.val * 2;
            int subVal = node.val - 1;

            if(mulVal > 0 && mulVal < 1000 && !nodeSet.contains(mulVal)) {
                nodeQueue.add(new Node(node.val * 2, node.steps + 1));
                nodeSet.add(mulVal);
            }
            if(subVal > 0 && subVal < 1000 && !nodeSet.contains(subVal)) {
                nodeQueue.add(new Node(node.val - 1, node.steps + 1));
                nodeSet.add(subVal);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 7;

        System.out.println(getSteps(new Node(4, 0), 7));
    }
}
