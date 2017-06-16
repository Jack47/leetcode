package Stack;

import java.util.LinkedList;
// https://leetcode.com/problems/min-stack/#/description

public class MinStack {
    LinkedList<Integer> nums;
    LinkedList<Integer> mins;
    public MinStack() {
        nums = new LinkedList<Integer>();
        mins = new LinkedList<Integer>();
    }
    public void push(int x) {
        nums.offerFirst(x);
        if(mins.isEmpty() || mins.peekFirst() > x) {
            mins.offerFirst(x);
        } else {
            mins.offerFirst(mins.peekFirst());
        }
    }
    public void pop() {
        nums.pollFirst();
        mins.pollFirst();
    }
    public int top() {
        return nums.peekFirst();
    }
    public int getMin() {
        return mins.peekFirst();
    }
}
