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
        if (root == NULL ||
            (root->left == NULL && root->right == NULL)) {
            return true;
        }
        int prevValue = 0x80000000;
        bool hasPrevValue = false;
        return isValidBST(root, hasPrevValue, &prevValue);

    }
    bool isValidBST(const TreeNode* root, bool hasPrevValue, int* preValue) {
        bool ret = true;
        if (root->left != NULL) {
            ret = isValidBST(root->left, hasPrevValue, preValue);
            hasPrevValue = true;
        }
        if ( (hasPrevValue && *preValue >= root->val) || !ret) {
            return false;
        }
        *preValue = root->val;
        hasPrevValue = true;
        if (root->right != NULL) {
            ret = isValidBST(root->right, hasPrevValue, preValue);
            if (!ret) {
                return false;
            }
        }

        return true;
    }
};       
