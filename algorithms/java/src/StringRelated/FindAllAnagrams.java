package StringRelated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] occurrences = new int[128];
        Arrays.fill(occurrences, 0);
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            occurrences[ch]++;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i < s.length() && j < s.length()) {
            // exceed window size
            // or start pos doesn't count
            if (j - i + 1 > p.length() || occurrences[s.charAt(i)] == -1) {
                occurrences[s.charAt(i)]++;
                if (occurrences[s.charAt(i)] > 0) { // needs recovery
                    count--;
                }
                i++;
            }
            occurrences[s.charAt(j)]--;
            if (occurrences[s.charAt(j)] >= 0) {
                count++;
                if (count == p.length() && j - i + 1 == p.length()) {
                    result.add(i);
                }
            }
            j++;
        }
        return result;
    }
}
