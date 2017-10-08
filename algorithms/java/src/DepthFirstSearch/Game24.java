package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game24 {
    List<List<Double>> permutations;
    List<Double> cur;
    int[] nums;
    boolean[] visited;

    void generatePermutations(int step) {
        if (step == nums.length) {
            permutations.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add((double) nums[i]);
                generatePermutations(step + 1);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }

    boolean valid24(List<Double> p) {
        Double n1 = p.get(0);
        Double n2 = p.get(1);
        Double n3 = p.get(2);
        Double n4 = p.get(3);

        if (valid24(n1 + n2, n3, n4) ||
                valid24(n1 - n2, n3, n4) ||
                valid24(n1 * n2, n3, n4) ||

                n2 != 0 && valid24(n1 / n2, n3, n4) ||
                valid24(n1, n2 + n3, n4) ||
                valid24(n1, n2 - n3, n4) ||
                valid24(n1, n2 * n3, n4) ||
                n3 != 0 && valid24(n1, n2 / n3, n4) ||

                valid24(n1, n2, n3 + n4) ||
                valid24(n1, n2, n3 - n4) ||
                valid24(n1, n2, n3 * n4) ||
                n4 != 0 && valid24(n1, n2, n3 / n4)) {
            return true;
        }
        return false;
    }

    boolean valid24(double n1, double n2, double n3) {
        if (valid24(n1 + n2, n3) ||
                valid24(n1 - n2, n3) ||
                valid24(n1 * n2, n3) ||
                n2 != 0 && valid24(n1 / n2, n3) ||

                valid24(n1, n2 + n3) ||
                valid24(n1, n2 - n3) ||
                valid24(n1, n2 * n3) ||
                n3 != 0 && valid24(n1, n2 / n3)) {
            return true;
        }
        return false;
    }

    boolean valid24(double n1, double n2) {
        if (equals24(n1 + n2) ||
                equals24(n1 - n2) ||
                equals24(n1 * n2) ||
                n2 != 0 && equals24(n1 / n2)) {
            return true;
        }
        return false;
    }

    boolean equals24(double n) {
        return Math.abs(n - 24) <= 1E-4;
    }

    public boolean judgePoint24(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.visited = new boolean[nums.length];
        permutations = new ArrayList<>();
        cur = new ArrayList<>(4);
        generatePermutations(0);
        for (List<Double> p : permutations) {
            if (valid24(p)) {
                return true;
            }
        }
        return false;
    }
}
