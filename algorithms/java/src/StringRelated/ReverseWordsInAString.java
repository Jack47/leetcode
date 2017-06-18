package StringRelated;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        if(words.length == 0) return "";
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1); // remove ending space
    }
}
