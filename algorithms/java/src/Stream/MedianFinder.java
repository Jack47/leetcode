package Stream;

import java.util.PriorityQueue;

class MedianFinder {
    // Assumptions:
    // 1. left.size() == right.size()
    //   || left.size() +1 == right.size()
    // 2. left.peek() <= right.peek();
    //   left is max heap
    PriorityQueue<Integer> left;
    // right is min heap
    PriorityQueue<Integer> right;
    int size;
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<Integer>((a, b) -> (b-a));
        right = new PriorityQueue<Integer>();
        size = 0;
    }

    public void addNum(int num) {
        size++;
        // adjust size
        if(left.size() +1 == right.size()){ // add to left
            if(right.size() > 0 && num > right.peek()) { // swap to assure assumptions
                left.add(right.poll());
                right.add(num);
            } else {
                left.add(num);
            }
        } else { // left.size == right.size
            if(left.size() > 0 && num < left.peek()) {
                right.add(left.poll());
                left.add(num);
            } else {
                right.add(num);
            }
        }
    }

    public double findMedian() {
        if(size%2 != 0) {
            return right.peek();
        }
        return ((double)left.peek() + right.peek())/2;
    }
}
