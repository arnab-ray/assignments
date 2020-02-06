class TrieNode {
    boolean isLeaf;
    TrieNode[] children;

    public TrieNode(int childNum) {
        isLeaf = false;
        children = new TrieNode[childNum];
        for(TrieNode child : children)
            child = null;
    }
}
