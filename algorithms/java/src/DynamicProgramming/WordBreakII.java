package DynamicProgramming;

import java.util.*;

public class WordBreakII {
    HashSet<String> dict;
    HashMap<String, List<String>> cache;

    List<String> wordBreak(String s) {
        if (s.isEmpty()) return Collections.emptyList();
        if (cache.get(s) != null) {
            return cache.get(s);
        }
        List<String> result = new ArrayList<>();
        if (dict.contains(s)) result.add(s); // whole string

        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(i);
            if (dict.contains(str)) {
                List<String> r = wordBreak(s.substring(0, i));
                if (!r.isEmpty()) { // we can find a way
                    for (String t : r) {
                        result.add(t + " " + str);
                    }
                }
            }
        }
        cache.put(s, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>();
        cache = new HashMap<>();

        for (String str : wordDict) {
            dict.add(str);
        }
        return wordBreak(s);
    }
}
