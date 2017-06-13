package DesignDataStructure;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> val2loc;
    HashMap<Integer, Integer> loc2val;
    Random random;

    public RandomizedSet() {
        val2loc = new HashMap<Integer, Integer>();
        loc2val = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (val2loc.containsKey(val)) { // already exist
            return false;
        }
        // insert
        int size = val2loc.size();
        val2loc.put(val, size);
        loc2val.put(size, val);

        return true;
    }

    public boolean remove(int val) {
        if (!val2loc.containsKey(val)) {
            return false;
        }
        int pos = val2loc.get(val);
        int lastPos = val2loc.size() - 1;
        int lastVal = loc2val.get(lastPos);
        val2loc.remove(lastVal);
        loc2val.remove(lastPos);

        if (pos != lastPos) { // remove last one
            val2loc.remove(val); // remove val
            val2loc.put(lastVal, pos);
            loc2val.put(pos, lastVal); // override this pos;
        }
        return true;
    }

    public int getRandom() {
        int pos = random.nextInt(val2loc.size());
        return loc2val.get(pos);
    }
}
