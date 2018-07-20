package Palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PalindromePairTTT {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for(int j =0; j < words.length; j++) {
            for(int i = 0; i <= words[j].length(); i++) { // as right part
                String t1 = words[j].substring(0, i);
                if(isPalindrome(t1)) {
                    String t2 = new StringBuilder(words[j].substring(i)).reverse().toString();
                    Integer k = map.get(t2);
                    if(k != null && k != j) {
                        List<Integer> ret = new ArrayList<>(2);
                        ret.add(k);
                        ret.add(j);
                        result.add(ret);
                    }
                }
            }
            for(int i = words[j].length()-1; i >=0; i--) { // as left part
                String word = words[j];
                String t1 = word.substring(i, word.length());
                if(isPalindrome(t1)) {
                    String t2 = new StringBuilder(word.substring(0, i)).reverse().toString();
                    Integer k = map.get(t2);
                    if(k!= null && k != j) {
                        List<Integer> ret = new ArrayList<>(2);
                        ret.add(j);
                        ret.add(k);
                        result.add(ret);
                    }
                }
            }
        }
        return result;
    }

    boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0, j = s.length()-1;
        while(i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
}
