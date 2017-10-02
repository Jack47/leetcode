package StringRelated;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int count = 1;
        while (count <= B.length() / A.length() + 2) {
            if (sb.indexOf(B) >= 0) return count;
            sb.append(A);
            count++;
        }
        return -1;
    }
}
