/* There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log(m+n)).
 */
#include <limits.h>
#include <stdio.h>

#include <vector>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = static_cast<int>(nums1.size() + nums2.size());
        double median = 0;
        if (n%2 == 0) {
            median = (findKth(nums1, 0, nums2, 0, n/2) + findKth(nums1, 0, nums2, 0, n/2+1))/2.0;
        }
        else {
            median = findKth(nums1, 0, nums2, 0, n/2 + 1);
        }
        return median;
    }
    // find kth number in sorted arrays a and b start from aStart and bStart respectively
    int findKth(const vector<int>& a, int aStart, const vector<int>& b, int bStart, int k) {
        if (aStart >= static_cast<int>(a.size())) { // then kth element must in b, and k == 1
            return b[bStart + k - 1];
        }
        if (bStart >= static_cast<int>(b.size())) {
            return a[aStart + k - 1];
        }
        if (k == 1) { // 
            return min(a[aStart], b[bStart]);
        }
        int aMid = INT_MAX;
        int bMid = INT_MAX;
        if (aStart + k/2 -1 < static_cast<int>(a.size())) {
            aMid = a[aStart + k/2 -1];
        }
        if (bStart + k/2 -1 < static_cast<int>(b.size())) {
            bMid = b[bStart + k/2 -1];
        }
        if (aMid > bMid) {
            return findKth(a, aStart, b, bStart + k/2, k - k/2);
        }
        else {
            return findKth(a, aStart + k/2, b, bStart, k - k/2);
        }
    }
};
int main() {
    Solution sol;
    int v1[] = {2,3,4};
    int v2[] = {4,5,6};
    vector<int> nums1(v1, v1 + sizeof(v1)/sizeof(int));
    vector<int> nums2(v2, v2 + sizeof(v2)/sizeof(int));
    double median = sol.findMedianSortedArrays(nums1, nums2);
    printf("%f\n", median);

    int v3[] = {1, 2,3,4};
    int v4[] = {5,6,7,8,9,10,11,12,13};        
    vector<int> nums3(v3, v3 + sizeof(v3)/sizeof(int));
    vector<int> nums4(v4, v4 + sizeof(v4)/sizeof(int));
    median = sol.findMedianSortedArrays(nums3, nums4);
    printf("%f\n", median);

    vector<int> nums5;
    vector<int> nums6;
    nums6.push_back(2);
    nums6.push_back(3);    
    median = sol.findMedianSortedArrays(nums5, nums6);
    printf("%f\n", median);        
    return 0;
}
