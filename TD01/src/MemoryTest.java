package g54327.dev2.recap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MemoryTest {

    @Test
    public void testInitCardsGeneralCase() {
        //Arrange
        int n = 4;

        //Action
        int[] cards = Memory.initCards(n);

        //Assert
        int[] expected = {1, 1, 2, 2, 3, 3, 4, 4};
        assertArrayEquals(expected, cards);
    }

    @Test
    public void testInitCardsMinimum() {
        //Arrange
        int n = 3;

        //Action
        int[] cards = Memory.initCards(n);

        //Assert
        int[] expected = {1, 1, 2, 2, 3, 3};
        assertArrayEquals(expected, cards);
    }

    @Test
    public void testInitCardsMaximum() {
        //Arrange
        int n = 20;

        //Action
        int[] cards = Memory.initCards(n);

        //Assert
        int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10,
                11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20};
        assertArrayEquals(expected, cards);
    }

    @Test
    public void testInitCardsTooSmall() {
        //Arrange
        int n = 2;

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Action
            int[] cards = Memory.initCards(n);
        });
    }

    @Test
    public void testInitCardsTooBig() {
        //Arrange
        int n = 21;

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Action
            int[] cards = Memory.initCards(n);
        });
    }
}