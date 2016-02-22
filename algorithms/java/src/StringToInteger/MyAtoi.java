package StringToInteger;

public class MyAtoi {
    public static final int INTEGER_MAX_VALUE = 0x7FFFFFFF;
    public static final int INTEGER_MIN_VALUE = 0x80000000;

    public int myAtoi(String str) {
        boolean isNegative = false;
        long num = 0;
        int i = 0;
        // discard as many leading whitespace characters as necessary until the first
        // non-whitespace character
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }

        // optional initial plus sign or minus sign
        if (i < str.length()) {
            if (str.charAt(i) == '-') {
                isNegative = true;
                i++;
            } else if (str.charAt(i) == '+') {
                i++;
            }
        }

        // followed by as many digits as possible
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            num = num * 10 + str.charAt(i) - '0';
            if (!isNegative && num > INTEGER_MAX_VALUE) {
                return INTEGER_MAX_VALUE;
            } else if (isNegative && num > INTEGER_MAX_VALUE + 1L) {
                return INTEGER_MIN_VALUE;
            }
            i++;
        }

        // discard
        if (isNegative) return -(int) num;
        else return (int) num;
    }
}
