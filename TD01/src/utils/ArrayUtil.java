package g54327.dev2.recap.utils;

import java.util.Random;

/**
 * Diverses méthodes utiles pour les tableaux.
 */
public class ArrayUtil {

    /**
     * Mélange le tableau.
     *
     * @param array le tableau à mélanger.
     */
    public static void shuffle(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(array, i, index);
        }
    }

    /**
     * Échange le contenu de deux cases de tableau. Échange dans le tableau
     * <code>array</code> le contenu des cases en positions <code>pos1</code> et
     * <code>pos2</code>. Ces 2 positions sont supposées correctes.
     *
     * @param array le tableau dont on échange 2 cases.
     * @param pos1  la position de la première case à échanger.
     * @param pos2  la position de la seconde case à échanger.
     * @throws IllegalArgumentException si au moins une des positions est
     *                                  strictement négative.
     */
    public static void swap(int[] array, int pos1, int pos2) {
        if (pos1 < 0 || pos2 < 0) {
            throw new IllegalArgumentException("Les positions doivent être des "
                    + "entiers positifs " + pos1 + " " + pos2);
        }
        int savedValue = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = savedValue;
    }
}
