/*
 * Copyright (C) 2020 Andrew SASSOYE
 *
 * Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation files (the “Software”),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package g54327.dev2.recap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * MemoryTest class
 *
 * @author Andrew SASSOYE <andrew@sassoye.be>
 */
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