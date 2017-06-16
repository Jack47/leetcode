package StringRelated;

import org.junit.Test;

public class GroupAnagramsTest {
    @Test
    public void test() {
       GroupAnagrams sol = new GroupAnagrams();
        sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
