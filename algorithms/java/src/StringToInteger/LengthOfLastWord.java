package StringToInteger;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int i = end;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return end - i;
    }
}
