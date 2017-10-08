package StringRelated;

public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n2 == 0) return 0;
        int repeate_count = 0;
        int i = 0;
        int j = 0;
        while (n1 > 0) {
            if (s1.charAt(j) == s2.charAt(i)) {
                i++;
                if (i == s2.length()) {
                    i = 0;
                    repeate_count++;
                }
            }
            j++;
            if (j == s1.length()) {
                if (s2.length() == 1) {
                    return repeate_count * n1 / n2;
                }
                n1--;
                j = 0;
            }
        }
        return repeate_count / n2;
    }
}
