package GrayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        result.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i; // prefix
            for (int j = result.size() - 1; j >= 0; j--) { // reflect
                result.add(result.get(j) + inc);
            }
        }
        return result;
    }
}
