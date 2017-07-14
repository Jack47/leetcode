package Graph;

import java.util.*;

public class WordLadderIIT {
    List<List<String>> results;
    List<String> result;
    HashMap<String, List<String>> matrix;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return Collections.emptyList();
        results = new LinkedList<>();
        result = new LinkedList<>();
        HashSet<String> dicts = new HashSet<>();
        for (String word : wordList) {
            dicts.add(word);
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        boolean found = false;
        matrix = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            while (size > 0) {
                String w = q.poll();
                size--;
                if (visited.contains(w)) {
                    continue;
                }
                visited.add(w);
                if (w.equals(endWord)) {
                    found = true;
                }
                if (found) {
                    continue;
                }
                for (int i = 0; i < w.length(); i++) {
                    StringBuilder next = new StringBuilder(w);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == w.charAt(i)) continue;
                        next.setCharAt(i, ch);
                        String s = next.toString();
                        if (!visited.contains(s) && dicts.contains(s)) {
                            q.offer(s);
                            List<String> list = matrix.getOrDefault(s, new LinkedList<String>());
                            list.add(w);
                            matrix.put(s, list);
                        }
                    }
                }
            }

            if (found) break;
        }
        findPath(endWord, beginWord, step);
        return results;
    }

    void findPath(String s, String e, int step) {
        result.add(0, s);

        if (s.equals(e) && step == 0) {
            results.add(new LinkedList<>(result));
            result.remove(0);
            return;
        }
        if (step > 0) {
            for (String nb : matrix.get(s)) {
                findPath(nb, e, step - 1);
            }
        }
        result.remove(0);
    }
}
