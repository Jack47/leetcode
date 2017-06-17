package Integer;

import org.junit.Test;

public class IntegerToEnglishWordsTest {
    @Test
    public void test() {
        IntegerToEnglishWords i = new IntegerToEnglishWords();
        String result = i.numberToWords(1);
        result = i.numberToWords(10);
        result = i.numberToWords(19);
        result = i.numberToWords(20);
        result = i.numberToWords(23);
        result = i.numberToWords(11111);
        result = i.numberToWords(1234);
    }
}
