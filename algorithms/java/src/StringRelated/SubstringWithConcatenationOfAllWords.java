package StringRelated;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    String s;
    String[] words;
    HashMap<String, Integer> maps;
    int word_len;

    boolean concateable(int i, HashMap<String, Integer> maps) {
        int total_count = 0;
        while (i < s.length() && i <= s.length() - word_len) {
            String str = s.substring(i, i + word_len);
            Integer count = maps.get(str);
            if (count == null || count == 0) {
                return false;
            }
            maps.put(str, count - 1);
            total_count++;
            if (total_count == words.length) {
                return true;
            }
            i += word_len;
        }
        return false;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) return Collections.emptyList();
        this.s = s;
        this.words = words;
        maps = new HashMap<>(words.length);
        List<Integer> result = new LinkedList<>();
        word_len = words[0].length();
        for (String word : words) {
            maps.put(word, maps.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - word_len * words.length; i++) {
            if (concateable(i, new HashMap(maps))) {
                result.add(i);
            }
        }

        return result;
    }
}
