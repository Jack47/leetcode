package DepthFirstSearch;

import java.util.List;

import org.junit.Test;

public class PalindromePartitionTest {
    @Test
    public void test() {
        PalindromePartition p = new PalindromePartition();
        List<List<String>> result = p.partition("aab");
    }
}
