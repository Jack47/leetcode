package StringRelated;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public void add(NestedInteger nestedInteger) {
        if (this.list != null) {
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer) {
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public String printNi(NestedInteger thisNi, StringBuilder sb) {
        if (thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for (NestedInteger ni : thisNi.list) {
            if (ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            } else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

public class MiniParserT {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        NestedInteger root = new NestedInteger();
        NestedInteger cur = root;
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(cur);
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                cur = new NestedInteger();
                stack.peek().add(cur);
                stack.push(cur);
            } else if (s.charAt(i) == ']') {
                stack.pop();
            } else if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                int j = i;
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                cur = new NestedInteger(Integer.parseInt(s.substring(j, i)));
                stack.peek().add(cur);
            }
            i++;
        }

        return root;
    }
}
