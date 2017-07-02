package StringRelated;

public class OneEditDistance {
    boolean isOneModify(String s, String t) {
        assert(s.length() == t.length());
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                count++;
            }
            i++;
            if(count > 1) return false;
        }
        return count == 1;
    }
    boolean isOneDel(String s, String t) {
        assert(s.length() > t.length());
        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) != t.charAt(j)) {
                return s.substring(i+1).equals(t.substring(j));
            }
            i++;
            j++;
        }

        return true;
    }
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()) {
            return isOneModify(s, t);
        }
        if(Math.abs(s.length()-t.length()) != 1) return false;


        return false;
    }
}
