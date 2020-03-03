package g54327.dev2.td05;

public class Tableau2D {
    /**
     * Afficher le tableau d'entier a l'écran
     *
     * @param tableau Tableau d'entiers
     */
    public static void afficher(int[][] tableau) {
        for (int[] ligne : tableau) {
            for (int element :
                    ligne) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }

    /**
     * Retourne le nombres de nuls dans un tableau d'entiers
     *
     * @param tableau Tableau d'entiers
     * @return Le nombre de nulls dans le tableau
     */
    public static int proportionNuls(int[][] tableau) {
        int nuls = 0;
        for (int[] ligne : tableau) {
            for (int element :
                    ligne) {
                if (element == 0) {
                    ++nuls;
                }
            }
        }

        return nuls;
    }

    /**
     * Verifie si tout les nombres d'un tableau d'enteirs est strictement positif
     *
     * @param tableau Tableau d'entiers a verifier
     * @return true si le tableau est pleinement positif, false sinon
     */
    public static boolean estPleinementPositif(int[][] tableau) {
        for (int[] ligne : tableau) {
            for (int element :
                    ligne) {
                if (element <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
