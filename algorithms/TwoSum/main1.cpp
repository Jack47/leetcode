#include<unordered_map>
#include<vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> nums_map;
        nums_map.reserve(nums.size());
        vector<int> answer(2);
        
        for (int i = 0; i < static_cast<int>(nums.size()); i++) {
            int another_num = target - nums[i];            
            if (nums_map.find(another_num) != nums_map.end()) {
                answer[0] = nums_map[another_num] + 1;
                answer[1] = i + 1;
                break;
            }
            else {
                nums_map[nums[i]] = i;
            }
        }

        return answer;
    }
};
int main() {
    vector<int> nums;
    nums.push_back(0);
    nums.push_back(4);
    nums.push_back(3);
    nums.push_back(0);
    
    Solution solution;
    int target = 0;
    vector<int> answer = solution.twoSum(nums, target);
    for (int i = 0; i < static_cast<int>(answer.size()); i++) {
        printf("%d\t", answer[i]);
    }
    printf("\n");
    
    return 0;
}
