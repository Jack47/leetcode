package Greedy;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        // add index
        for(int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            if(ch == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        // mimic the process
        while(r.size()> 0 && d.size() > 0) {
            int i = r.poll();
            int j = d.poll();
            if(i < j) { // i can kill j and survive
                r.offer(i+senate.length());
            } else {
                d.offer(j+senate.length());
            }
        }
        if(r.size() > 0) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}
