/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

*///import for Scanner and other utility  classes
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */

        /*HashSet<Character> vowels = initializeVowels();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            int N = s.nextInt();
            s.nextLine();
            String S = s.nextLine();
            System.out.println(count(S, vowels));
        }*/

        //List<Integer> prices = new ArrayList<>();

        /*List<Integer> arrival = new ArrayList<>();
        List<Integer> duration = new ArrayList<>();

        List<Integer> requestTime = new ArrayList<>();*/

        //List<Integer> requestTime = new ArrayList<>();
        int[] requestTime = new int[100];
        /*Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            requestTime[i] = s.nextInt();
        }*/

        /*N = s.nextInt();
        for (int i = 0; i < N; i++) {
            duration.add(s.nextInt());
        }*/

        /*Map<String, List<Integer>> map = new HashMap<>();
        map.put("alpha", new ArrayList<>(Arrays.asList(1, 2, 3)));
        map.put("beta", new ArrayList<>(Arrays.asList(2, 3, 4)));

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ":");
            entry.getValue().forEach(System.out::print);
            System.out.println();
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> nums = entry.getValue();
            nums.removeIf(n -> n == 2);
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ":");
            entry.getValue().forEach(System.out::print);
            System.out.println();
        }*/

        //System.out.println(droppedRequests(requestTime));
        //System.out.println(findDiff(requestTime));
        findNextHigherPermutation(265410);
        //finalPrice(prices);
    }


    private static void findNextHigherPermutation(int num) {
        int[] numArr = Integer.toString(num).chars().map(c -> c - '0').toArray();
        int lowerNumIndex = -1;
        for(int i = numArr.length - 1; i > 0; i--) {
            if(numArr[i - 1] < numArr[i]) {
                lowerNumIndex = i - 1;
                break;
            }
        }

        if(lowerNumIndex == -1) {
            System.out.println("Not possible");
            return;
        } else {
            int highNumIndex = lowerNumIndex + 1;
            for(int i = lowerNumIndex + 2; i < numArr.length; i++) {
                if(numArr[i] > numArr[lowerNumIndex] && numArr[i] < numArr[highNumIndex]) {
                    highNumIndex = i;
                }
            }

            int temp = numArr[lowerNumIndex];
            numArr[lowerNumIndex] = numArr[highNumIndex];
            numArr[highNumIndex] = temp;
        }

        int i = lowerNumIndex + 1;
        int j = numArr.length - 1;

        while(i < j) {
            int temp = numArr[i];
            numArr[i++] = numArr[j];
            numArr[j--] = temp;
        }

        for(int k = 0; k < numArr.length; k++)
            System.out.print(numArr[k]);

    }


    private static int findDiff(int[] arr) {
        int min = Integer.MAX_VALUE;
        int diff = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
            diff = Math.max(diff, arr[i] - min);
        }
        return diff;
    }


    private static int maxProduct(int[] arr) {
        int max_neg, neg, max_pos, pos;
        max_pos = pos = Integer.MIN_VALUE;
        max_neg = neg = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && arr[i] > max_pos) {
                pos = max_pos;
                max_pos = arr[i];
            } else if(arr[i] > 0 && arr[i] > pos) {
                pos = arr[i];
            } else if(arr[i] < 0 && arr[i] < max_neg) {
                neg = max_neg;
                max_neg = arr[i];
            } else if(arr[i] < 0 && arr[i] < neg){
                neg = arr[i];
            }
        }

        int prod_pos = pos * max_pos;
        int prod_neg = neg * max_neg;

        return Math.max(prod_pos, prod_neg);
    }


    private static int count(String str, HashSet<Character> vowels) {
        int first_pos = -1, second_pos = -1, third_pos = -1;
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(vowels.contains(str.charAt(i))) {
                if (first_pos < 0)
                    first_pos = i;
                else if (second_pos < 0)
                    second_pos = i;
                else
                    third_pos = i;

                if(third_pos > 0) {
                    count++;
                    break;
                }
            }
        }

        for(int i = third_pos + 1; i < str.length(); i++) {
            if(vowels.contains(str.charAt(i))) {
                first_pos = second_pos;
                second_pos = third_pos;
                third_pos = i;
                count++;
            }
        }

        return count;
    }

    private static HashSet<Character> initializeVowels() {
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        return vowels;
    }


    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        class Interval {
            Integer start;
            Integer end;

            public Interval(Integer start, Integer end) {
                this.start = start;
                this.end = end;
            }
        }

        final Comparator<Interval> EndComparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end.compareTo(o2.end);
            }
        };

        List<Interval> intervalList = new ArrayList<>();

        for(int i = 0; i < arrival.size(); i++) {
            Interval interval = new Interval(arrival.get(i), (arrival.get(i) + duration.get(i)));
            intervalList.add(interval);
        }

        Collections.sort(intervalList, EndComparator);

        int count = 1;

        Integer e1 = intervalList.get(0).end;

        for(int i = 1; i < intervalList.size(); i++) {
            Integer s2 = intervalList.get(i).start;
            Integer e2 = intervalList.get(i).end;

            if(s2 >= e1) {
                count++;
                e1 = e2;
            }
        }

        return count;
    }

    public static void finalPrice(List<Integer> prices) {
        // Write your code here
        int len = prices.size();
        Integer[] leastPriceSeen = new Integer[len];
        List<Integer> undiscountedIndex = new ArrayList<>();
        Integer[] priceArr = prices.stream().toArray(Integer[]::new);

        Stack<Integer> stack = new Stack<>();

        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() > priceArr[i]) {
                stack.pop();
            }

            if(stack.isEmpty())
                leastPriceSeen[i] = -1;
            else
                leastPriceSeen[i] = stack.peek();

            stack.push(priceArr[i]);
        }

        for(int i = 0; i < len; i++)
            System.out.print(leastPriceSeen[i] + " ");

        System.out.println();


        for(int i = 0; i < len; i++)
            System.out.print(priceArr[i] + " ");

        System.out.println();

        long cost = 0;
        for(int i = 0; i < len; i++) {
            if(leastPriceSeen[i] != -1 && leastPriceSeen[i] <= priceArr[i]) {
                cost += (priceArr[i] - leastPriceSeen[i]);
            } else {
                cost += priceArr[i];
                undiscountedIndex.add(i);
            }
        }


        System.out.println(cost);
        if(!undiscountedIndex.isEmpty()) {
            for(Integer index : undiscountedIndex)
                System.out.print(index + " ");
        }
    }


    static int droppedRequests(List<Integer> requestTime) {
        Map<Integer, Integer> secondToFrequency = new HashMap<>(); // bucket mapping to 1, 2, 3
        Map<Integer, Integer> tenSecondToFrequency = new HashMap<>(); //bucket mapping to 10, 20, 30
        Map<Integer, Integer> minuteToFrequency = new HashMap<>(); // bucket mapping to 60, 120,

        int droppedRequest = 0;
        for(int i = 0; i < requestTime.size(); i++) {
            if(secondToFrequency.isEmpty() || secondToFrequency.get(requestTime.get(i)) == null)
                secondToFrequency.put(requestTime.get(i), 1);
            else if(secondToFrequency.get(requestTime.get(i)) < 3)
                secondToFrequency.put(requestTime.get(i), secondToFrequency.get(requestTime.get(i)) + 1);
            else
                droppedRequest++;

            int tenSecondBucket = (requestTime.get(i)/10)*10;
            if(tenSecondToFrequency.isEmpty() || tenSecondToFrequency.get(tenSecondBucket) == null)
                tenSecondToFrequency.put(tenSecondBucket, 1);
            else if(tenSecondToFrequency.get(tenSecondBucket) < 20) {
                tenSecondToFrequency.put(tenSecondBucket, tenSecondToFrequency.get(tenSecondBucket) + 1);
            } else
                droppedRequest++;

            int minuteBucket = (requestTime.get(i)/60)*60;
            if(minuteToFrequency.isEmpty() || minuteToFrequency.get(minuteBucket) == null)
                minuteToFrequency.put(minuteBucket, 1);
            else if(minuteToFrequency.get(minuteBucket) < 60) {
                minuteToFrequency.put(minuteBucket, minuteToFrequency.get(minuteBucket) + 1);
            } else
                droppedRequest++;
        }

        for(Map.Entry<Integer, Integer> entry : secondToFrequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return droppedRequest;
    }
}