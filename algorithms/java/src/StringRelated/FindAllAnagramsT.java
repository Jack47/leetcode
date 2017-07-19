package StringRelated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllAnagramsT {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        int[] freqs = new int[26];
        int distinctNum = 0;
        for(char ch : p.toCharArray()) {
            if(freqs[ch-'a'] == 0) {
                distinctNum++;
            }
            freqs[ch-'a']++;
        }
        int i = 0, j = 0;
        while(i < s.length() && j < s.length()) {
            while(j-i >= p.length()) {
                char ch = s.charAt(i);
                if(freqs[ch-'a'] == 0) distinctNum++;
                freqs[ch-'a']++;
                i++;
            }
            char c = s.charAt(j);
            freqs[c-'a']--;
            if(freqs[c-'a'] == 0) {
                distinctNum--;
            }
            if(j-i == p.length()-1 && distinctNum == 0) {
                result.add(i);
            }
            j++;
        }
        return result;
    }
}
