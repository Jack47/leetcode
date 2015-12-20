#include <assert.h>
#include <string.h>
#include <limits.h>

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
/*
    https://www.hackerrank.com/challenges/longest-increasing-subsequent
    O(lgN)的解法
*/
const int kMaxNumberSize = 1000000+1;
int longest[kMaxNumberSize];
int length_lowest_num[kMaxNumberSize];
int end = -1;
/*
  find value in vector num using binary search.
  @param index : if return value is false, index is used to indicate index, where num[index] must < value.
  @return 
 */
bool binarySearch(int* num, int start, int end, int value, int* index) {
    assert(start <= end && start >= 0 && end >= 0);
    while ( start <= end) {
        int mid = start + (end - start)/2;
        if (num[mid] == value) {
            *index = mid;
            return true;
        }
        else if (num[mid] > value) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
    }
    *index = end;
    assert(num[end] < value);
    return false;
}
int findLongestIncreasingSubsequence(const int* number, int len) {
    int max_len = 1;
    int length_lowest_num_count = 1;
    
    for (int i = 1; i <= len; i++) {
        length_lowest_num[i] = INT_MAX;
    }            
    length_lowest_num[1] = number[0];    

    int current_len = 1;
    for (int i = 1; i < len; i++) {
        bool found = false;
        int lower_num_len = length_lowest_num_count;
        // current len may be largger, find the lower num's len
        found = binarySearch(length_lowest_num, 1, length_lowest_num_count, number[i], &lower_num_len);
        if (found) {
            longest[number[i]] = lower_num_len;
        }
        else {
            assert( lower_num_len >=0 && lower_num_len <= length_lowest_num_count);
            if (lower_num_len == 0) {
                current_len = 1;
            }
            else { // lowest number exist, len is the lower number's longest increasing len + 1.
                current_len = lower_num_len + 1;
            }
        }
        longest[i] = current_len;
        if (length_lowest_num[current_len] > number[i]) {
            if (length_lowest_num[current_len] == INT_MAX) {
                ++length_lowest_num_count;
            }
            length_lowest_num[current_len] = number[i];
        }
        if (current_len > max_len) {
            max_len = current_len;
        }
    }
    return max_len;
}

int main() {
    int n;
    scanf("%d", &n);
    int number[n];
    for(int j = 0; j < n; j++) {
        scanf("%d", number+j);
    }
    int len = findLongestIncreasingSubsequence(number, n);
    printf("%d\n", len);

    return 0;
}
