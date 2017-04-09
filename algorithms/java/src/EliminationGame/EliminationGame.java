package EliminationGame;
// https://leetcode.com/problems/elimination-game/#/description
// There is a list of sorted integers from 1 to n. Starting from
// left to right, remove the first number and every other number afterward
// until you reach the end of the list
// Repeat the previous step again, but this time from right to left, remove
// the right most number and every other number from the remaining numbers.
// We keep repeating the steps again, alternating left to right and right to
// left, until a single number remains.
// Find the last number that remains starting with a list of length n.

public class EliminationGame {
    public int lastRemaining(int n) {
        int step = 1;
        int remain = n;
        int head = 1;
        boolean left = true;
        while (remain > 1) {
            if (left || remain % 2 == 1) { // start from left or from right and remain is odd
                head += step;
            }
            step*=2;
            remain = remain / 2; // 4 => 2, 5 => 2
            left = !left;
        }

        return head;
    }
}
