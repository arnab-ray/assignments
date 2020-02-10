import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

enum Colour {
    WHITE, GREY, BLACK;
}

class Node {
    int value;
    int startTime;
    int endTime;
    int inDegree;
    Colour colour;
    List<Node> adjNodes;

    public Node(int value) {
        this.value = value;
        this.startTime = 0;
        this.endTime = Integer.MAX_VALUE;
        this.inDegree = 0;
        this.colour = Colour.WHITE;
        this.adjNodes = new LinkedList<>();
    }
}


public class DirectedGraph {

    private int N;
    private Map<Integer, Node> nodeMap;

    public DirectedGraph(int N) {
        this.N = N;
        this.nodeMap = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        Node node1 = nodeMap.get(u);
        Node node2 = nodeMap.get(v);

        if(node1 == null) {
            node1 = new Node(u);
            if(node2 == null) {
                node2 = new Node(v);
                nodeMap.put(v, node2);
            }

            node2.inDegree = node2.inDegree + 1;
            node1.adjNodes.add(node2);
            nodeMap.put(u, node1);
        } else {
            if(node2 == null) {
                node2 = new Node(v);
                nodeMap.put(v, node2);
            }

            node2.inDegree = node2.inDegree + 1;
            node1.adjNodes.add(node2);
        }
    }

    private static void DFSUtil(Node startNode, List<Node> nodeList, AtomicInteger timeStamp) throws Exception {
        startNode.startTime = timeStamp.get();
        startNode.colour = Colour.GREY;
        for(Node node : startNode.adjNodes) {
            if(node.colour == Colour.GREY)
                throw new Exception("Cycle is detected");
            else if(node.colour == Colour.WHITE) {
                timeStamp.set(timeStamp.get() + 1);
                DFSUtil(node, nodeList, timeStamp);
            }
        }
        timeStamp.set(timeStamp.get() + 1);
        startNode.endTime = timeStamp.get();
        startNode.colour = Colour.BLACK;

        nodeList.add(startNode);
    }

    private static List<Node> topologicalSort(Map<Integer, Node> nodeMap) throws Exception {
        List<Node> result = new LinkedList<>();
        AtomicInteger timeStamp = new AtomicInteger(0);
        for(Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
            Node node = entry.getValue();
            if(node.colour == Colour.WHITE && node.inDegree == 0) {
                timeStamp.set(timeStamp.get() + 1);
                DFSUtil(node, result, timeStamp);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph(5);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(4, 5);

        try {
            List<Node> nodes = topologicalSort(directedGraph.nodeMap);
            for(Node node : nodes)
                System.out.println(node.value + " " + node.inDegree + " " + node.startTime + " " +
                        node.endTime + " " + node.colour);
            System.out.println();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }




}
