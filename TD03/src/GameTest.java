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

package g54327.dev2.td03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    @Test
    public void testConstructor() {
        int nbPairs = 3;

        Game game = new Game(nbPairs);

        assertEquals(nbPairs * 2, game.getSize());
    }

    @Test
    public void testFailConstructor() {
        int nbPairs = 2;
        int nbPairs2 = 22;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game(nbPairs);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game(nbPairs2);
        });
    }

    @Test
    public void testCheckingTwoPositions() {
        Game game = new Game(3);


        assertEquals(true, game.checkPositions(0, 1));
        assertEquals(false, game.checkPositions(0, 2));
    }

    @Test
    public void testCheckingIdenticalPosition() {
        Game game = new Game(3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.checkPositions(1, 1);
        });
    }


}