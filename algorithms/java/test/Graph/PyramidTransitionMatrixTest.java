package Graph;

import org.junit.Test;

import java.util.Arrays;

public class PyramidTransitionMatrixTest {
    @Test
    public void test() {
        PyramidTransitionMatrix pym = new PyramidTransitionMatrix();
        String[] choices = new String[]{"ABD", "BCE", "DEF", "FFF"};
        pym.pyramidTransition("ABC", Arrays.asList(choices));
    }
}
