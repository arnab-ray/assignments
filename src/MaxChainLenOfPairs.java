import java.util.Arrays;

public class MaxChainLenOfPairs {

    private static class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return this.a - o.a;
        }
    }


    private static int findMaxLen(Pair[] pairs) {
        Arrays.sort(pairs);
        int n = pairs.length;
        int[] lcs = new int[n];
        Arrays.fill(lcs, 1);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[i].a > pairs[j].b && lcs[i] < lcs[j] + 1)
                    lcs[i] = lcs[j] + 1;
            }
        }

        return lcs[n - 1];
    }

    public static void main(String[] args) {
        Pair[] pairs = new Pair[5];
        pairs[0] = new Pair(5,24);
        pairs[1] = new Pair(39, 60);
        pairs[2] = new Pair(15, 28);
        pairs[3] = new Pair(27, 40);
        pairs[4] = new Pair(50, 90);

        System.out.println(findMaxLen(pairs));
    }
}
