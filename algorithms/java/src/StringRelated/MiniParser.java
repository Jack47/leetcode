package StringRelated;

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
