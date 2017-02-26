package AddBinary;
// https://leetcode.com/problems/add-digits/?tab=Description
// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

public class AddDigits {
    public int addDigits(int num) {
        if (num <= 9) return num;
        int ret = num % 9;
        return ret == 0 ? 9: ret;
    }
}
