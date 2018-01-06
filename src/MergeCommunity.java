import java.util.Scanner;
/**
 * Created by arnab.ray on 01/05/16.
 */
public class MergeCommunity {
    private static void Merge(int[] S, int i, int j) {
        if(S[i] < S[j])
            S[j] = i;
        else if(S[i] == S[j]) {
            S[i]--;
            S[j] = i;
        }
    }

    private static int Find(int[] S, int i) {
        if(S[i] <= -1)
            return S[i];
        else
            return Find(S, S[i]);
    }

    private static int QuerySet(int[] S, int i) {
        if(S[i] <= -1)
            return S[i];
        else
            return S[i] = Find(S, i);
    }

    private static int QuerySize(int[] S, int i) {
        int size = 1;
        for(int j = 0; j < S.length && j != i; j++) {
            if(QuerySet(S, i) == QuerySet(S, j))
                size++;
        }
        return size;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();

        int[] S = new int[N];
        for(int i = 0; i < N; i++)
            S[i] = -1;
        for(int k = 0; k < Q; k++) {
            String query = in.next();
            int i = in.nextInt();
            if(query.equalsIgnoreCase("M")) {
                int j = in.nextInt();
                Merge(S, i-1, j-1);
            }
            else if(query.equalsIgnoreCase("Q")) {
                System.out.println(QuerySize(S, i-1));
            }
        }
        in.close();
    }
}
