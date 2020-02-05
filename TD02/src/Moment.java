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

/**
 * Moment class
 *
 * Abstraction of the moment in a day (in hour, minutes and seconds)
 *
 * @author Andrew SASSOYE <andrew@sassoye.be>
 */
public class Moment {
    private int hour;

    private int minute;

    private int second;

    /**
     * Constructor
     *
     * @param hour   default hour (between 0 and 23 included)
     * @param minute default minutes (between 0 and 59 included)
     * @param second default seconds (between 0 and 59 included)
     */
    public Moment(int hour, int minute, int second) {
        if ((hour < 0) || (hour > 23)) {
            throw new IllegalArgumentException("The hour must be between 0 and 23 (included)");
        }
        if ((minute < 0) || (minute > 59)) {
            throw new IllegalArgumentException("The minutes must be between 0 and 59 (included)");
        }
        if ((second < 0) || (second > 59)) {
            throw new IllegalArgumentException("The seconds must be between 0 and 59 (included)");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Format the moment in a string (H:M:S)
     *
     * @return The formatted string
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    /**
     * Hour getter
     *
     * @return hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * Minutes getter
     *
     * @return minutes
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Seconds getter
     *
     * @return seconds
     */
    public int getSecond() {
        return second;
    }
}
