#include<stdio.h>
#include<stack>

using namespace std;
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
        stack<const TreeNode*> backTraceStack;

        const TreeNode* node = root;
        const TreeNode* preNode = NULL;
        while (node != NULL) {
            // traverse left node
            while (node->left != NULL) {
                backTraceStack.push(node);
                node = node->left;
            }
            // traverse node
            if (preNode != NULL && preNode->val >= node->val) {
                return false;
            }
            // traverse parent node
            preNode = node;
            // traverse right or parent node
            node = node->right;
            while (node == NULL && backTraceStack.size() > 0) {
                node = backTraceStack.top();
                backTraceStack.pop();
                if (preNode != NULL && preNode->val >= node->val) {
                    return false;
                }
                preNode = node;
                node = node->right;
            }
        }
        return true;
    }
};
