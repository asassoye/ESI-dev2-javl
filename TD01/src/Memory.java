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
        System.out.printf("Entrez une position de carte (0 à %d)", cards.length - 1);
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

    public void checkPosition(int[] cards, boolean[] collectedCards, int pos1, int pos2) {
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
