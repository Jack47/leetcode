package Sqrt;

public class Sqrt {
    protected static int powTable[];

    static {
        powTable = new int[2 << 15];
        for (int i = 0; i < powTable.length; i++) {
            powTable[i] = i * i;
        }
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        return binarySearch(powTable, 1, x < powTable.length - 1 ? x : powTable.length - 1, x);

    }

    /**
     * try to find num in a sorted array. array index is [start, end]
     *
     * @param nums
     * @param start
     * @param end
     * @return if found num, return num, else return the nearest lower number
     */
    protected int binarySearch(int[] nums, int start, int end, int num) {

        while (start <= end) {
            int median = start + (end - start) / 2;
            if (nums[median] == num) {
                return median;
            } else if (nums[median] < num) {
                start = median + 1;
            } else {
                end = median - 1;
            }
        }
        return end;
    }
}
