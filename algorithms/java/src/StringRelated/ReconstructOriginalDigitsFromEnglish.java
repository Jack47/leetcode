package StringRelated;

import java.util.Arrays;
// https://leetcode.com/problems/reconstruct-original-digits-from-english/?tab=Description
// Given a non-empty string containing an out-of-order English representation of digits 0-9,
// output the digits in ascending order.
// Input length is less than 50,000
public class ReconstructOriginalDigitsFromEnglish {

    static char[] result = new char[50000 / 3]; // one digit contains at least three chars
    int resultLen = 0;
    // int[] currentDigits stores current numbers of digits
    // num = currentDigits[0] means have `number` 0.
    // remainNumber = currentDigits[27] means total remain number
    protected static int Total_Index = 27;

    protected int[] getCurrentDigits(String s) {
        int[] digits = new int[Total_Index];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            digits[index]++;
        }
        digits[Total_Index - 1] = s.length();
        return digits;
    }

    protected class Fact {
        public Fact(String chars, String uniqueChars, char digit) {
            this.chars = chars;
            this.uniqueChars = uniqueChars;
            this.digit = digit;
        }

        String chars;
        String uniqueChars;
        char digit;
    }

    Fact[] Facts = new Fact[]{
            new Fact("zero", "z", '0'),
            new Fact("eight", "g", '8'),
            new Fact("two", "w", '2'),
            // order is important!!!  6 is before 7.
            new Fact("six", "x", '6'),

            new Fact("seven", "s", '7'),

            new Fact("five", "fv", '5'),
            new Fact("nine", "ie", '9'),
            new Fact("one", "on", '1'),
            new Fact("four", "fr", '4'),
            new Fact("three", "th", '3')};

    protected String formDigit(int[] currentDigits) {
        resultLen = 0;
        for (int j = 0; j < Facts.length && currentDigits[Total_Index - 1] > 0; j++) {
            int minLen = Integer.MAX_VALUE;
            int i;
            for (i = 0; i < Facts[j].uniqueChars.length() && currentDigits[Facts[j].uniqueChars.charAt(i)
                    - 'a'] > 0; i++) {
                if (currentDigits[Facts[j].uniqueChars.charAt(i) - 'a'] < minLen) {
                    minLen = currentDigits[Facts[j].uniqueChars.charAt(i) - 'a'];
                }
            }
            if (i == Facts[j].uniqueChars.length()) {
                for (i = 0; i < Facts[j].chars.length(); i++) {
                    currentDigits[Facts[j].chars.charAt(i) - 'a'] -= minLen;
                    currentDigits[Total_Index - 1] -= minLen;
                    assert(currentDigits[Facts[j].chars.charAt(i) - 'a'] >= 0);
                }
                for (i = 0; i < minLen; i++) {
                    result[resultLen++] = Facts[j].digit;
                }
            }
        }
        char[] ret = Arrays.copyOf(result, resultLen);
        Arrays.sort(ret);
        StringBuilder resultStr = new StringBuilder(ret.length);
        for (int i = 0; i < ret.length; i++) {
            resultStr.append(ret[i]);
        }
        return resultStr.toString();
    }

    public String originalDigits(String s) {
        int[] currentDigits = getCurrentDigits(s);
        return formDigit(currentDigits);
    }
}
