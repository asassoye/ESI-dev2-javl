package g54327.dev2.recap;

import java.util.Scanner;

public class Memory {
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

    public static int askPosition(int[] cards, boolean[] collectedCards) {
        int position = askIntBetween("", "", 0, cards.length - 1);

        return position;
    }

    private static int askInt(String notIntError) {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.print(notIntError);
        }
        return input.nextInt();
    }

    private static int askIntBetween(String notIntError, String notInIntervalError,
                                     int pos1, int pos2) {
        int integer;
        do {
            System.out.print(notInIntervalError);
            integer = askInt(notIntError);
        } while (!(integer <= pos2 && integer >= pos1));

        return integer;
    }
}
