/**
 * Created by arnab.ray on 10/09/17.
 */
public class NearestSmallerNum {

    private static void printPrevSmaller(int[] arr) {
        int min, max;
        if(arr[0] < arr[1]) {
            min = arr[0];
            max = arr[1];
        }
        else {
            min = arr[1];
            max = arr[0];
        }

        System.out.print("_, ");
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
                System.out.print(max + ", ");
            else {
                if(arr[i] > min) {
                    max = arr[i];
                    System.out.print(min + ", ");
                }
                else {
                    min = arr[i];
                    System.out.print("_, ");
                }
            }
        }

    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 0, 2, 5};
        printPrevSmaller(arr);
    }
}
