package BinaryTree;

public class FirstUniqueCharacterInaString {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] freq = new int[128];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch]++;
        }
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(freq[ch] == 1) {
                return i;
            }
        }
        return -1;
    }
}
