package Palindrome;

import java.util.*;

public class PalindromePairT {
    boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        if (words.length <= 1) return Collections.emptyList();

        List<List<Integer>> results = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = words[i].length(); j >= 0; j--) {
                String first = words[i].substring(0, j);
                String second = words[i].substring(j);
                // words[i] as left part
                if (isPalindrome(second)) {
                    // right part
                    StringBuilder sb = new StringBuilder(first);
                    String reversed = sb.reverse().toString();
                    Integer k = map.get(reversed);
                    if (k != null && k != i) {
                        List<Integer> result = new ArrayList<>(2);
                        result.add(i);
                        result.add(k);
                        results.add(result);
                    }
                }

                // words[i] as right part
                if (isPalindrome(first)) {
                    String reversed = new StringBuilder(second).reverse().toString();
                    Integer k = map.get(reversed);

                    if (k != null && k != i && first.length() != reversed.length()) {
                        List<Integer> result = new ArrayList<>(2);
                        result.add(k);
                        result.add(i);
                        results.add(result);
                    }
                }
            }
        }
        return results;
    }
}
