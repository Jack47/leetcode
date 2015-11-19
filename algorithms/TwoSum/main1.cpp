#include<unordered_map>
#include<vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> nums_map;
        nums_map.reserve(nums.size());
        for (int i = 0; i < static_cast<int>(nums.size()); i++) {
            nums_map[nums[i]] = i;
        }
        vector<int> answer(2, 0);
        for (int i = 0; i < nums.size(); i++) {
            int another_num = target - nums[i];
            std::unordered_map<int, int>::const_iterator iter = nums_map.find(another_num);
            if (iter != nums_map.end()) {
                if (iter->second < i) {
                    answer[0] = iter->second + 1;
                    answer[1] = i + 1;
                }
                else {
                    answer[1] = iter->second + 1;
                    answer[0] = i + 1;
                }
                break;
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
