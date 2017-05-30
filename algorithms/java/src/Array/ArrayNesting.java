package Array;
// https://leetcode.com/contest/leetcode-weekly-contest-34/problems/array-nesting/

public class ArrayNesting {
    protected int findLen(int[] nums, int start, boolean visited[]) {
        int next = start;
        int len = 0;
        do {
            visited[next] = true;
            next = nums[next];
            len++;
        }
        while(!visited[next]);
        return len;
    }
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean visited[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int m = findLen(nums, i, visited);
                if (m > max) {
                    max = m;
                }
            }
        }
        return max;
    }
}
