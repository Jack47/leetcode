package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    //    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        Arrays.sort(arr, new Comparator<int>(){
//            @Override
//            public int compare(int o1, int o2) {
//                int a = Math.abs(o1-x);
//                int b = Math.abs(o2-x);
//                if(a == b) {
//                    return o1-o2;
//                }
//                return a-b;
//            }
//        });
//
//    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int i = Arrays.binarySearch(arr, x);
        if (i < 0) {
            i = -i - 1;
        }
        int l = i - 1, r = i;
        int count = 0;
        while (count < k && (l >= 0 || r < n)) {
            count++;
            if (r >= n || l >= 0 && (x - arr[l] <= arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int j = l + 1; j < r; j++) {
            result.add(arr[j]);
        }
        return result;
    }
}
