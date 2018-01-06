/**
 * Created by arnab.ray on 05/09/17.
 */
public class MaxDecimalVal {

    private static int maxDecimalValue(int[][] input, int m, int n) {
        int[][] memo = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    memo[i][j] = (int) Math.pow(2, i+j)*input[i][j];
                else if(i == 0)
                    memo[i][j] = ((int) Math.pow(2, j)*input[i][j]) + memo[i][j-1];
                else if(j == 0)
                    memo[i][j] = ((int) Math.pow(2, i)*input[i][j]) + memo[i-1][j];
                else
                    memo[i][j] = ((int) Math.pow(2, i + j)*input[i][j]) + Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

        return memo[m-1][n-1];
    }

    public static void main(String[] args) {
        int mat[][] = {{ 1 ,1 ,0 ,1 },
            { 0 ,1 ,1 ,0 },
            { 1 ,0 ,0 ,1 },
            { 1 ,0 ,1 ,1 },
        };

        System.out.println(maxDecimalValue(mat, 4, 4));
    }
}
