public class LongestCommonSubSeq {

    private static int lcsCount(String a, String b, int m, int n, int[][] lcs) {
        if(m == 0 || n == 0)
            return 0;
        else if(lcs[m][n] == -1) {
            if(a.charAt(m - 1) == b.charAt(n - 1))
                lcs[m][n] = 1 + lcsCount(a, b, m - 1, n - 1, lcs);
            else
                lcs[m][n] = Math.max(lcsCount(a, b, m, n - 1, lcs), lcsCount(a, b, m - 1, n, lcs));
        }

        return lcs[m][n];
    }

    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";

        int m = a.length();
        int n = b.length();

        int[][] lcs = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++)
            for(int j = 0; j < n + 1; j++)
                lcs[i][j] = -1;

        System.out.println(lcsCount(a, b, m, n, lcs));
    }
}
