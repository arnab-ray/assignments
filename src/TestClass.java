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

        HashSet<Character> vowels = initializeVowels();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            int N = s.nextInt();
            s.nextLine();
            String S = s.nextLine();
            System.out.println(count(S, vowels));
        }


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
}