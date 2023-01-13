import java.util.Scanner;

/**
 * @author ABID Brahim
 */

public class GestionnaireEntrepot {
    private static Entrepot entrepot = new Entrepot(5);
    private static EnsembleVoituresAutorisees voituresAutorisees = new EnsembleVoituresAutorisees();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        entrepot = new Entrepot(5);
        ;
        System.out.print("**Gestionnaire Entrepot**");
        int choix = 0;
        do {
            afficherChoix();
            choix = scanner.nextInt();
            switch (choix) {

                case 1:
                    attribuerHangar();
                    break;

                case 2:
                    listerHangarDuneSociete();
                    break;

                case 3:
                    libererHangar();
                    break;
                case 4:
                    ajouterVehiculeAUneSociete();
                    break;
                case 5:
                    verifierPlaqueDImatriculation();
                    break;
            }
        } while (choix != 0);


    }

    private static void afficherChoix() {


        System.out.println("\n\n1 : attribuer un hangar\n" +
                "2 : lister les hangars d une societe\n" + "3 : liberer hangar \n" + "4 : ajouter un véhicule a une société\n" +
                "5 : vérifier plaque d’immatriculation" + "0 : arreter le programme");
    }

    public static void ajouterVehiculeAUneSociete() {

    }

    public static void verifierPlaqueDImatriculation() {

    }

    public static void attribuerHangar() {

        System.out.println("Entrez le numero de la societe ");
        int numeroSociete = scanner.nextInt();
        System.out.println("Entrez le nom de la societe");
        String nomSociete = scanner.next();
        System.out.println("Hangar attribue est le " + entrepot.attribuerHangar(numeroSociete, nomSociete));

    }

    public static void listerHangarDuneSociete() {
        System.out.println("Entrez le numero de la societe ");
        int numeroSociete = scanner.nextInt();

        System.out.println(entrepot.getSociete(numeroSociete).lesHangars());
    }

    public static void libererHangar() {
        System.out.println("Entrez le numero du Hangar");
        int numero = scanner.nextInt();
        if (entrepot.libererHangar(numero)) {
            System.out.println("Le hangar bien ete libere");
        } else {
            System.out.println("La liberation du hangar n a pas ete effectue");
        }

    }
}
