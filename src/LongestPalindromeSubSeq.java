import java.util.Arrays;

public class LongestPalindromeSubSeq {

    private static int lpsUtil(char[] chars, int i, int j, int[][] lp) {
        if(i == j)
            return 1;
        else if(chars[i] == chars[j] && i + 1 == j)
            return 2;
        else if (lp[i][j] == -1) {
            if(chars[i] == chars[j])
                    lp[i][j] = lpsUtil(chars, i + 1, j - 1, lp) + 2;
            else
                lp[i][j] = Math.max(lpsUtil(chars, i + 1, j, lp), lpsUtil(chars, i, j - 1, lp));

        }

        return lp[i][j];
    }

    private static int lps(String str) {
        char[] chars = str.toCharArray();
        int n = str.length();
        int[][] lp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j)
                    lp[i][j] = 1;
                else
                    lp[i][j] = -1;
            }
        }
        return lpsUtil(chars, 0, n-1, lp);
    }

    public static void main(String[] args) {
        System.out.println(lps("ABBDCACB"));
    }
}
