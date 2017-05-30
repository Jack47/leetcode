package Palindrome;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
// O(n*k^2), n is the total number of words, k the average length of each word
// https://leetcode.com/problems/palindrome-pairs/#/description

public class PalindromePair {
    String reverse(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();

    }

    public boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();

        // generate word hash set, allow quickly judge whether word exist
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], new Integer(i));
        }

        for (int i = 0; i < words.length; i++) {
            // distinct words, so len can't be word.length
            for (int len = 1; len <= words[i].length(); len++) {
                String firstPart = words[i].substring(0, len);
                String secondPart = words[i].substring(len);

                if (isPalindrome(secondPart)) {
                    Integer j = wordMap.get(reverse(firstPart));
                    if (j != null && j != i) {
                        List<Integer> pair = new LinkedList<Integer>();
                        pair.add(i);
                        pair.add(j);
                        ret.add(pair);
                    }
                }
                // switch left with right
                if (isPalindrome(firstPart)) {
                    Integer j = wordMap.get(reverse(secondPart));
                    if (j != null && j == i) {
                        List<Integer> pair = new LinkedList<Integer>();
                        pair.add(j);
                        pair.add(i);
                        ret.add(pair);
                        if (secondPart.isEmpty()) {
                            pair = new LinkedList<Integer>();
                            pair.add(i);
                            pair.add(j);
                            ret.add(pair);
                        }
                    }
                }
            }
        }
        return ret;
    }
}
