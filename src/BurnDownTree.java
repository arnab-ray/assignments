import java.util.*;

public class BurnDownTree {

    private TreeNode root;
    private static int timeTaken;

    private static void traverseQueue(Queue<TreeNode> queue) {
        int size = queue.size();
        if(size > 0)
            timeTaken++;
        while (size-- != 0) {
            TreeNode temp = queue.peek();
            System.out.print(temp.data + ",");
            queue.poll();

            if(temp.left != null)
                queue.add(temp.left);

            if(temp.right != null)
                queue.add(temp.right);

        }
    }

    private static int burnDownTreeUtil(TreeNode root, int target, Queue<TreeNode> queue) {
        if(root == null)
            return 0;

        if(root.data == target) {
            System.out.println(root.data);

            if(root.left != null)
                queue.add(root.left);

            if(root.right != null)
                queue.add(root.right);

            return 1;
        }

        int a = burnDownTreeUtil(root.left, target, queue);

        if(a == 1) {
            traverseQueue(queue);

            if(root.right != null)
                queue.add(root.right);

            System.out.println(root.data);
            return 1;
        }

        int b = burnDownTreeUtil(root.right, target, queue);

        if(b == 1) {
            traverseQueue(queue);

            if(root.left != null)
                queue.add(root.left);

            System.out.println(root.data);
            return 1;
        }

        return 0;
    }

    private static void burnDownTree(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        //int timeRequired = 0;
        burnDownTreeUtil(root, target, queue);

        timeTaken++;
        while (!queue.isEmpty()){
            TreeNode temp = queue.peek();
            System.out.print(temp.data);
            if (queue.size() != 1)
                System.out.print(",");
            queue.poll();

        }
    }

    private static void burnDownTree_(TreeNode root, List<TreeNode> rootTreeNodes) {
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            return;

        if(root.left != null)
            burnDownTree_(root.left, rootTreeNodes);
        if(root.right != null)
            burnDownTree_(root.right, rootTreeNodes);
        if(root.isBurning()) {
            if(root.left != null && !root.left.isBurning())
                rootTreeNodes.add(root.left);
            if(root.right != null && !root.right.isBurning())
                rootTreeNodes.add(root.right);
        } else {
            if(root.left.isBurning() || root.right.isBurning())
                rootTreeNodes.add(root);

            if(root.left != null && root.left.isBurning())
                root.left = null;
            if(root.right != null && root.right.isBurning())
                root.right = null;
        }
    }

    private static void printForest(List<TreeNode> rootTreeNodes) {
        for(TreeNode rootTreeNode : rootTreeNodes) {
            printTree(rootTreeNode);
            System.out.println();
        }
    }

