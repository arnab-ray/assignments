import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class problem
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        // WRITE YOUR CODE HERE
        class Node {
            List<Integer> point;
            Integer distance;

            public Node(List<Integer> point, Integer distance) {
                this.point = point;
                this.distance = distance;
            }
        }

        class NodeComparator implements Comparator<Node> {
            public int compare(Node n1, Node n2) {
                if(n1.distance < n2.distance)
                    return 1;
                else if(n1.distance > n2.distance)
                    return -1;
                else
                    return 0;
            }
        }

        int totalCombinations = forwardRouteList.size() * returnRouteList.size();
        PriorityQueue<Node> nodeList = new PriorityQueue<>(totalCombinations, new NodeComparator());

        for(int i = 0; i < forwardRouteList.size(); i++) {
            for(int j = 0; j < returnRouteList.size(); j++) {
                List<Integer> point = new ArrayList<>();
                point.add(forwardRouteList.get(i).get(0));
                point.add(returnRouteList.get(j).get(0));
                Integer distance = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
                nodeList.add(new Node(point, distance));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while(!nodeList.isEmpty()) {
            Node node = nodeList.poll();
            if(node.distance <= maxTravelDist)
                result.add(node.point);
        }

        return result;
    }
    // METHOD SIGNATURE ENDS
}