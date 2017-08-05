package Greedy;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1) return s;
        int[] freq = new int[128];
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        boolean visited[] = new boolean[128];
        StringBuilder sb = new StringBuilder();
        int top = sb.length();
        for (char ch : s.toCharArray()) {
            freq[ch]--;
            if (visited[ch]) continue;
            while (sb.length() > 0 && sb.charAt(top) > ch && freq[sb.charAt(top)] >= 1) {
                char c = sb.charAt(top);
                sb.deleteCharAt(top);
                top = sb.length() -1 ;
                visited[c] = false;
            }
            sb.append(ch);
            top = sb.length() - 1;
            visited[ch] = true;
        }
        return sb.toString();
    }
}
