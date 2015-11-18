/*
https://leetcode.com/problems/two-sum/
Given an array of integers, find two numbers such that they add up to a specific target numbers
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2 and they are not zero-based.
 */
#include <stdlib.h>


#include <algorithm>
#include <vector>

using namespace std;

struct IntArrayCompare {
public:
    IntArrayCompare(const vector<int>& nums) : _nums(nums) {
    }
    bool operator()(int x, int y) {
        return _nums[x] < _nums[y];
    }
private:    
    const vector<int>& _nums;
};
class Solution {
public:
    vector<int> twoSum(const vector<int>& nums, int target) {
        int numsSize = static_cast<int>(nums.size());
        vector<int> nums_index(0, numsSize-1);
        
        IntArrayCompare compare(nums);
        std::sort(nums_index.begin(), nums_index.end(), compare);
        int right = numsSize-1;
        int left = 0;
        while (nums[nums_index[right]] > target) {
            --right;
        }
        while(left < right && nums[nums_index[right]] + nums[nums_index[left]] != target) {
            while (left < right && nums[nums_index[right]] + nums[nums_index[left]] > target) {
                right--;
            }
            while (left < right && nums[nums_index[right]] + nums[nums_index[left]] < target) {
                left++;
            }        
        }
        vector<int> answer(0,1);
        if (nums_index[right] > nums_index[left]) {
            answer[0] = nums_index[left];
            answer[1] = nums_index[right];
        }
        else {
            answer[0] = nums_index[right];
            answer[1] = nums_index[left];        
        }
    
        return answer;
    }
};


int main() {
    vector<int> nums;
    nums.push_back(3);
    nums.push_back(2);
    nums.push_back(4);

    Solution solution;
    int target = 6;
    vector<int> answer = solution.twoSum(nums, target);
    for (int i = 0; i < static_cast<int>(answer.size()); i++) {
        printf("%d\t", answer[i]);
    }
    printf("\n");
    
    return 0;
}
