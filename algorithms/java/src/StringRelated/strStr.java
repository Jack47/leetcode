package StringRelated;

public class strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if (haystack.isEmpty() && needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (i > haystack.length() - needle.length()) {
                return -1;
            }
            int j = 0;
            int l = i;
            while (j < needle.length() && needle.charAt(j) == haystack.charAt(l)) {
                j++;
                l++;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }
}
