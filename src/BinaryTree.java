/**
 * Created by arnab.ray on 07/10/17.
 */

public class BinaryTree {
    private TreeNode root;

    TreeNode findLCA(TreeNode root, int n1, int n2) {
        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        TreeNode leftLCA = findLCA(root.left, n1, n2);
        TreeNode rightLCA = findLCA(root.right, n1, n2);

        if(leftLCA != null && rightLCA != null)
            return root;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    TreeNode findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println("LCA(10, 11) = " +
                tree.findLCA(10, 11).data);
        System.out.println("LCA(4, 6) = " +
                tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLCA(2, 4).data);
    }
}
