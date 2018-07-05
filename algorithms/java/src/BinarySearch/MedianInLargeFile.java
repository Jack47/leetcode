package BinarySearch;

public class MedianInLargeFile {
    class MinMax {
        int min;
        int max;
    }
    // assume the file is too large to store in
    // memory, so we need to read the file piece by piece
    double findMedian(int[] nums) {
       MinMax minMax = new MinMax();
       minMax(nums, minMax);
       // median must in [min, max]
       int min = minMax.min, max = minMax.max;
       double median = 0;
       while(min < max) {
           median = min + (max-min)/2;
           int leftCount = 0, rightCount = 0;
           for(int num : nums) {
               if(num < median) {
                   leftCount++;
               } else if(num > median) {
                   rightCount++;
               }
           }
           if(leftCount == rightCount || Math.abs(leftCount-rightCount) == 1){
               break;
           } else if (leftCount < rightCount) {
               min = (int)median+1;
           } else {
               max = (int)median-1;
           }
       }
       int left = nums[0]; // find the nearest num that is <= median
       int right = nums[0]; // find the nearest num that is >= median

       for(int num : nums) {
           if(num <= median && (median-num) < (median-left)) {
              left = num;
           }
           if(num >= median && (num-median) < (right-median)) {
               right = num;
           }
       }
       if(nums.length%2 == 0) {
           return ((double)left+right)/2.0;
       } else {
           return (right-median) < (median-left) ? right : left;
       }
    }
    // find min in large file
    // time complexity: O(n)
    void minMax(int[] nums, MinMax minMax){
        int min = nums[0];
        int max = nums[0];
        for(int num : nums) {
            if(num < min) {
                min = num;
            }
            if(num > max) {
                max = num;
            }
        }
        minMax.min = min;
        minMax.max = max;
    }
}
