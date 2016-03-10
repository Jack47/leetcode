package Combination;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses
 */
public class GenerateParenthesis {
    protected List<String> resultList;
    protected StringBuilder resultBuilder;
    protected int length;

    public GenerateParenthesis() {
        resultList = new ArrayList<String>();
        resultBuilder = new StringBuilder();
    }

    public List<String> generateParenthesis(int n) {
        resultBuilder.setLength(0);
        resultList.clear();
        if (n == 0) return resultList;

        length = 2 * n;
        int leftNum = n;
        int rightNum = 0;
        int currentLength = 0;
        generateParenthesis(leftNum, rightNum, currentLength);
        return resultList;
    }

    protected void generateParenthesis(int leftNum, int rightNum, int currentLength) {
        if (leftNum == 0 && rightNum == 0) {
            assert currentLength == length;
            resultList.add(resultBuilder.toString());
        }
        if (leftNum > 0) {
            resultBuilder.append('(');
            currentLength++;
            generateParenthesis(leftNum - 1, rightNum + 1, currentLength);
            resultBuilder.deleteCharAt(currentLength-1);
            currentLength--;
        }
        if (rightNum > 0) {
            resultBuilder.append(')');
            currentLength++;
            generateParenthesis(leftNum, rightNum - 1, currentLength);
            resultBuilder.deleteCharAt(currentLength-1);
            currentLength--;
        }
    }
}
