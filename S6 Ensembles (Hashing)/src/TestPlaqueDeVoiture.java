public class TestPlaqueDeVoiture {

    public final static int NBRE_LISTES = 500;

    public static void main(String args[]) {
        // Attention, la methode hashCode() renvoie un entier
        // Cet entier pourrait etre negatif --> Math.abs()
        // Cet entier doit correspondre a une liste --> %NBRE_LISTES
        int[] tableau = new int[NBRE_LISTES];
        for (char a = 'A'; a <= 'Z'; a++) {
            for (char b = 'A'; b <= 'Z'; b++) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    for (char d = '0'; d <= '9'; d++) {
                        for (char e = '0'; e <= '9'; e++) {
                            for (char f = '0'; f <= '9'; f++) {
                                String plaque = "1" + a + b + c + d + e + f;
                                System.out.println(plaque);
                                Voiture voiture = new Voiture(plaque, "Brahim");
                                int indice = Math.abs(voiture.hashCode()) % NBRE_LISTES;
                                tableau[indice]++;

                            }
                        }
                    }
                }
            }

        }
        for (int i = 0; i < NBRE_LISTES ; i++) {
            System.out.println(tableau[i]);
        }

    }
}