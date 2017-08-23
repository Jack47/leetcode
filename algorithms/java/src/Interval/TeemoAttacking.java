package Interval;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        int ending = 0;
        for(int cur : timeSeries) {
            if(cur >= ending) {
                count += duration;
                ending = cur+duration;
            } else if (cur+duration > ending) {
                count += cur+duration-ending;
                ending = cur+duration;
            }
        }
        return count;
    }
}
