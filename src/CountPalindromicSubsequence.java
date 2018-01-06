/**
 * Created by arnab.ray on 07/09/17.
 */
public class CountPalindromicSubsequence {

    private static int countPS(String string) {

        char[] str = string.toCharArray();
        int n = string.length();
        int[][] memo = new int [n][n];

        for(int i = 0; i < n-1; i++)
                memo[i+1][i] = 0;

        for(int i = 0; i < n; i++)
            memo[i][i] = 1;

        for (int L = 1; L < n; L++) {
             for(int i = 0; i < n-L; i++) {
                int j = L + i;
                if (str[i] == str[j])
                    memo[i][j] = memo[i + 1][j] + memo[i][j - 1] + 1;
                else
                    memo[i][j] = memo[i + 1][j] + memo[i][j - 1] - memo[i + 1][j - 1];
            }
        }

        return memo[0][n-1];
    }

    public static void main(String[] args) {
        String str = "abcb";
        System.out.println(countPS(str));
    }
}
