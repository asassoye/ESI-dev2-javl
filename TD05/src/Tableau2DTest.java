package g54327.dev2.td05;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tableau2DTest {

    @Nested
    class ProportionNulsTest {
        @Test
        public void pasDeZeros() {
            int[][] tableau = {
                    {1},
                    {1, 2},
                    {1, 2, 3},
                    {1, 2, 3, 4}
            };

            assertEquals(0, Tableau2D.proportionNuls(tableau));
        }
    }
}