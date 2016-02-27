package MultiplyStrings;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        String result = new String();
        StringBuilder single = new StringBuilder();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        for (int i = 0; i < num1.length(); i++) {
            single.setLength(0);
            single.append(multiply(num2, num1.charAt(i) - '0'));
            single = applyWeight(single, num1.length() - 1 - i);
            result = add(result, single.toString());
        }
        return result;
    }

    public StringBuilder applyWeight(StringBuilder numStr, int pos) {
        if (!numStr.equals("0")) {
            for (int i = 0; i < pos; i++) {
                numStr.append('0');
            }
        }
        return numStr;
    }

    public String multiply(String numStr, int digit) {
        assert (digit >= 0 && digit <= 9);
        StringBuilder result = new StringBuilder();
        int carrier = 0;
        if (digit == 0 || numStr.equals("0")) {
            return "0";
        }
        for (int i = numStr.length()-1; i >= 0; i--) {
            int value = charToInt(numStr.charAt(i)) * digit + carrier;
            carrier = value / 10;
            result.insert(0, value%10);
        }

        if (carrier > 0) {
            result.insert(0, carrier);
        }

        return result.toString();
    }

    public String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carrier = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? charToInt(num1.charAt(i)) : 0;
            int n2 = j >= 0 ? charToInt(num2.charAt(j)) : 0;
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

    public int charToInt(char c) {
        return c - '0';
    }
}
