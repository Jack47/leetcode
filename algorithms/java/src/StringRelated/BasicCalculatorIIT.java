package StringRelated;

public class BasicCalculatorIIT {
    public int calculate(String s) {
        s = s.replaceAll(" ", ""); // space \s?
        if(s.isEmpty()) {
            return 0;
        }
        int sum = 0;
        int prev = 0;
        int i = 0;
        char op = '+';
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int j = i;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int num = Integer.parseInt(s.substring(j, i));

                if("+-".indexOf(op) >= 0) {
                    if(op == '-') {
                        num = -num;
                    }
                    sum += prev;
                    prev = num;
                } else {
                    if(op == '*') {
                        prev *= num;
                    } else {
                        prev /= num;
                    }
                }
            } else {
                op = s.charAt(i);
            }
            i++;
        }
        sum += prev;
        return sum;
    }
}
