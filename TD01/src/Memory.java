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

import g54327.dev2.recap.utils.ArrayUtil;
import g54327.dev2.recap.utils.MemoryUtil;

import java.util.Scanner;

/**
 * Memory class
 *
 * @author Andrew SASSOYE <andrew@sassoye.be>
 */
public class Memory {
    /**
     * Initialise set of cards
     *
     * @param n number of pairs, between 3 and 20 included.
     * @return array of cards
     * @throws IllegalArgumentException if n of pairs is not between 3 and 20.
     */
    public static int[] initCards(int n) {
        if (n < 3 || n > 20) {
            throw new IllegalArgumentException("Le nombre de cartes doit être compris entre 3 et 20 inclus");
        }

        int nbCards = 2 * n;
        int[] cards = new int[nbCards];

        for (int i = 0; i < cards.length; ++i) {
            cards[i] = (int) Math.ceil((double) (i + 1) / 2);
        }

        return cards;
    }

    /**
     * Ask the player for a card position. Ask until a good answer is given.
     *
     * @param cards Array of cards
     * @param collectedCards Array of collected cards
     *
     * @return The position of the chosen card.
     */
    public static int askPosition(int[] cards, boolean[] collectedCards) {
        System.out.printf("Entrez une position de carte (0 à %d): ", cards.length - 1);
        int position;
        do {
            position = askIntBetween(
                    "La valeur entrée n'est pas un entier",
                    String.format("La valeur entrée n'est pas compris entre %d et %d", 0, cards.length - 1),
                    0, cards.length - 1);
            if (collectedCards[position]) {
                System.out.println("Cette carte n'est plus disponible");
            }
        } while (collectedCards[position]);

        System.out.printf("La carte en position %d est %d.\n", position, cards[position]);
        return position;
    }

    /**
     * Check if the cards at two given positions are equal
     *
     * @param cards Array of cards
     * @param collectedCards Array of collected cards
     * @param pos1 Position 1 to check
     * @param pos2 Position 2 to check
     *
     * @throws IllegalArgumentException If pos1 is pos2
     */
    public static void checkPosition(int[] cards, boolean[] collectedCards, int pos1, int pos2) {
        if (pos1 == pos2) {
            throw new IllegalArgumentException("La pos1 doit être differente que pos2");
        }

        if (cards[pos1] == cards[pos2]) {
            System.out.println("Elles correspondent !");
            collectedCards[pos1] = true;
            collectedCards[pos2] = true;
        } else {
            System.out.println("Elles ne correspondent pas !");
        }
    }

    /**
     * Checks if the game is over.
     *
     * @param collectedCards Array of collected cards.
     *
     * @return true if the game is over, false if the game is still in progress.
     */
    public static boolean isGameOver(boolean[] collectedCards) {
        for (boolean collected :
                collectedCards) {
            if (!collected) {
                return false;
            }
        }
        return true;
    }

    /**
     * Play the game
     *
     * @param n Number of pairs wished
     *
     * @return number of game rounds before finishing the game
     */
    public static int playMemory(int n) {
        int[] cards = initCards(n);
        ArrayUtil.shuffle(cards);

        boolean[] collectedCards = new boolean[cards.length];

        int tour = 1;
        while (!isGameOver(collectedCards)) {
            System.out.printf("*** tour %d\n", tour);
            MemoryUtil.displayCards(cards, collectedCards);
            int pos1 = askPosition(cards, collectedCards);
            int pos2 = askPosition(cards, collectedCards);
            checkPosition(cards, collectedCards, pos1, pos2);
            ++tour;
        }

        return tour - 1;
    }

    /**
     * Game
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        System.out.println("*** Memory ***");
        System.out.print("Avec combien de paires voulez-vous jouer? (3 à 20): ");
        int pairs = askIntBetween(
                "La valeur entrée n'est pas un entier",
                String.format("La valeur entrée n'est pas compris entre %d et %d", 3, 20),
                3, 20);
        int tours = playMemory(pairs);
        System.out.printf("Partie terminée en %d coups\n", tours);
    }

    /**
     * Asks for an int. Ask again. Asks again until an integer is entered.
     *
     * @param notIntError Error to display if the input is incorrect
     *
     * @return The asked int
     */
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
     * @param notIntError Error to display if the input is not an int
     * @param notInIntervalError Error to display if the input is not between the interval
     * @param pos1 First position in interval
     * @param pos2 Second position in interval
     *
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
}
