package StringRelated;

public class BasicCalculator {
    int i;
    public int calculate(String s) {
        i = 0;
        return cal(s);
    }

    public int cal(String s) {
        if (i == s.length()) return 0;
        int curVal = 0;
        int result = 0;
        char op = '+';
        while (i < s.length()) {
            if (isDigit(s.charAt(i))) {
                while (i < s.length() && isDigit(s.charAt(i))) {
                    curVal = curVal * 10 + s.charAt(i) - '0';
                    i++;
                }
                curVal = op == '-' ? -curVal : curVal;
                result += curVal;
                curVal = 0;
                continue;
            } else if ("+-".indexOf(s.charAt(i)) >=0) {
                op = s.charAt(i);
            } else if(s.charAt(i) == '(') {
                i++;
                curVal = cal(s);
                curVal = op == '-' ? -curVal : curVal;
                result += curVal;
                curVal = 0;
            } else if(s.charAt(i) == ')') {
                return result;
            }
            i++;
        }
        return result;
    }

    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
