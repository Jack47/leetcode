package Combination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    protected List<String> resultList;
    protected final static String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"};

    public LetterCombinationsOfaPhoneNumber() {
        resultList = new ArrayList<String>();
    }

    public List<String> letterCombinations(final String digits) {
        resultList.clear();
        StringBuilder builder = new StringBuilder();
        if (!digits.isEmpty()) {
            combinations(digits, 1, builder);
        }
        return resultList;
    }

    public void combinations(final String digits, int nth, StringBuilder builder) {
        if (nth <= digits.length()) {
            int digit = digits.charAt(nth - 1) - '0';
            for (int i = 0; i < dict[digit].length(); i++) {
                builder.append(dict[digit].charAt(i));
                combinations(digits, nth + 1, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        } else {
            resultList.add(builder.toString());
            return;
        }
    }
}
