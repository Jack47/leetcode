package Graph;

import java.util.*;

public class ReconstructItineraryT {
    // store neighbors using PriorityQueue according to lexical order
    HashMap<String, PriorityQueue<String>> adjs;
    List<String> result;

    void dfs(String start) {
        PriorityQueue<String> nbs = adjs.get(start);
        if (nbs != null && nbs.size() > 0) {
            // maybe we don't have opportunity to visit other nbs in dfs
            while (nbs.size() > 0) {
                // poll from adjs
                dfs(nbs.poll());
            }
        }
        result.add(0, start);
    }

    public List<String> findItinerary(String[][] tickets) {
        adjs = new HashMap<>();
        result = new LinkedList<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            PriorityQueue<String> s = adjs.getOrDefault(from, new PriorityQueue<>());
            s.add(to);
            adjs.put(from, s);
        }
        dfs("JFK");
        return result;
    }
}
