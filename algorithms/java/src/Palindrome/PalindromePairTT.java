package Palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairTT {
    boolean isPalindrome(String str) {
        if (str.isEmpty()) return true;
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        // Arrays.sort(words, (a, b)->(a.length-b.length));
        for (int k = 0; k < words.length; k++) {
            String word = words[k];
            // judge all kinds of different possbilities
            for (int i = word.length(); i >= 0; i--) {
                String suffix = word.substring(i);
                if (isPalindrome(suffix)) {
                    String reversedPrefix = new StringBuilder(word.substring(0,
                            i)).reverse().toString();
                    if (suffix.isEmpty() && reversedPrefix.equals(word)) {
                        continue;
                    }
                    if (map.containsKey(reversedPrefix)) {
                        List<Integer> r = new ArrayList<>();
                        r.add(i);
                        r.add(map.get(reversedPrefix));
                        result.add(r);
                    }
                }
            }
        }
        return result;
    }
}
