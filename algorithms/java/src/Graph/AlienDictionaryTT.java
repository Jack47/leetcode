package Graph;

import java.util.*;

public class AlienDictionaryTT {
    public String alienOrder(String[] words) {
        Set<Character>[] vectors = new Set[26];
        Set<Character> allChars = new HashSet<>();
        for(int i = 0; i < words.length;i++) {
            for(Character c : words[i].toCharArray()) {
                allChars.add(c);
                if(vectors[c-'a'] == null) {
                    vectors[c-'a'] = new HashSet<>();
                }
            }
        }
        for(int i = 0; i < words.length-1; i++) {
            if(words[i].compareTo(words[i+1]) == 0) {
                continue;
            }
            int k = 0;
            while(k<words[i].length()&& k < words[i+1].length() &&
                    words[i].charAt(k) == words[i+1].charAt(k)) {
                k++;
            }
            if (k == words[i].length() && k < words[i+1].length()) { // words[i] is prefix of words[i+1]
                continue;
            }
            if (k == words[i+1].length() && k < words[i].length()) { // words[i+1] is prefix
                return "";
            }
            // c1 -> c2
            Character c1 = words[i].charAt(k);
            Character c2 = words[i+1].charAt(k);
            // direct cyclic
            if(vectors[c2-'a']!=null && vectors[c2-'a'].contains(c1)) {
                return "";
            }
            vectors[c1-'a'].add(c2);
        }

        int[] indegree = new int[26];
        Deque<Integer> candidates = new ArrayDeque<>();
        for(Set<Character> chs : vectors) {
            if(chs != null) {
                for(Character ch : chs) {
                    indegree[ch-'a']++;
                }
            }
        }
        for(int i = 0; i < indegree.length;i++) {
            if(indegree[i] == 0 && allChars.contains((char)(i+'a'))) { // i+'a' occurred
                candidates.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!candidates.isEmpty()) {
            int i = candidates.poll();
            sb.append((char)(i+'a'));
            for(Character ch : vectors[i]) {
                indegree[ch-'a']--;
                if(indegree[ch-'a'] == 0) {
                    candidates.add(ch-'a');
                }
            }
        }
        if (sb.length() < allChars.size()) { // has cycle
            return "";
        }
        return sb.toString();
    }
}
