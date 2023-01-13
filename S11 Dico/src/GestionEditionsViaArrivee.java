import java.util.HashSet;
import java.util.TreeSet;
/**
 *
 * @author ABID Brahim
 *
 */
public class GestionEditionsViaArrivee {
    private static MonScanner scanner = new MonScanner("InputA.txt");
    private static TreeSet<Etudiant> ensembleEtudiants = new TreeSet<Etudiant>(new ComparateurViaArrivee());

    public static void main(String[] args) {
        System.out.println("*********************");
        System.out.println("Gestion des etudiants Via Matricule");
        System.out.println("*********************");
        int choix = 0;
        do {
            System.out.println();
            System.out.println("1 -> ajouter un etudiant");
            System.out.println("2 -> afficher tous les etudiants");

            System.out.println();
            System.out.print("Entrez votre choix : ");

            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    ajout();
                    break;
                case 2:
                    tous();
                    break;

                default:
                    break;
            }
        } while (choix >= 1 && choix <= 2 );


    }

    private static void tous() {
        System.out.println();
        for (Etudiant etudiant : ensembleEtudiants) {
            System.out.println(etudiant.getNumeroMatricule()+ " " +etudiant.getNom() + " " +etudiant.getPrenom());
        }
        System.out.println();
    }

    private static void ajout() {
        System.out.println();
        System.out.print("Entrez le numero de matricule : ");
        int numero = scanner.nextInt();
        System.out.print("Entrez le nom : ");
        String nom = scanner.next();
        System.out.print("Entrez le prenom : ");
        String prenom = scanner.next();

        ensembleEtudiants.add(new Etudiant(numero,nom,prenom));

    }

}
