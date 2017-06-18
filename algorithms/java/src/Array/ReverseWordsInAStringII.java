package Array;

public class ReverseWordsInAStringII {
    void reverse(char[] s, int start, int end) {
        int i, j;
        for(i = start, j = end-1; i < j; i++, j--) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
    }
    public void reverseWords(char[] s) {
        if(s == null || s.length == 1) return;
        reverse(s, 0, s.length);
        int i = 0;
        while(i < s.length) {
            int start = i;
            while(i < s.length && s[i] != ' ') {
                i++;
            }
            reverse(s, start, i);
            i++;
        }
    }
}
