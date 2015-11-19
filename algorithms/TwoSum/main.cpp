/*
https://leetcode.com/problems/two-sum/
Given an array of integers, find two numbers such that they add up to a specific target numbers
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2 and they are not zero-based.
 */
#include <assert.h>
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
        vector<int> nums_index;
        nums_index.resize(numsSize);
        for (int i = 0; i < numsSize; i++) {
            nums_index[i] = i;
        }
        IntArrayCompare compare(nums);
        std::sort(nums_index.begin(), nums_index.end(), compare);
        int right = numsSize-1;
        int left = 0;

        while (left < right && nums[nums_index[right]] + nums[nums_index[left]] > target) {
            --right;
        }
        while(left < right && nums[nums_index[right]] + nums[nums_index[left]] < target) {
            left++;
        }
        assert(nums[nums_index[right]] + nums[nums_index[left]] == target);
        vector<int> answer(2,1);
        if (nums_index[right] > nums_index[left]) {
            answer[0] = nums_index[left] + 1;
            answer[1] = nums_index[right] + 1;
        }
        else {
            answer[0] = nums_index[right] + 1;
            answer[1] = nums_index[left] + 1;        
        }
    
        return answer;
    }
};


int main() {
    vector<int> nums(100);
    int number[] = {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
    nums.assign(number, number+100);
    Solution solution;
    int target = 542;
    vector<int> answer = solution.twoSum(nums, target);
    for (int i = 0; i < static_cast<int>(answer.size()); i++) {
        printf("%d\t", answer[i]);
    }
    printf("\n");
    
    return 0;
}
