package Greedy;

import org.junit.Test;

public class CreateMaximumNumberTest {
    @Test
    public void test() {
        CreateMaximumNumber c = new CreateMaximumNumber();
        int[] result = c.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        result = c.maxNumber(new int[]{5, 7, 3}, new int[]{4, 2, 3}, 3);

    }
}
