package LinkedList;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int i = 0;
        int j = 0;

        while(i < s1.length || j < s2.length){
            int n1 = Integer.parseInt(i < s1.length ? s1[i] : "0");
            int n2 = Integer.parseInt(j < s2.length ? s2[j] : "0");
            if(n1 != n2) {
                return n1 > n2 ? 1 : -1;
            }
            i++;
            j++;
        }

        return 0;
    }
}
