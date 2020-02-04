package g54327.dev2.recap.utils;

import static org.junit.Assert.assertArrayEquals;

public class ArrayUtilTest {
    public void testSwapGeneralCase() {
        System.out.println("swap general case");

        //Arrange
        int[] array = {10, 11, 12};
        int pos1 = 0;
        int pos2 = 1;

        //Action
        ArrayUtil.swap(array, pos1, pos2);

        //Assert
        int[] expected = {11, 10, 12};
        assertArrayEquals(expected, array);
    }
}