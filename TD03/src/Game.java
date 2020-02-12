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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Game class
 * Abstraction of a Memory game
 *
 * @author Andrew SASSOYE <andrew@sassoye.be>
 */
public class Game {
    private List<Card> cards;

    /**
     * Game constructor
     *
     * @param nbCards Number of pairs
     */
    public Game(int nbCards) {
        this.cards = initCards(nbCards);
    }

    /**
     * Memory cards static Factory
     *
     * @param nbCards Number of pairs
     * @return Cards (ordered)
     */
    private static List<Card> initCards(int nbCards) {
        if (nbCards < 3 || nbCards > 20) {
            throw new IllegalArgumentException("The number of cards must be between 3 and 20 (included)");
        }

        int n = 2 * nbCards;
        List<Card> cards = new LinkedList<>();

        for (int i = 1; i <= n; ++i) {
            cards.add(new Card((int) Math.ceil((double) i / 2)));
        }

        return cards;
    }

    @Override
    public String toString() {
        StringBuilder formatted = new StringBuilder().append("The cards: ");
        for (Card card : this.cards) {
            formatted.append(String.format("%s ", card));
        }

        return formatted.toString();
    }

    /**
     * Shuffle cards
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * Size of game
     *
     * @return size
     */
    public int getSize() {
        return this.cards.size();
    }

    /**
     * Checks if the game is over.
     *
     * @return true if over, false otherwise
     */
    public boolean isGameOver() {
        for (Card card : this.cards) {
            if (card.isHidden()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPositions(int pos1, int pos2) {
        if (pos1 == pos2) {
            throw new IllegalArgumentException("pos1 must be different of pos2!");
        }

        Card card1 = this.cards.get(pos1);
        Card card2 = this.cards.get(pos2);

        if (card1.equals(card2)) {
            System.out.println("They match!");
            card1.reveal();
            card2.reveal();
            return true;
        } else {
            System.out.println("They don't match!");
        }

        return false;
    }

    public int getCardValue(int pos) {
        return this.cards.get(pos).getValue();
    }

    public boolean isHidden(int pos) {
        return this.cards.get(pos).isHidden();
    }
}
