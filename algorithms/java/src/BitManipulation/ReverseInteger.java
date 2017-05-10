package BitManipulation;

public class ReverseInteger {
    StringBuilder convert2ReversedStr(int x) {
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append('-');
        }
        x = Math.abs(x);
        while (x != 0) {
            char ch  = (char)(x % 10 + '0');
            sb = sb.append(ch);
            x = x / 10;
        }
        return sb;
    }
    int convert2Int(StringBuilder sb) {
        int i = 0;
        int n = 0;
        boolean isNegative = false;
        if (sb.charAt(0) == '-') {
            isNegative = true;
            i = 1;
        }

        for (; i < sb.length(); i++) {
            n = n * 10 + sb.charAt(i) - '0';
        }
        return isNegative ? -n : n;
    }
    public int reverse(int x) {
        if (x == 0) return 0;

        StringBuilder sb = convert2ReversedStr(x);

        int reversedX = convert2Int(sb);
        StringBuilder originSb = convert2ReversedStr(reversedX);
        int originX = convert2Int(originSb);
        if (originX != x) {
            return 0;
        }
        return reversedX;
    }
}
