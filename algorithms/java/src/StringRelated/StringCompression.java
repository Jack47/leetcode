package StringRelated;

public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int len = 0;
        int i = 0;
        while(i < chars.length) {
            char ch = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == ch) {
                i++;
                count++;
            }
            len += count == 1 ? count : 1 + Integer.toString(count).length();
        }
        return len;
    }
}
