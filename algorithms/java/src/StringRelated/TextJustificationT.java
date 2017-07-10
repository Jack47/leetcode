package StringRelated;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationT {

    List<String> results;
    String[] words;

    public List<String> fullJustify(String[] words, int maxWidth) {
        results = new ArrayList<>();
        this.words = words;
        int j = 0;
        while (j < words.length) {
            int start = j;
            int len = words[j].length();
            while (len < maxWidth && j < words.length - 1) {
                if (len + 1 + words[j + 1].length() <= maxWidth) {
                    j++;
                    len += 1 + words[j].length();
                } else {
                    break;
                }
            }
            if (j < words.length - 1) {
                fillOneLine(start, j + 1, maxWidth - len);
            } else {
                fillLastLine(start, maxWidth);
            }
            j++;
        }
        return results;
    }

    void fillLastLine(int start, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        if (sb.length() <= maxWidth) {
            int delta = maxWidth - sb.length();
            while (delta > 0) {
                sb.append(" ");
                delta--;
            }
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        results.add(sb.toString());
    }

    void fillOneLine(int start, int end, int extraSpace) {
        StringBuilder sb = new StringBuilder();
        if (end == start + 1) {
            sb.append(words[start]);
            while (extraSpace > 0) {
                sb.append(" ");
                extraSpace--;
            }
            results.add(sb.toString());
            return;
        }

        int n = extraSpace % (end - start - 1);
        int spaces = extraSpace / (end - start - 1);
        sb.append(words[start]);
        for (int i = start + 1; i < end; i++) {
            int spacesNumber = 1 + spaces + (n > 0 ? 1 : 0);
            while (spacesNumber > 0) {
                sb.append(" ");
                spacesNumber--;
            }
            n--;
            sb.append(words[i]);
        }
        results.add(sb.toString());
    }
}
