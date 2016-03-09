package Palindrome;

import LinkedList.ListNode;

public class PalindromeLinkedList {
    protected ListNode current;
    public boolean isPalindrome(ListNode node) {
        if (node == null || node.next == null) return true;
        current = node;
        return isPalindromeInner(node);
    }
    protected boolean isPalindromeInner(ListNode node) {
        boolean isPalindrome = true;
        if (node.next != null) {
             isPalindrome = isPalindromeInner(node.next);
        }
        isPalindrome = isPalindrome && current.val == node.val;
        current = current.next;
        return isPalindrome;
    }
}
