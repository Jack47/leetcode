package BitManipulation;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        int Max3Power = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3)));
        return n > 0 && Max3Power % n == 0;
    }
}
