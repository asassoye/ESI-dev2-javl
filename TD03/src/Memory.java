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

import java.util.Scanner;

/**
 * Memory class
 *
 * @author Andrew SASSOYE <andrew@sassoye.be>
 */
public class Memory {
    private Game game;

    public Memory(int nbCards) {
        this.game = new Game(nbCards);
    }

    private static int askInt(String notIntError) {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println(notIntError);
        }
        return input.nextInt();
    }

    /**
     * Asks for an int between two numbers (included). Ask again.
     * Asks again until a correct integer is entered.
     *
     * @param notIntError        Error to display if the input is not an int
     * @param notInIntervalError Error to display if the input is not between the interval
     * @param pos1               First position in interval
     * @param pos2               Second position in interval
     * @return The asked integer
     */
    private static int askIntBetween(String notIntError, String notInIntervalError,
                                     int pos1, int pos2) {
        int integer;
        do {
            integer = askInt(notIntError);
            if (!(integer <= pos2 && integer >= pos1)) {
                System.out.println(notInIntervalError);
            }
        } while (!(integer <= pos2 && integer >= pos1));

        return integer;
    }

    public int askPosition() {
        System.out.printf("Enter a position (0 à %d): ", this.game.getSize() - 1);
        int position;

        do {
            position = askIntBetween(
                    "The entered value is not an integer",
                    String.format("The entered value is not between %d and %d (included)", 0, this.game.getSize() - 1),
                    0, this.game.getSize() - 1);
            if (this.game.isHidden(position)) {
                System.out.println("This card is not available anymore");
            }
        } while (this.game.isHidden(position));

        System.out.printf("The card at position %d is %d.\n", position, this.game.getCardValue(position));
        return position;
    }

    public int playMemory() {
        return 0;
    }
}





