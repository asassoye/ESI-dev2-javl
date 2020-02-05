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

package g54327.dev2.td02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Moment class tests
 *
 * @author Andrew SASSOYE <andrew@sassoye.be>
 */
class MomentTest {
    @Test
    public void testConstructorNormalWay() {
        final int hour = 1;
        final int minutes = 2;
        final int seconds = 3;

        Moment moment = new Moment(hour, minutes, seconds);

        assertEquals(hour, moment.getHour());
        assertEquals(minutes, moment.getMinute());
        assertEquals(seconds, moment.getSecond());
    }

    @Test
    public void testConstructorMinimum() {
        final int hour = 0;
        final int minutes = 0;
        final int seconds = 0;

        Moment moment = new Moment(hour, minutes, seconds);

        assertEquals(hour, moment.getHour());
        assertEquals(minutes, moment.getMinute());
        assertEquals(seconds, moment.getSecond());
    }

    @Test
    public void testConstructorMaximum() {
        final int hour = 23;
        final int minutes = 59;
        final int seconds = 59;

        Moment moment = new Moment(hour, minutes, seconds);

        assertEquals(hour, moment.getHour());
        assertEquals(minutes, moment.getMinute());
        assertEquals(seconds, moment.getSecond());
    }

    @Test
    public void testConstructorToSmall() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Moment moment1 = new Moment(-1, 0, 0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Moment moment1 = new Moment(0, -1, 0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Moment moment1 = new Moment(0, 0, -1);
        });
    }

    @Test
    public void testConstructorToBig() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Moment moment1 = new Moment(24, 0, 0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Moment moment1 = new Moment(0, 60, 0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Moment moment1 = new Moment(0, 0, 60);
        });
    }
}