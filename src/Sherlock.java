import java.util.Scanner;

/**
 * Created by arnab.ray on 08/10/17.
 */
public class Sherlock {

    /*private static int findMaxSum(int[] B) {
        int sum;
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i ++) {
            int N = scanner.nextInt();
            int[] B = new int[N];
            for(int j = 0; j < N; j++) {
                B[j] = scanner.nextInt();
            }
        }
    }
}
