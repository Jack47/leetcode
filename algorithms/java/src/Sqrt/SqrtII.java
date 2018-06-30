package Sqrt;

public class SqrtII {
    public int mySqrt(int x) {
        // right =x will cause overflow when calculating power of mid
       //int left = 0, right = (int)Math.sqrt(Integer.MAX_VALUE);
       int left = 0, right = x;
       // answer is in range [left-1, right]
        // so continuing condition is left-1 < right => left <= right
       while(left <= right) {
           int mid = left + (right-left)/2;
           // int pow = mid*mid;
           int remain = x/mid;
           if (remain == x) {
               return mid;
           } else if (remain < x) {
               right = mid -1;
           } else { // [4, 5], x = 17
               left = mid+1;
           }
       }
       return right;
    }
}
