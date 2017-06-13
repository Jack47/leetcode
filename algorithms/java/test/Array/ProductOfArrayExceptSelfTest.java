package Array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ProductOfArrayExceptSelfTest {
    @Test
    public void test() {
        ProductOfArrayExceptSelf n = new ProductOfArrayExceptSelf();
        int [] result = n.productExceptSelf(new int[]{1,2,3,4});
        assertArrayEquals(new int[]{24, 12, 8, 6}, result);
    }
}
