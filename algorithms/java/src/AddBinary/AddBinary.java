package AddBinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        int maxLen = a.length() > b.length() ? a.length() : b.length();

        StringBuilder builder = new StringBuilder(maxLen + 1);
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carrier = 0;
        while (i >= 0 && j >= 0) {
            int num = a.charAt(i) - '0' + b.charAt(j) - '0' + carrier;
            if (num >= 2) {
                carrier = num / 2;
                num = num % 2;
            } else {
                carrier = 0;
            }
            builder.insert(0, num);
            i--;
            j--;
        }
        if (j >= 0) {
            a = b;
            i = j;
        }
        while (i >= 0) {
            int num = a.charAt(i) - '0' + carrier;
            if (num >= 2) {
                num = 0;
                carrier = 1;
            } else {
                carrier = 0;
            }
            builder.insert(0, num);
            i--;
        }
        if (carrier == 1) {
            builder.insert(0, '1');
        }
        return builder.toString();
    }
}
