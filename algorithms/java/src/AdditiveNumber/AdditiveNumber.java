package AdditiveNumber;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;

        for (int num1Len = 1; num1Len <= (num.length() - 1) / 2; num1Len++) {
            for (int num2Len = 1; num2Len <= num.length() - num1Len - 1; num2Len++) {
                if (2 * num1Len + num2Len > num.length() || 2 * num2Len > num.length()) {
                    break;
                }
                if (isAdditiveNumber(num, num1Len, num2Len)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num, int len1, int len2) {
        assert len1 >= 1;
        assert len2 >= 1;

        String num1 = num.substring(0, len1);
        String num2 = num.substring(len1, len1 + len2);
        String sum = add(num1, num2);

        int offset = num1.length() + num2.length();
        int untouchedLength = num.length() - offset;

        while (untouchedLength > 0 && sum.length() <= untouchedLength) {
            String num3 = num.substring(offset, offset + sum.length());
            if (!sum.equals(num3)) {
                return false;
            }
            offset += sum.length();
            num1 = num2;
            num2 = num3;

            untouchedLength = num.length() - offset;
            sum = add(num1, num2);
        }
        return untouchedLength == 0 ? true : false;
    }

    public String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carrier = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? Character.digit(num1.charAt(i), 10) : 0;
            int n2 = j >= 0 ? Character.digit(num2.charAt(j), 10) : 0;
            int sum = n1 + n2 + carrier;
            carrier = sum / 10;
            result.insert(0, sum % 10);
            i--;
            j--;
        }
        if (carrier > 0) {
            result.insert(0, carrier);
        }

        return result.toString();
    }
}
