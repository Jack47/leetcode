#include <stdio.h>
#include <assert.h>

#include <string>

using namespace std;

class Solution {
public:
    string longestPalindrome(const string& s) {
        int max_len_start = -1;
        int max_len;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.size()-1; i++) {
            left = i;
            right = i+1;
            findLongestPalindrome(s, left, right, &max_len, &max_len_start);
            right = i+2;
            if (right < s.size()) {
                findLongestPalindrome(s, left, right, &max_len, &max_len_start);
            }
        }
        return string(s, max_len_start, max_len);
    }
    void findLongestPalindrome(const string& s, int left, int right, int* max_len, int* max_len_start) {
        int len = 0;
        int l = left;
        int r = right;
        while (l >=0 && r < s.size() && s[l] == s[r]) {
            l--;
            r++;
        }
        len = r - l -1;
        if (len > (right-left-1) && len > *max_len) {
            assert(l + 1 >=0 && len <= s.size());
            *max_len = len;
            *max_len_start = l + 1;
        }
    }
};

int main() {
    Solution sol;
    string s1 = "abcdefggfedcba";
    printf("%s\n", sol.longestPalindrome(s1).c_str());
    s1 = "aaa";
    printf("%s\n", sol.longestPalindrome(s1).c_str());
    s1 = "abcba";
    printf("%s\n", sol.longestPalindrome(s1).c_str());
    s1 = "abcdeffed";
    printf("%s\n", sol.longestPalindrome(s1).c_str());            
    return 0;
}
