/**
 * Created by arnab.ray on 05/09/17.
 */
public class PathCountWithCoins {


    private static int pathCount(int[][] mat, int m, int n, int K, int[][][] memo) {
        if (m < 0 || n < 0)
            return 0;
        if(m == 0 && n == 0)
            return K == mat[m][n] ? 1 : 0;

        if(memo[m][n][K] != -1)
            return memo[m][n][K];

        memo[m][n][K] = pathCount(mat, m - 1, n, K-mat[m][n], memo) + pathCount(mat, m, n-1, K-mat[m][n], memo);

        return memo[m][n][K];
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 6, 5}, {3, 2, 1}};

        int m = 3;
        int n = 3;
        int K = 12;

        int[][][] memo = new int[m][n][K+1];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < K+1; k++)
                    memo[i][j][k] = -1;

        System.out.println(pathCount(mat, m-1, n-1, K, memo));
    }
}
