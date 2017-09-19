package BinarySearch;

public class GuessNumber {
    // 1 ~ n
    public int guessNumber(int n) {
        int left = 1, right = n;
        int m;
        while(true) {
            m = left + (right-left)/2;
            int result = guess(m);
            if(result == 1) {
                left = m+1;
            } else if (result == -1) {
                right=m-1;
            } else {
                return m;
            }
        }
    }
}
