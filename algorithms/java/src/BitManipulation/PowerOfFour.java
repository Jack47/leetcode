package BitManipulation;

public class PowerOfFour {
    int MaxPowerOfFour = 1073741824; // 4^15 = 2^30
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;

        //int ret = (int)(Math.log(num)/Math.log(4));
        //return Math.pow(4, ret) == num;
        return num % 4 == 0;
    }
}
