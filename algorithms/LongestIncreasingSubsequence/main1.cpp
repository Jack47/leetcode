#include <string.h>

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
const int kMaxNumberSize = 1000000;
int longest[kMaxNumberSize];
int findLongestIncreasingSubsequence(const int* number, int len) {
    int max_len = 1;

    for (int i = 0; i < len; i++) {
        longest[i] = 1;
    }
    for (int i = 1; i < len; i++) {
        for (int j = i-1; j >=0; j--) {
            if (number[j] < number[i]) {
                if (longest[j] == max_len) {
                    longest[i] = max_len + 1;
                    break;
                }
                else if (longest[j] + 1 > longest[i]) {
                    longest[i] = longest[j] + 1;
                }
            }
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
    for(int j = 0; j < n; j++) {
        scanf("%d", number+j);
    }
    int len = findLongestIncreasingSubsequence(number, n);
    printf("%d\n", len);

    return 0;
}
