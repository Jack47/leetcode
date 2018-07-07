package StringRelated;

public class OneEditDistanceT {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()) { // isOneReplace
            int diffCount = 0;
            for(int i = 0; i < s.length();i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    diffCount++;
                    if(diffCount > 1) {
                        return false;
                    }
                }
            }
            return diffCount == 1;
        } else { // isOneDelete
            String r = s;
            if(s.length() > t.length()) {
                s = t;
                t = r;
            }
            // assumption: s.length() < t.length();
            StringBuilder sb = new StringBuilder(t);
            for(int i = 0; i < t.length(); i++) {
                char ch = sb.charAt(i);
                sb.deleteCharAt(i);
                if(s.equals(sb.toString())) {
                    return true;
                }
                sb.insert(i, ch);
            }
            return false;
        }
    }

    // assumption: s.length() < t.length()
    public boolean isOneDelete(String s, String t) {
        int i = 0;
        while(i< s.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        if(i == s.length()) return false;
        return s.substring(i).equals(t.substring(i+1));
    }
}
