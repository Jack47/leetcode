package Graph;

import java.util.*;

public class FriendShip {
    int parseID(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) != ',') {
            i++;
        }
        return Integer.parseInt(s.substring(0, i));
    }

    /*
    # 1: 2, 3
    # 2: 1, 4
    # 3: 1
    # 4: 2
    # 6: None
     */
    void findFriends(String[] neighborsInput, String[] friendshipsInput) {
        TreeMap<Integer, LinkedHashSet<Integer>> matrix = new TreeMap<>();
        for(String n : neighborsInput) {
            int id = parseID(n);
            matrix.put(id, new LinkedHashSet<>());
        }
        for(String friends : friendshipsInput) {
            List<Integer> fs = parseFriends(friends);
            Integer src = fs.get(0);
            Integer dst = fs.get(1);
            matrix.get(src).add(dst);
            matrix.get(dst).add(src);
        }
        for(Map.Entry<Integer, LinkedHashSet<Integer>> entry : matrix.entrySet()) {
            System.out.printf("%d:", entry.getKey());
            StringBuilder s = new StringBuilder();
            for(Integer f : entry.getValue()) {
                s.append(" "+f+",");
            }
            if (s.length() > 0) {
                s.deleteCharAt(s.length() - 1);
                System.out.printf("%s\n", s.toString());
            } else {
                System.out.printf(" None\n");
            }
        }
    }

    List<Integer> parseFriends(String friends) {
        String[] f = friends.split(",");
        List<Integer> ret = new ArrayList<>(f.length);
        for(String s : f) {
            ret.add(Integer.parseInt(s));
        }
        return ret;
    }
}
