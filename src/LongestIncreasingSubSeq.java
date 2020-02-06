import java.util.Arrays;

public class LongestIncreasingSubSeq {

    private static void printLis(int[] arr, int[] indexStore, int index) {
        if(indexStore[index] != -1) {
            printLis(arr, indexStore, indexStore[index]);
            System.out.print(arr[index] + " ");
        } else
            System.out.print(arr[index] + " ");
    }

    private static int getLisCount(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int[] indexStore = new int[n];
        Arrays.fill(lis, 1);

        for(int i = 0; i < n; i++)
            indexStore[i] = -1;

        int max = 1;
        int maxIndex = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if(max < lis[i]) {
                        max = lis[i];
                        maxIndex = i;
                    }
                    indexStore[i] = j;
                }
            }
        }

        printLis(arr, indexStore, maxIndex);
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(getLisCount(arr));
    }
}
