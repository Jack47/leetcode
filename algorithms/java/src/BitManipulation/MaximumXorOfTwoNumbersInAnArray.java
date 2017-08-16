package BitManipulation;

public class MaximumXorOfTwoNumbersInAnArray {
    class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[2];
        }

        void add(int num) {
            Trie cur = this;
            for (int i = 31; i >= 0; i--) {
                int n = (num & (1 << i)) != 0 ? 1 : 0;
                if (cur.children[n] == null) {
                    cur.children[n] = new Trie();
                }
                cur = cur.children[n];
            }
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            int value = 0;
            Trie cur = root;
            root.add(num);
            for (int i = 31; i >= 0; i--) {
                int n = (num & (1 << i)) != 0 ? 1 : 0;
                if (cur.children[n ^ 1] != null) {
                    cur = cur.children[n ^ 1];
                    value = value | (1 << i);
                } else {
                    cur = cur.children[n];
                }
            }
            max = Math.max(value, max);
        }
        return max;
    }
}
