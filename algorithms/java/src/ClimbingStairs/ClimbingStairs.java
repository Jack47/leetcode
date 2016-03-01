package ClimbingStairs;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top ?
 */
public class ClimbingStairs {
    // Iterative version will be stack over flow when n is to big, like Short.MAX_VALUE
/*    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) * climbStairs(1) + climbStairs(n - 2) * climbStairs(2);
    }
*/
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int f2 = 2;
        int f1 = 1;
        int num = 0;
        for (int i = 3; i <= n; i++) {
            num = f2 + f1;
            f1 = f2;
            f2 = num;
        }
        return num;
    }
}
