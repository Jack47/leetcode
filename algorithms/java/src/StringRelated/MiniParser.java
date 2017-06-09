package StringRelated;

import java.util.ArrayList;
import java.util.List;

class NestedInteger {
    int value;
    boolean hasInteger;
    List<NestedInteger> nestedIntegerList;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return hasInteger;
    }

    public void setInteger(int value) {
        this.hasInteger = true;
        this.value = value;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
// Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        nestedIntegerList = new ArrayList<NestedInteger>();
        nestedIntegerList.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
// Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return nestedIntegerList;
    }
}

public class MiniParser {
    public NestedInteger deserialize(String s) {
        int i = 0;
        int start = -1;
        NestedInteger head = new NestedInteger();
        NestedInteger cur = head;
        int value = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                NestedInteger t = new NestedInteger();
                cur.add(t);
                cur = t;
            } else if (s.charAt(i) != ']' && s.charAt(i) != ',') {// begin of current number
                start = i;
                while (i < s.length() && s.charAt(i) != '[' && s.charAt(i) != ']' && s.charAt(i)
                        != ',') {
                    i++;
                }
                value = Integer.valueOf(s.substring(start, i));
                cur.setInteger(value);
                continue;
            }
            i++;
        }

        return head;
    }
}
