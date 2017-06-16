package StringRelated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    String sort(String s) {
        char[] chars = new char[26];
        for (char ch : s.toCharArray()) {
            chars[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            while (chars[i] > 0) {
                sb.append(i + 'a');
                chars[i]--;
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String s = sort(strs[i]);
            if (anagrams.get(s) == null) {
                anagrams.put(s, new ArrayList<String>());
            }
            anagrams.get(s).add(strs[i]);
        }
        List<List<String>> ret = new ArrayList<List<String>>();
        for (String key : anagrams.keySet()) {
            ret.add(anagrams.get(key));
        }
        return ret;
    }
}
