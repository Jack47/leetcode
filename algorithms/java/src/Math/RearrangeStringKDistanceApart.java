package Math;

public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if (s.length() == 1 || k <= 1) return s;

        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        int[] validIndex = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            int cur = findValidMaxFreqChar(i, freq, validIndex);
            if (cur < 0) {
                return "";
            }
            sb.append((char) (cur + 'a'));
            freq[cur]--;
            validIndex[cur] = i + k;
        }
        return sb.toString();
    }

    int findValidMaxFreqChar(int pos, int[] freq, int[] validIndex) {
        int max = Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0 && validIndex[i] <= pos && max < freq[i]) {
                result = i;
            }
        }
        return result;
    }
}
