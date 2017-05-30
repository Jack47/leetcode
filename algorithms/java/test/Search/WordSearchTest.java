package Search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordSearchTest {
    @Test
    public void test() {
        WordSearch s = new WordSearch();
        char[][] board = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'},
        };

        boolean real = s.exist(board, "see");
        assertEquals(true, real);

        real = s.exist(board, "abcced");
        assertEquals(true, real);


        real = s.exist(board, "abcb");
        assertEquals(false, real);
    }
}
