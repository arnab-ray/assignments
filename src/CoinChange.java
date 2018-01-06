/**
 * Created by arnab.ray on 05/09/17.
 */
public class CoinChange {

    private static int countChange(int[] S, int m, int n, int[][] memo) {
        if(n == 0)
            return 1;
        if((n < 0) || (m < 0 && n >= 1))
            return 0;
        if(memo[m][n] != -1)
            return memo[m][n];

        memo[m][n] = countChange(S, m-1, n, memo) + countChange(S, m, n - S[m], memo);
        return memo[m][n];
    }


    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int m = coins.length;
        int n = 11;
        int[][] memo = new int[m][n+1];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n+1; j++)
                memo[i][j] = -1;

        System.out.println(countChange(coins, m-1, n, memo));
    }
}
