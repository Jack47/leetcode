package StringRelated;

public class BasicCalculatorIITT {
    public int calculate(String s) {
        int ret = 0;
        int i = 0;
        int prevVal = 0; // 1+3*2*1+1, prevVal in some time will be 3*2*1
        char op = '+';
        // every time we see a number, we operate it according to previous operator
        // if we met the operator, record it and reverse the previous operator
        while (i < s.length()) {
            if ("+-*/".indexOf(s.charAt(i)) >= 0) {
                op = s.charAt(i);
                if ("*/".indexOf(s.charAt(i)) >= 0) {
                    ret -= prevVal; // reverse the previous step
                }
            } else if (Character.isDigit(s.charAt(i))) {
                // operate this num
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = s.charAt(i) - '0' + val * 10;
                    i++;
                }
                if ("+-".indexOf(op) >= 0) { // key point: how to deal with prevVal
                    prevVal = op == '-' ? -val: val;
                    ret += prevVal;
                } else {
                    val = op == '*' ? prevVal * val : prevVal / val;
                    ret += val; // maybe reversed later
                    prevVal = val; // accumulate
                }
                continue; // skip i++;
            } // ignore the white space
            i++;
        }

        return ret;
    }
}
