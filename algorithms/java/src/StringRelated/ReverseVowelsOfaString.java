package StringRelated;

public class ReverseVowelsOfaString {
    private static String Vowels = "aeiouAEIOU";
    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] ret = s.toCharArray();
        while (start < end) {
            while (start < end && Vowels.indexOf(s.charAt(start)) < 0) {
                start++;
            }
            while (start < end && Vowels.indexOf(s.charAt(end)) < 0) {
                end--;
            }
            if (start < end) {
                char c = ret[start];
                ret[start] = ret[end];
                ret[end] = c;
                start++;
                end--;
            }
        }
        return new String(ret);
    }
}
