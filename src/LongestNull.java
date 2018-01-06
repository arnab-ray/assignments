import java.util.*;

import static java.lang.Math.max;

/**
 * Created by arnab.ray on 28/08/17.
 */
public class LongestNull {

    private static int longestNull(String string) {
        List<Map.Entry<Character, Integer>> arrayList = new ArrayList<Map.Entry<Character, Integer>>();

        //arrayList.add(new HashMap.SimpleEntry<Character, Integer>('@', -1));
        int maxLen = 0;

        for(int i = 0; i < string.length(); i++) {
            arrayList.add(new HashMap.SimpleEntry<Character, Integer>(string.charAt(i), i));
            while(arrayList.size() >= 3
                    && arrayList.get(arrayList.size() - 3).getKey() == '1'
                    && arrayList.get(arrayList.size() - 2).getKey() == '0'
                    && arrayList.get(arrayList.size() - 1).getKey() == '0')
            {
                arrayList.remove(arrayList.get(arrayList.size() - 3));
                arrayList.remove(arrayList.get(arrayList.size() - 2));
                arrayList.remove(arrayList.get(arrayList.size() - 1));
            }

            int tmp = arrayList.get(arrayList.size() - 1).getValue();
            System.out.println(arrayList);
            System.out.println("tmp: " + tmp);
            maxLen = max(maxLen, i - tmp);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        //longestNull("10111000000100")
        System.out.println(longestNull("10111010101101"));
    }
}
