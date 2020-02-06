/**
 * Created by arnab.ray on 12/09/17.
 */

public class UniqueRows {

    static class Trie {
        private TrieNode root;

        public void setRoot(TrieNode root) {
            this.root = root;
        }

        public TrieNode getRoot() {
            return this.root;
        }

        public Trie() {
            root = new TrieNode(2);
        }

        public TrieNode insert(TrieNode node, int[][] M, int row, int col, int colEnd) {
            if(node == null)
                node = new TrieNode(2);
            if(col < colEnd)
                node.children[M[row][col]] = insert(node.children[M[row][col]], M, row, col+1, colEnd);
            else {
                if(!node.isLeaf) {
                    node.isLeaf = true;
                    // Print unique row
                    for(int i = 0; i < colEnd; i++)
                        System.out.print(M[row][i] + " ");
                    System.out.println();
                }
            }
            return node;
        }
    }

    private static void findUniqueRows(int[][] M) {
        Trie trie = new Trie();
        for(int i = 0; i < M.length; i++) {
            int[] rowElements = M[i];
            trie.setRoot(trie.insert(trie.getRoot(), M, i, 0, rowElements.length));
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 1, 1}
        };
        findUniqueRows(M);
    }
}
