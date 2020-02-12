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

/**
 * Card class
 * Abstraction a Card in Memory game
 *
 * @author Andrew SASSOYE <andrew@sassoye.be>
 */
public class Card {
    private int value;
    private boolean hidden;

    /**
     * Card constructor
     *
     * @param value Card value
     * @throws IllegalArgumentException Value is not positive
     */
    public Card(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Value must be positive!");
        }

        this.value = value;
        this.hidden = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return this.value == card.value;
    }

    @Override
    public String toString() {
        return this.isHidden() ? "?" : String.valueOf(this.getValue());
    }

    /**
     * Value getter
     *
     * @return Value of card
     */
    public int getValue() {
        return value;
    }

    /**
     * Hidden getter
     *
     * @return Card hidden or not
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Reveal the card
     */
    public void reveal() {
        this.hidden = false;
    }
}
