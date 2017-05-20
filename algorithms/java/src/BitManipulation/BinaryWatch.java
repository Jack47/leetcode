package BitManipulation;

import java.util.*;

public class BinaryWatch {
    Map<Integer, List<String>> results;
    int numberOf1Bits(int n) {
        int c = 0;
        while(n!=0) {
            c++;
            n = n & (n-1);
        }
        return c;
    }
    BinaryWatch() {
        results = new HashMap<Integer, List<String>>();
        for (int hour = 0; hour <= 11; hour++) {
            for (int minute = 0; minute <= 59; minute++) {
                StringBuilder sb = new StringBuilder();
                Formatter fmt = new Formatter(sb);
                fmt.format("%d:%02d", hour, minute);
                int digits = numberOf1Bits(hour) + numberOf1Bits(minute);
                if (results.get(digits) == null) {
                    results.put(digits, new ArrayList<String>());
                }
                results.get(digits).add(sb.toString());
            }
        }
    }
    public List<String> readBinaryWatch(int num) {
        List<String> ret = results.get(num);
        return ret != null ? ret : Collections.<String>emptyList();
    }
//    public List<String> readBinaryWatch1(int num) {
//        if (num >= 9) {
//            return Collections.<String>emptyList();
//        }
//        for (int i = 0; i <= num; i++) {
//            int[] hours  = getHours(i);
//            int[] minutes = getMinutes(num-i);
//        }
//    }
    int[] Hours = {8, 4, 2, 1};
    boolean[] hourExist = {false, false, false, false};
    List<Integer> hours = new ArrayList<Integer>();
    int hour = 0;
    List<Integer> getHours(int num) {
        getHoursHelper(num);
        return hours;
    }
    void getHoursHelper(int num) {
        if (num == 0) {
            hours.add(hour);
            return;
        }
        for (int i = 0; i < Hours.length; i++) {
            if (!hourExist[i]) {
                hourExist[i] = true;
                hour += Hours[i];
                getHoursHelper(num--);

                hour -= Hours[i];
                hourExist[i] = false;
            }
        }
    }
}
