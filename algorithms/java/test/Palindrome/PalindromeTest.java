package Palindrome;

import static org.junit.Assert.assertEquals;

import LinkedList.ListNode;
import org.junit.Test;

public class PalindromeTest {
    @Test
    public void test() {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);

        boolean result = palindromeLinkedList.isPalindrome(root);
        assertEquals(true, result);

        result = palindromeLinkedList.isPalindrome(null);
        assertEquals(true, result);

        root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(0);

        result = palindromeLinkedList.isPalindrome(root);
        assertEquals(false, result);
    }
}
