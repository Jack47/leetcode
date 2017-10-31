package Palindrome;

import java.util.List;

import org.junit.Test;

public class PalindromePairsTest {
    @Test
    public void test() {
        PalindromePairTT p = new PalindromePairTT();
        List<List<Integer>> result = p.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});

    }
}
