package Stack;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class NumberOfAtomsTest {
    @Test
    public void test() {
        NumberOfAtoms s = new NumberOfAtoms();
        String real = s.countOfAtoms("H2O");
        assertEquals(real, "H2O");

        real = s.countOfAtoms("H2OH");
        assertEquals(real, "H3O");

        real = s.countOfAtoms("Mg(OH)2");
        assertEquals(real, "H2MgO2");

        real = s.countOfAtoms("(H2O)");
        assertEquals(real, "H2O");

        real = s.countOfAtoms("((H2O)2)2");
        assertEquals(real, "H8O4");

        real = s.countOfAtoms("K4(ON(SO3)2)2");
        assertEquals(real, "K4N2O14S4");

        real = s.countOfAtoms("H11He49NO35B7N46Li20");
        assertEquals(real, "B7H11He49Li20N47O35");

        real = s.countOfAtoms("(NB3)33");
        assertEquals("B99N33", real);

        real = s.countOfAtoms("((H2O)2(H2O)2)3");
        assertEquals("H24O12", real);

        real = s.countOfAtoms("((N7Li31C7B10Be37B23H2H11Li40Be15)26(OBLi48B46N4)25(O48C22He)" +
                "2N10O34N15B33Li39H34H26B15B23C31(C36N38O33Li38H15H46He21Be38B50)8)3");
        assertEquals("B7512Be4968C1635H2658He510Li10167N1833O1257", real);

        real = s.countOfAtoms("(OBLi)3(O48He)2N2)3");
        assertEquals("B9He6Li9N6O297", real);

        real = s.countOfAtoms("(Be22)8((N)46)13");
        assertEquals("Be176N598", real);
    }
}
