package Greedy;

import java.util.Stack;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> s = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !s.isEmpty() && ch < s.peek()) {
                s.pop();
                k--;
            }
            s.push(ch);
        }
        // 123, k = 1
        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        // remove leading zeros
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0) return "0";
        return sb.reverse().toString();
    }

    public String removeKdigitsEnhancement(String num, int k) {
        if (k == 0) return num;
        if (num.length() == k) {
            return "0";
        }
        char[] result = new char[num.length() - k];
        int len = result.length;
        int top = -1;
        char[] str = num.toCharArray();
        for (int i = 0; i < str.length; i++) {
            while (top >= 0 && str.length - i >= len - top && str[i] < result[top]) {
                top--;
            }
            if (top < len - 1) {
                result[++top] = str[i];
            }
        }

        // remove leading zeros
        int start = 0;
        while (result[start] == '0' && start < result.length - 1) {
            start++;
        }

        return new String(result, start, result.length - start);
    }
}
