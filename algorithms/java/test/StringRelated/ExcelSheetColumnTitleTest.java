package StringRelated;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ExcelSheetColumnTitleTest {
    @Test
    public void test() {
        ExcelSheetColumnTitle t = new ExcelSheetColumnTitle();
        String s = t.convertToTitle(26);
        assertEquals("Z", s);

        s = t.convertToTitle(27);
        assertEquals("AA", s);

        s = t.convertToTitle(52);
        assertEquals("AZ", s);

        s = t.convertToTitle(269);
        assertEquals("JI", s);
    }
}
