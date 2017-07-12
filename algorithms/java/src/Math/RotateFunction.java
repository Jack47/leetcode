package Math;

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int f = 0;
        for(int i = 0; i < A.length; i++) { // calculate f0
            sum += A[i];
            f += i*A[i];
        }
        int max = f;
        for(int n = A.length-1; n >= 1; n--) { // calculate f1 ~ fn-1
            f = f + sum - A.length * A[n];
            max = Math.max(max, f);
        }

        return max;
    }
}
