package StringRelated;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII {
    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public int calculate(String s) {
        int curVal = 0;
        int preVal = 0;
        int result = 0;
        char op = '+';
        int i = 0;
        while(i < s.length()) {
            if(isDigit(s.charAt(i))) {
                while(i < s.length() && isDigit(s.charAt(i))) {
                    curVal = curVal*10 + s.charAt(i)-'0';
                    i++;
                }
                if ("+-".indexOf(op)>=0) {
                    curVal = op == '-' ? -curVal : curVal;
                    result += preVal;
                    preVal = curVal;
                    curVal = 0;
                } else {
                    if (op == '*') {
                        preVal = preVal*curVal;
                    } else {
                        preVal = preVal/curVal;
                    }
                }
                continue;
            } else if ("+-*/".indexOf(s.charAt(i))>=0) {
                op = s.charAt(i);
            }
            i++;
        }
        return result+preVal;
    }
    public int calculate2(String s) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();

        // First, don't care empty space
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+' ||
                    s.charAt(i) == '-' ||
                    s.charAt(i) == '*' ||
                    s.charAt(i) == '/') {
                // push to stack
                operators.add(s.substring(i, i + 1));
            } else if (isDigit(s.charAt(i))) {
                // consume this number
                int start = i;
                while (i < s.length() && isDigit(s.charAt(i))) {
                    i++;
                }
                operands.add(Integer.parseInt(s.substring(start, i)));
                if (!operators.isEmpty()) {
                    String operator = operators.peek();
                    // priority is higher, so we can compute it
                    if (operator.compareTo("*") == 0 || operator.compareTo("/") == 0) {
                        Integer op2 = operands.pop();
                        Integer op1 = operands.pop();
                        Integer result;
                        if (operator.compareTo("*") == 0) {
                            result = op1 * op2;
                        } else {
                            result = op1 / op2;
                        }
                        operands.push(result);
                        operators.pop();
                    }
                }
                continue;
            }
            i++;
        }
        List<String> operatorList = new LinkedList<String>(operators);
        List<Integer> operandList = new LinkedList<Integer>(operands);
        // there are only '+' and '-' operands left
        while (!operatorList.isEmpty()) {
            Integer op1 = operandList.remove(0);
            Integer op2 = operandList.remove(0);
            String operator = operatorList.remove(0);
            Integer result;
            if (operator.compareTo("+") == 0) {
                result = op1 + op2;
            } else {
                result = op1 - op2;
            }
            operandList.add(0, result);
        }
        return operandList.remove(0);
    }
}