    private static void printTree(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null)
            printTree(root.left);
        System.out.print(root.data + " ");
        if(root.right != null)
            printTree(root.right);
    }

    private static void printAllPaths(TreeNode root, Deque<Integer> path){
        if(root == null)
            return;
        path.add(root.data);
        if(root.left == null && root.right == null) {
            System.out.println(path);
        }
        printAllPaths(root.left, path);
        printAllPaths(root.right, path);
        path.removeLast();
    }

    private static void printAllPaths(TreeNode root, Stack<Integer> path){
        if(root == null)
            return;
        path.push(root.data);
        if(root.left == null && root.right == null) {
            ListIterator it = path.listIterator(path.size());
            while(it.hasPrevious())
                System.out.print(it.previous() + " ");
            System.out.println();
        }
        printAllPaths(root.left, path);
        printAllPaths(root.right, path);
        path.pop();
    }

    private static void findAncestors(TreeNode root, TreeNode target, Deque<Integer> path){
        if(root == null)
            return;
        if(root.data == target.data) {
            System.out.println(path);
        }
        path.add(root.data);
        findAncestors(root.left, target, path);
        findAncestors(root.right, target, path);
        path.removeLast();
    }

    private static boolean findAncestors(TreeNode root, TreeNode target) {
        if(root == null)
            return false;
        if(root.data == target.data)
            return true;
        boolean left = findAncestors(root.left, target);
        boolean right = false;
        if(!left)
            right = findAncestors(root.right, target);
        if(left || right)
            System.out.print(root.data + " ");

        return left || right;
    }

    private static void calculateDiagonalSum(TreeNode root, int level, Map<Integer, Integer> sumMap){
        if(root == null)
            return;
        if(sumMap.get(level) == null)
            sumMap.put(level, root.data);
        else
            sumMap.put(level, sumMap.get(level) + root.data);
        calculateDiagonalSum(root.left, level + 1, sumMap);
        calculateDiagonalSum(root.right, level, sumMap);
    }


    private static void printCornerNodes(TreeNode root) {
        if(root == null)
            return;
        Deque<TreeNode> treeNodeQueue1 = new ArrayDeque<>();
        Deque<TreeNode> treeNodeQueue2 = new ArrayDeque<>();

        treeNodeQueue1.add(root);

        while(!treeNodeQueue1.isEmpty() || !treeNodeQueue2.isEmpty()) {
            if(!treeNodeQueue1.isEmpty()) {
                TreeNode start = treeNodeQueue1.peekFirst();
                TreeNode end = treeNodeQueue1.peekLast();
                if(treeNodeQueue1.size() == 1)
                    System.out.println(start.data);
                else
                    System.out.println(start.data + " " + end.data);

                while(!treeNodeQueue1.isEmpty()) {
                    TreeNode treeNode = treeNodeQueue1.remove();
                    if(treeNode.left != null)
                        treeNodeQueue2.add(treeNode.left);
                    if(treeNode.right != null)
                        treeNodeQueue2.add(treeNode.right);
                }
            } if(!treeNodeQueue2.isEmpty()){
                TreeNode start = treeNodeQueue2.peekFirst();
                TreeNode end = treeNodeQueue2.peekLast();

                if(treeNodeQueue2.size() == 1)
                    System.out.println(start.data);
                else
                    System.out.println(start.data + " " + end.data);


                while(!treeNodeQueue2.isEmpty()) {
                    TreeNode treeNode = treeNodeQueue2.remove();
                    if(treeNode.left != null)
                        treeNodeQueue1.add(treeNode.left);
                    if(treeNode.right != null)
                        treeNodeQueue1.add(treeNode.right);
                }

            }
        }
    }

    private static int maxSumPath(TreeNode root, Deque<TreeNode> path, int sum) {
        if(root == null)
            return 0;
        path.add(root);
        sum += root.data;
        if(root.left == null && root.right == null) {
            //printPath(path);
            return sum;
        }
        int leftSum = maxSumPath(root.left, path, sum);
        int rightSum = maxSumPath(root.right, path, sum);
        TreeNode lastTreeNode = path.peekLast();


        return Math.max(leftSum, rightSum);
    }




    public static void main(String[] args) {
        BurnDownTree tree = new BurnDownTree();

        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(13, true);

        tree.root.right.left = new TreeNode(14);
        tree.root.right.right = new TreeNode(15, true);

        tree.root.right.left.left = new TreeNode(21);
        tree.root.right.left.right = new TreeNode(22);
        tree.root.right.right.left = new TreeNode(23);
        tree.root.right.right.right = new TreeNode(24);

        int targetNode = 14;

        Map<Integer, Integer> sumMap = new HashMap<>();
        calculateDiagonalSum(tree.root, 0, sumMap);

        for(Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        //findAncestors(tree.root, new TreeNode(24));
        System.out.println();
        printAllPaths(tree.root, new Stack<>());
        //printCornerNodes(tree.root);
        //findAncestors(tree.root, new TreeNode(24), new ArrayDeque<>());

        List<TreeNode> rootTreeNodes = new ArrayList<>();
        //burnDownTree_(tree.root, rootTreeNodes);
        System.out.println();
        //printForest(rootTreeNodes);
        //System.out.println("time taken:" + timeTaken);
    }

}
