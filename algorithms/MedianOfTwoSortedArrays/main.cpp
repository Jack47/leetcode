/* There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log(m+n)).
 */
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int len = nums1.size() + nums2.size();
        int index = len/2;
        int num1 = 0;
        int num2 = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < nums1.size() && j < nums2.size()) {
            while(i < nums1.size() && nums1[i] < nums2[j]) {
                ++i;
                ++count;
                if (num
            }
            while(j < nums2.size() && nums2[j] < nums1[i]) {
                ++j;
                ++count;
            }
        }
    }
};
