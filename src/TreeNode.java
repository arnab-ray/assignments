class TreeNode {
    int data;
    TreeNode left, right;
    boolean burninig;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.burninig = false;
    }

    public TreeNode(int data, boolean burning) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.burninig = burning;
    }

    public boolean isBurning() {
        return this.burninig;
    }
}