import java.util.LinkedList;
import java.util.Queue;

public class SpecificTraversal {

    private TreeNode root;

    private static void traversal(TreeNode root) {
        if(root == null)
            return;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        System.out.print(root.data + " ");
        if(root.left != null)
            q1.add(root.left);
        if(root.right != null)
            q2.add(root.right);

        while(!q1.isEmpty() || !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if(n1 != null) {
                if(n1.left != null)
                    q1.add(n1.left);
                if(n1.right != null)
                    q1.add(n1.right);

                System.out.print(n1.data + " ");
            }
            if(n2 != null) {
                if(n2.right != null)
                    q2.add(n2.right);
                if(n2.left != null)
                    q2.add(n2.left);

                System.out.print(n2.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        SpecificTraversal tree = new SpecificTraversal();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);

        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        tree.root.left.left.left = new TreeNode(8);
        tree.root.left.left.right = new TreeNode(9);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(11);

        tree.root.right.left.left = new TreeNode(12);
        tree.root.right.left.right = new TreeNode(13);
        tree.root.right.right.left = new TreeNode(14);
        tree.root.right.right.right = new TreeNode(15);

        traversal(tree.root);
    }
}
