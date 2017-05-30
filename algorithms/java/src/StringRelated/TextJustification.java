package StringRelated;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/text-justification/
public class TextJustification {
    protected void appendSpace(StringBuilder sb, int num) {
        for (int l = 0; l < num; l++) {
            sb.append(" ");
        }
    }

    public String lastJustify(String[] words, int maxWidth, int start) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for (int i = start + 1; i < words.length; i++) {
            sb.append(" ");
            sb.append(words[i]);
        }
        appendSpace(sb, maxWidth - sb.length());
        return sb.toString();
    }

    public String justify(String[] words, int maxWidth, int spaceLen, int start, int end) {
        StringBuilder sb = new StringBuilder();

        sb.append(words[start]);
        if (end - start == 1) {
            appendSpace(sb, maxWidth - sb.length());
        } else {
            int remainder = spaceLen % (end - start - 1);
            int avg = spaceLen / (end - start - 1);
            for (int i = start + 1; i < end; i++) {
                appendSpace(sb, avg + (remainder > 0 ? 1 : 0));
                sb.append(words[i]);
                remainder--;
            }
        }

        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int totalLen = 0;
        int letterLen = 0;
        int start = 0;
        List<String> ret = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            int delta = i == 0 ? words[i].length() : 1 + words[i].length();
            if ((totalLen + delta <= maxWidth)) {
                totalLen = totalLen + delta;
                letterLen += words[i].length();
            } else { // line formed
                String s = justify(words, maxWidth, maxWidth - letterLen, start, i);
                ret.add(s);
                start = i;
                totalLen = words[i].length();
                letterLen = words[i].length();
            }
        }
        String s = lastJustify(words, maxWidth, start);

        ret.add(s);
        return ret;
    }

}
