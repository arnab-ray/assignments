import java.util.Scanner;

/**
 * Created by arnab.ray on 25/09/17.
 */
public class DeepestPit {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int depth = 0;
        int P = 0, Q = -1, R;
        for(int i = 1; i < A.length; i++) {
            if(Q < 0 && A[i] >= A[i-1])
                Q = i - 1;
            if((Q >= 0) && (A[i] <= A[i-1] || i + 1 == A.length)) {
                if(A[i] <= A[i-1])
                    R = i-1;
                else
                    R = i;
                depth = Math.max(depth, Math.min(A[P]-A[Q], A[R]-A[Q]));
                P = i - 1;
                Q = -1;
            }

        }
        if (depth == 0) 
            depth = -1;
        return depth;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

    }
}
