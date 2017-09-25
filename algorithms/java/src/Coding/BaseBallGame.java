package Coding;

import java.util.TreeSet;

public class BaseBallGame {
    public int calPoints(String[] ops) {
        int[] stack = new int[ops.length];
        int top = 0;

        for(String op : ops) {
            // indexOf('' or "") contains
            if("CD+".indexOf(op) >= 0) {
                if(op.equals("C")) {
                    top--;
                }
                if(op.equals("D")) {
                    int v = 2*stack[top-1];
                    stack[top++] = v;
                }
                if(op.equals("+")) {
                    int v = stack[top-1]+stack[top-2];
                    stack[top++] = v;
                }
            } else {
                stack[top++] = Integer.parseInt(op);
            }
        }
        int sum = 0;
        for(int i = 0; i < top; i++) {
            sum+=stack[i];
        }
        return sum;
    }
}
