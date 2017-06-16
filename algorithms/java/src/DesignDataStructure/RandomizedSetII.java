package DesignDataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSetII {
    HashMap<Integer, HashSet<Integer>> val2loc;
    HashMap<Integer, Integer> loc2val;
    Random random;

    public RandomizedSetII() {
        val2loc = new HashMap<Integer, HashSet<Integer>>();
        loc2val = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean alreadyContain = true;
        if (val2loc.get(val) == null) {
            HashSet<Integer> set = new HashSet<Integer>();
            val2loc.put(val, set);
        }
        if(val2loc.get(val).size() == 0) {
            alreadyContain = false;
        }
        HashSet<Integer> set = val2loc.get(val);
        int loc = loc2val.size();
        set.add(loc);
        loc2val.put(loc, val);
        return !alreadyContain;
    }

    public boolean remove(int val) {
        HashSet<Integer> set = val2loc.get(val);
        if (set == null || set.isEmpty()) {
            return false;
        }
        int lastPos = loc2val.size() - 1;
        int lastVal = loc2val.get(lastPos);
        // remove lastPos
        loc2val.remove(lastPos);
        val2loc.get(lastVal).remove(lastPos);
        // switch lastVal to val's pos
        if (lastVal != val) {
            int pos = set.iterator().next();
            loc2val.put(pos, lastVal);
            set.remove(pos);
            val2loc.get(lastVal).add(pos);
        }
        return true;
    }
    public int getRandom() {
        int pos = random.nextInt(loc2val.size());
        return loc2val.get(pos);
    }
}
