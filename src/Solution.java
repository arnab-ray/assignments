import java.util.*;

public class Solution {




    static int findSubarraySum(int arr[], int n, int sum)
    {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;

        // Sum of elements so far.
        int currsum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currsum += arr[i];
            System.out.println("currsum: " + currsum + " | currsum - sum: " + (currsum - sum));

            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;

            // currsum exceeds given sum by currsum
            //  - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);


            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count+1);
        }

        return res;
    }

    static void printKthBit(long n, long k)
    {
        System.out.println( (n & (1 << (k - 1))));
    }

    private static Map<Character, String> getMappings() {
        Map<Character, String> map = new HashMap<>();
        map.put('A', "2");
        map.put('B', "2");
        map.put('C', "2");
        map.put('D', "3");
        map.put('E', "3");
        map.put('F', "3");
        map.put('G', "4");
        map.put('H', "4");
        map.put('I', "4");
        map.put('J', "5");
        map.put('K', "5");
        map.put('L', "5");
        map.put('M', "6");
        map.put('N', "6");
        map.put('O', "6");
        map.put('P', "7");
        map.put('Q', "7");
        map.put('R', "7");
        map.put('S', "7");
        map.put('T', "8");
        map.put('U', "8");
        map.put('V', "8");
        map.put('W', "9");
        map.put('X', "9");
        map.put('Y', "9");
        map.put('Z', "9");

        return map;
    }

    private static boolean isMatch(Map<Character, String> map, String code, String number) {
        StringBuilder stringBuffer = new StringBuilder();
        for(int i = 0; i < code.length(); i++)
            stringBuffer.append(map.get(code.charAt(i)));

        return number.contains(stringBuffer.toString());
    }

    public static List<String> vanity(List<String> codes, List<String> numbers) {
        List<String> result = new ArrayList<>();
        Set<String> numberSet = new TreeSet<>();
        for(String number : numbers)
            numberSet.add(number);

        Map<Character, String> map = getMappings();

        for(String code : codes) {
            for(String number : numberSet) {
                if(isMatch(map, code, number))
                    result.add(number);
            }
        }

        return result;
    }

    public static void main(String []args){

        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        //int n = arr.length;
        String str = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
                "Aenean massa. Cum sociis natoque penatibus et magnis dis partur";

        //System.out.println(str.length());

        //long n = 77, k = 4;
        //printKthBit(n, k);
        List<String> codes = new ArrayList<>();
        codes.add("TWLO");

        List<String> numbers = new ArrayList<>();
        numbers.add("+14157088956");
        numbers.add("+15109926333");
        numbers.add("+17474824380");
        numbers.add("+1415123456");
        numbers.add("+919810155555");
        List<String> numbersRes = vanity(codes, numbers);
        for(String str1 :  numbersRes)
            System.out.println(str1);

        //System.out.println(findSubarraySum(arr, n, sum));
    }
}
