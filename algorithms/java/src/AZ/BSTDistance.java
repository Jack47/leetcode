package AZ;

import java.util.ArrayList;

public class BSTDistance {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int v) {
            value = v;
            left = right = null;
        }
    }
    public static Node head;
    public static void construct(int[] values, int n) {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }
    public static void insert(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node parent = null;
        Node cur = head;
        while(cur != null) {
            parent = cur;
            if (value < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        cur = new Node(value);
        if (cur.value < parent.value) {
            parent.left = cur;
        } else {
            parent.right = cur;
        }
    }
    public static ArrayList<Integer> findPath(int value) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        Node cur = head;
        while(cur != null && cur.value != value) {
            path.add(cur.value);
            if (value < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return new ArrayList<Integer>();
        }
        path.add(cur.value);
        return path;
    }
    public static int distance(ArrayList<Integer> path1, ArrayList<Integer> path2) {
        if (path1.isEmpty() || path2.isEmpty()) {
            return -1;
        }
        int i = 0;
        for (i = 0; i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i); i++) {
        }
        return (path1.size() - i) + (path2.size() -i );
    }
    public static int bstDistance(int[] values, int n, int node1, int node2) {
        construct(values, n);
        ArrayList<Integer> path1 = findPath(node1);
        ArrayList<Integer> path2 = findPath(node2);
        return distance(path1, path2);
    }
}
