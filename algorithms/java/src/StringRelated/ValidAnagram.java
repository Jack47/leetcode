package StringRelated;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Integer value = occurences.get((int)s.charAt(i));
            if (value == null) {
                occurences.put((int) s.charAt(i), 1);
            } else {
                occurences.put((int) s.charAt(i), value + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Integer value = occurences.get((int)t.charAt(i));
            if (value == null || value == 0) return false;
            occurences.put((int) t.charAt(i), value - 1);
        }
        return true;
    }
}
