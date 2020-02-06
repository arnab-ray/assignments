public class LongestCommonSubstring {

    private static int lcStr(String a, String b) {
        int m = a.length();
        int n = b.length();
        int max = 0;
        int[][] lcs = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++)
            lcs[i][0] = 0;

        for(int j = 0; j < n + 1; j++)
            lcs[0][j] = 0;

        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1))
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = 0;

                if(max < lcs[i][j])
                    max = lcs[i][j];

            }
        }

        return max;
    }

    public static void main(String[] args) {
        String a = "zxabcdezy";
        String b = "yzabcdezx";

        System.out.println(lcStr(a, b));
    }
}
