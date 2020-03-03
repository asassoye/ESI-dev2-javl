package g54327.dev2.td05;

public class MainExoBase {
    public static void main(String[] args) {
        int[][] tableau = {
                {0},
                {0, 1},
                {0, 1, 2},
                {0, 1, 2, 3},
                {0, 1, 2, 3, 4}
        };

        Tableau2D.afficher(tableau);
        System.out.printf("Le nombre de nuls dans le tableau: %d\n", Tableau2D.proportionNuls(tableau));
        System.out.printf("Est pleinement positif: %s\n",
                Tableau2D.estPleinementPositif(tableau) ? "Oui" : "Non"
        );
    }
}
