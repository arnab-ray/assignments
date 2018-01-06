/**
 * Created by arnab.ray on 12/09/17.
 */

class TrieNode {
    boolean isEndOfCol;
    TrieNode[] children;

    public TrieNode() {
        isEndOfCol = false;
        children = new TrieNode[2];
        children[0] = children[1] = null;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode insert(TrieNode node, int[][] M, int row, int col, int colEnd) {
        if(node == null)
            node = new TrieNode();
        if(col < colEnd)
            node.children[M[row][col]] = insert(node.children[M[row][col]], M, row, col+1, colEnd);
        else {
            if(!node.isEndOfCol) {
                node.isEndOfCol = true;
                // Print unique row
                for(int i = 0; i < colEnd; i++)
                    System.out.print(M[row][i]);
                System.out.println();
            }
        }
        return node;
    }
}

public class UniqueRows {

    private static void findUniqueRows(int[][] M) {
        Trie trie = new Trie();
        for(int i = 0; i < M.length; i++) {
            int[] rowElements = M[i];
            trie.root = trie.insert(trie.root, M, i, 0, rowElements.length);
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
