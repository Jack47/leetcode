package StringRelated;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for(String s : strs) {
            if(s.equals("..")) {
                if(!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if(!s.isEmpty() && !s.equals(".")) {
                deque.offerLast("/" + s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        if(sb.length() == 0) return "/";
        return sb.toString();
    }
}
