#include <stdio.h>
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int v) : val(v), left(NULL), right(NULL) {
    }
};
class Solution {
public:
    bool isValidBST(const TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        int preValue = 0x80000000;
        return isValidBST(root, &preValue);

    }
    bool isValidBST(const TreeNode* root, int* preValue) {
        bool ret = true;
        if (root->left != NULL) {
            ret = isValidBST(root->left, preValue);
            if (*preValue > root->val || !ret) {
                return false;
            }
        }
        *preValue = root->val;
        if (root->right != NULL) {
            ret = isValidBST(root->right, preValue);
            if (!ret) {
                return false;
            }
        }
        return true;
    }
};
      
