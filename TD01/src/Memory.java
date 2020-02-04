package g54327.dev2.recap;

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
}
