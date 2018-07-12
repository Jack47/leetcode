package Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TenWizardTest {
    @Test
    public void test() {
        TenWizard tw = new TenWizard();
        List<List<Integer>> wizards = new ArrayList<>();
        // 0
        List<Integer> wizard = new ArrayList<>();
        wizard.add(1);
        wizard.add(2);
        wizards.add(wizard);

        // 1
        wizard = new ArrayList<>();
        wizard.add(3);
        wizards.add(wizard);

        // 2
        wizard = new ArrayList<>();
        wizard.add(3);
        wizard.add(4);
        wizards.add(wizard);

        // 3
        wizard = new ArrayList<>();
        wizard.add(4);
        wizards.add(wizard);

        // 4
        wizard = new ArrayList<>();
        wizards.add(wizard);

        List<Integer> real = tw.getShortestPath(wizards, 0, 4);
        List<Integer> expected = new ArrayList<>(4);
        expected.add(0);
        expected.add(2);
        expected.add(3);
        expected.add(4);

        assertEquals(expected, real);
    }
}
