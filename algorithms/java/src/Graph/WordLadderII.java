package Graph;

import java.util.*;

public class WordLadderII {
    List<List<String>> results;
    List<String> result;
    HashMap<String, List<String>> map;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() <= 1) return Collections.emptyList();

        Queue<Integer> q = new LinkedList<>();

        int beginI = wordList.indexOf(beginWord);
        if (beginI < 0) {
            wordList.add(beginWord);
        }
        beginI = wordList.indexOf(beginWord);
        int endI = wordList.indexOf(endWord);
        if (endI < 0) return Collections.emptyList();
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            dict.put(wordList.get(i), i);
        }

        boolean[] visited = new boolean[wordList.size()];
        map = new HashMap<>();
        q.add(beginI);
        results = new LinkedList<List<String>>();

        boolean found = false;
        int step = 0;
        while (!found && !q.isEmpty()) {
            int size = q.size();
            step++;
            while (size > 0) {
                int n = q.poll();
                size--;
                if(visited[n]) continue;
                visited[n] = true;
                if (n == endI) {
                    found = true;
                }
                if (found) continue; // don't need to traverse next depth
                String word = wordList.get(n);
                for (int k = 0; k < word.length(); k++) {
                    StringBuilder sb = new StringBuilder(word);
                    char ch = sb.charAt(k);
                    for (int m = 0; m < 26; m++) {
                        if (ch == m + 'a') continue;
                        sb.setCharAt(k, (char) (m + 'a'));
                        if (dict.containsKey(sb.toString())) {
                            int i = dict.get(sb.toString());
                            if (!visited[i]) {
                                List<String> r = map.getOrDefault(sb.toString(), new ArrayList<>());
                                r.add(word);
                                map.put(sb.toString(), r);
                                q.offer(i);
                            }
                        }
                    }
                }
            }
        }
        result = new ArrayList<>(wordList.size());
        getRoute(endWord, beginWord, step);
        return results;
    }
    void getRoute(String e, String s, int step) {
        if(step <= 0) return;
        result.add(0, e);
        if(s.equals(e)) {
            assert(step == 1);
            results.add(new ArrayList<>(result));
            result.remove(0);
            return;
        }

        for(String a : map.get(e)) {
            getRoute(a, s, step -1);
        }
        result.remove(0);
    }
}
