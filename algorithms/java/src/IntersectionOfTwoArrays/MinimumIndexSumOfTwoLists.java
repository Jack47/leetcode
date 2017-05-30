package IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        List<String> ret = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            m.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer k = m.get(list2[i]);
            if (k != null) {
                if (k + i < min) {
                    ret.clear();
                    min = k + i;
                    ret.add(list2[i]);
                } else if (k + i == min) {
                    ret.add(list2[i]);
                }
            }
        }
        String[] r = new String[ret.size()];
        return ret.toArray(r);
    }
}
