import java.util.Arrays;
import java.util.List;

public class WordBreakTrie {

    static class Trie {
        private TrieNode root;

        public void setRoot(TrieNode root) {
            this.root = root;
        }

        public TrieNode getRoot() {
            return this.root;
        }

        public Trie() {
            root = new TrieNode(26);
        }

        public void insert(TrieNode root, String str) {
            TrieNode currNode = root;

            for(int i = 0; i < str.length(); i++) {
                if(currNode.children[str.charAt(i) - 'a'] == null)
                    currNode.children[str.charAt(i) - 'a'] = new TrieNode(26);

                currNode = currNode.children[str.charAt(i) - 'a'];
            }

            currNode.isLeaf = true;
        }
    }

    public static boolean wordBreak(TrieNode root, String str) {
        boolean[] breakable = new boolean[str.length() + 1];
        breakable[0] = true;

        for(int i = 0; i < str.length(); i++) {
            if(breakable[i]) {
                TrieNode node = root;
                for(int j = i; j < str.length(); j++) {
                    if(node == null)
                        break;

                    node = node.children[str.charAt(j) - 'a'];

                    if(node != null && node.isLeaf)
                        breakable[j + 1] = true;
                }
            }
        }

        return breakable[str.length()];
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "prob", "lem");

        Trie trie = new Trie();
        for(String word : dict)
            trie.insert(trie.getRoot(), word);

        String str = "wordbreakproblem";

        if(wordBreak(trie.getRoot(), str))
            System.out.println("String can be partitioned");
        else
            System.out.println("String cannot be partitioned");
    }
}
