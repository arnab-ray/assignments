import java.util.Arrays;

/**
 * Created by arnab.ray on 28/08/17.
 */
public class PrintPermutation {

    public static void lexicoGraphicPermutationUtil(char[] input, char[] output, int lastIndex, int currentIndex) {
        int len = input.length;

        for(int i = 0; i < len; i++) {
            output[currentIndex] = input[i];
            if(currentIndex == lastIndex)
                System.out.println(String.valueOf(output));
            else
                lexicoGraphicPermutationUtil(input, output, lastIndex, currentIndex + 1);
        }
    }

    public static void allLexicoGraphicPermutation(String string) {
        char[] temp = string.toCharArray();
        Arrays.sort(temp);
        char[] output = new char[string.length()];
        lexicoGraphicPermutationUtil(temp, output, string.length()-1, 0);
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("All permutations with repetition of %s are: " + str);
        allLexicoGraphicPermutation(str);
    }
}
