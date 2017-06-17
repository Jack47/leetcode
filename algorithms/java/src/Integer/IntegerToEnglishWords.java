package Integer;

public class IntegerToEnglishWords {
    String[] levels = new String[]{"", "Thousand", "Million", "Billion"};
    String[] digits = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine"};
    String[] twoDigits = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    String[] tens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String section(String s, int nth) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (s.length() == 3) { // 123
            int ch = s.charAt(i) - '0';
            if(ch != 0) {
                sb.append(digits[ch]);
                sb.append(" ");
                sb.append("Hundred");
                sb.append(" ");
            }
            i++;
        }
        if (s.length() >= 2) {
            if (s.charAt(i) != '0') {
                int ch = s.charAt(i) - '0';
                if (ch == 1) {
                    i++;
                    ch = s.charAt(i) - '0';
                    sb.append(tens[ch]);
                    sb.append(" ");
                } else {
                    sb.append(twoDigits[ch]);
                    sb.append(" ");
                }
            }
            i++;
        }
        if (s.length() >= 1 && i < s.length() && s.charAt(i) != '0') {
            int ch = s.charAt(i) - '0';
            sb.append(digits[ch]);
            sb.append(" ");
        }
        if (sb.length() > 0 && !levels[nth].isEmpty()) {
            sb.append(levels[nth]);
            sb.append(" ");
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).toString(); // remove
        // ending space
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String s = String.valueOf(num);
        int start = 0;
        int sections = (s.length() + 2) / 3 - 1;
        int len = s.length() - sections * 3;
        StringBuilder sb = new StringBuilder();

        for (int i = sections; i >= 0; i--) {
            String sec = section(s.substring(start, start + len), i);
            if (i != sections && !sec.isEmpty()) sb.append(" ");
            if (!sec.isEmpty()) sb.append(sec);
            start += len;
            len = 3;
        }
        return sb.toString();
    }
}
