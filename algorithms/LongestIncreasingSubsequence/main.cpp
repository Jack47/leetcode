#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
/*
  https://www.hackerrank.com/challenges/longest-increasing-subsequent
 */
int findLongestIncreasingSubsequence(const int* number, int len) {
    int longest[len];
    longest[0] = 1;
    int max_len = 1;
    
    for (int i = 1; i < len; i++) {
        int j = i-1;
        while (j >= 0 && number[j] >= number[i]) {
            j--;
        }
        if (j >= 0) {
            longest[i] = longest[j] + 1;
        }
        else {
            longest[i] = 1;
        }
        if (longest[i] > max_len) {
            max_len = longest[i];
        }
    }
    return max_len;
}
int main() {
    int n;
    scanf("%d", &n);
    int number[n];
    for(int i = 0; i < n; i++) {
        scanf("%d", number+i);
    }
    int len = findLongestIncreasingSubsequence(number, n);
    printf("%d\n", len);
    
    return 0;
}
