package StringRelated;
// Given a string s and a string t, check if s is subsequence of t.
// You may assume that there is only lower case English letters
// in both s and t. t is potentially a very long (length ~= 500,000)
// string, and s is a short string (<=100).
// A subsequence of a string is a new string which is formed from
// the original string by deleting some (can be none) of the characters
// without distrubing the relative positions of the remaining characters

import java.util.*;

public class IsSubsequence {
    // Create at most 26 different character's position index.
    // So we can quickly find character's appearance position
    protected Map<Integer, List<Integer>> createMap(String str) {
        Map<Integer, List<Integer>> posMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < str.length(); i++) {
           Integer c = Integer.valueOf(str.charAt(i));
           if (posMap.get(c) == null) {
               posMap.put(c, new ArrayList<Integer>());
           }
           posMap.get(c).add(i);
        }
        return posMap;
    }
    // find target's insert position
    protected int binarySearch(List<Integer> elements, int target) {
        if (elements == null) {
            return -1;
        }
        int low = 0;
        int high = elements.size() - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (elements.get(mid) < target) {
                low = mid + 1;
            } else if (elements.get(mid) > target) {
                high = mid -1;
            } else {
                return mid;
            }
        }
        return low;
    }
    public boolean isSubsequence(String sub, String t) {
        Map<Integer, List<Integer>> posMap = this.createMap(t);

        int lowBound = 0;
        for (int i = 0; i < sub.length(); i++) {
            List<Integer> pos = posMap.get(Integer.valueOf(sub.charAt(i)));
            int p = binarySearch(pos, lowBound);
            if (p < 0 || p > pos.size() - 1 ) {
                return false;
            }
            lowBound = pos.get(p) + 1;
        }
        return true;
    }
}
