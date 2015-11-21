/* You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 */
#include <assert.h>
#include <stdlib.h>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) {
            return l2;
        }
        if (l2 == NULL) {
            return l1;
        }
        ListNode* curNode1 = l1;
        ListNode* curNode2 = l2;
        ListNode* preNode1 = NULL;
        int carrier = 0;
        int remain = 0;
        int sum = 0;
        while (curNode1 != NULL && curNode2 != NULL) {
            sum = curNode1->val + curNode2->val + carrier;
            carrier = sum/10;
            remain = sum%10;
            curNode1->val = remain;
            preNode1 = curNode1;
            curNode1 = curNode1->next;
            curNode2 = curNode2->next;
            assert(carrier <= 1);            
        }
        if (curNode2 != NULL) {
            preNode1->next = curNode2;
            curNode1 = curNode2;
        }
        if (carrier > 0) {
            while (curNode1 != NULL && carrier > 0) {
                sum = curNode1->val + carrier;
                carrier = sum/10;
                remain = sum%10;
                curNode1->val = remain;
                preNode1 = curNode1;
                curNode1 = curNode1->next;
            }
            if(curNode1 == NULL && carrier > 0) {
                ListNode* lastNode = static_cast<ListNode*>(malloc(sizeof(ListNode)));
                lastNode->next = NULL;
                lastNode->val = carrier;
                preNode1->next = lastNode;
            }
        }

        return l1;
    }
};
int main() {
    Solution sol;
    sol.addTwoNumbers(NULL, NULL);
}
