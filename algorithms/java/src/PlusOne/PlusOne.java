package PlusOne;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/?sort=hot
 */

public class PlusOne {
    /**
     * A non-negative number represented as an array of digits, plus one to the number.
     * The digits are stored such that the most significant digit is at the head of the list.
     */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }

        }

        int[] ret;
        if (digits[0] == 0) { // most significant digit has carrier
            ret = new int[digits.length + 1];
            System.arraycopy(digits, 0, ret, 1, digits.length);
            ret[0] = 1;
        } else {
            ret = Arrays.copyOf(digits, digits.length);
        }
        return ret;
    }
}
