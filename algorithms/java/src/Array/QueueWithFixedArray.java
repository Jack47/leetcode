package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Design a Queue with ArrayList
// ArrayList size must be at most 10
public class QueueWithFixedArray {
    int fixedSize;
    // maintain this lists to contain the current elements
    List<List<Integer>> lists;
    int head;
    public QueueWithFixedArray(int fixedSize) {
        this.fixedSize = fixedSize;
        head = 0;
        lists = new LinkedList<>();
        lists.add(new ArrayList<>(fixedSize));
    }

    public void offer(int num) {
        lists.get(lists.size()-1).add(num);
        if(lists.get(lists.size()-1).size() == fixedSize) {
            lists.add(new ArrayList<>(fixedSize));
        }
    }
    public Integer poll() {
        if(head == 0 && lists.get(0).size() == 0) return null;
        int e = lists.get(0).get(head);
        head++;
        if(head == fixedSize) {
            lists.remove(0); // remove this empty list
            head = 0;
        }
        return e;
    }

    public int size() {
        if (lists.size() == 1) {
            return lists.get(0).size()-head;
        } else if(lists.size() == 2) {
            return lists.get(0).size()-head + lists.get(1).size();
        } else {
            return lists.get(0).size()-head + (lists.size()-2)*fixedSize + lists.get(lists.size()-1).size();
        }
    }
}
