package Graph;

import java.util.*;

public class ReconstructItinerary {
    HashMap<String, PriorityQueue<String>> matrix;
    List<String> result;

    void visit(String start) {
        while (matrix.containsKey(start) && matrix.get(start).size() > 0) { // visit according to lexical order
            String nb = matrix.get(start).poll();
            visit(nb);
        }
        result.add(0, start); // insert it after we visited all it's neighbours
    }

    public List<String> findItinerary(String[][] tickets) {
        if (tickets.length == 0) return Collections.emptyList();
        matrix = new HashMap<>();
        for (String[] ts : tickets) {
            PriorityQueue<String> nbs = matrix.getOrDefault(ts[0], new PriorityQueue<>());
            nbs.add(ts[1]);
            matrix.put(ts[0], nbs);
        }
        visit("JFK");
        return result;
    }
}
