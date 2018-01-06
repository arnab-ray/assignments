import static java.lang.Math.pow;

/**
 * Created by arnab.ray on 03/10/17.
 */
public class Binaries {

    /*public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }*/

    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        //BigInteger binarian = new BigInteger("0");
        int binarian = 0;
        for(int i = 0; i < N; i++) {
            binarian += pow(2, A[i]); //binarian.add(BigInteger.valueOf((long)pow(2, A[i])));
        }

        System.out.println("binarian :: " + binarian);
        int max_bound = binarian; //(int)sqrt(binarian); //sqrt(binarian).intValue();
        int[] table = new int[max_bound+1];

        table[0] = 0;
        for (int i=1; i<=max_bound; i++)
            table[i] = Integer.MAX_VALUE;


        for (int i=1; i<=max_bound; i++)
        {
            for (int j=0; j<N; j++) {
                if (pow(2, j) <= i) {
                    int sub_res = table[i - (int)pow(2,j)];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
            }
        }


        //for(int i = 0; i <= max_bound; i++)
        //    System.out.print(table[i] + " ");

        return table[max_bound];
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 0, 0, 2};
        Binaries bin = new Binaries();
        System.out.println(bin.solution(A));
    }
}
