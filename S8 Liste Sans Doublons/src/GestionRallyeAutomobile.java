import java.util.Scanner;
/**
 *
 * @author ABID Brahim
 *
 *
 */
public class GestionRallyeAutomobile {
    private static Scanner scanner = new Scanner(System.in);
    private static RallyeAutomobile rallyeAutomobile;

    public static void main(String[] args) {

        System.out.println("************************************************\n" +
                "Programme de gestion d'un Rallye Automobile\n" +
                "************************************************\n");
        System.out.println("Entrez le nombre de pilote : ");
        int nombreDePilote = scanner.nextInt();
        String[] tablesPilotes = new String[nombreDePilote];
        for (int i = 0; i < tablesPilotes.length; i++) {
            System.out.println("Entrez le pilote " + (i + 1) + " :");
            tablesPilotes[i] = scanner.next();

        }
        rallyeAutomobile = new RallyeAutomobile(tablesPilotes);


        int choix;
        do {
            System.out.println("1 -> Afficher toute la course\n" +
                    "2 -> Afficher le pilote en tête\n" +
                    "3 -> Enregistrer un dépassement\n" +
                    "4 -> Disqualifier un pilote\n" +
                    "5 -> Donner la position d’un pilote\n" +
                    "6 -> Faire franchir la ligne d’arrivée au pilote de tête\n");
            choix = scanner.nextInt();
            switch (choix) {

                case 1:
                    afficherTouteLaCourse();
                    break;

                case 2:
                    afficherPiloteEnTete();
                    break;
                case 3:
                    enregistrerDepassement();
                    break;
                case 4:
                    disqualiferUnPilote();
                    break;
                case 5:
                    donnerLaPositionPilote();
                    break;
                case 6:
                    arriveeDuPiloteEnTete();
            }

        } while (choix >= 1 && choix <= 6 && !rallyeAutomobile.estFini());
        if (rallyeAutomobile.estFini()){

           afficherFinCourse();
        }
    }
    public static void afficherFinCourse(){
        System.out.println("La course est fini voila le resultat  :\n"+rallyeAutomobile.afficherFinDeCourse());

    }

    public static void afficherTouteLaCourse() {
        System.out.println("Liste des pilotes dans la course:\n"+ rallyeAutomobile.afficherTouteLaCourse());
    }

    public static void afficherPiloteEnTete() {
        System.out.println("Le pilote en tete est " + rallyeAutomobile.donnerPiloteEnTete());
    }

    public static void enregistrerDepassement() {
        System.out.println("Entrez le pilote qui depasse :");

        String pilote = scanner.next();

        boolean reussi = rallyeAutomobile.depasser(pilote);
        if (reussi) {
            System.out.println("Le depassement a bien ete effectue");
        } else {
            System.out.println("Le test n a pas reussi car");
            if (rallyeAutomobile.estArrive(pilote)){
                System.out.println("Le pilote a deja franchi la ligne d arrive");
                return;
            }
            if (rallyeAutomobile.estDisqualifie(pilote)){
                System.out.println("Le pilote "+ pilote + " a  ete disqualifie" );
                return;
            }
            if (rallyeAutomobile.estPremier(pilote)){
                System.out.println("Le pilote " + " est premier dans la course");
                return;
            }
            if (!rallyeAutomobile.contient(pilote)){
                System.out.println("Le pilote "+ pilote +" n est pas present dans le rallye");
            }

        }
    }

    public static void disqualiferUnPilote() {
        System.out.println("Entrez le pilote disqualifié : ");
        String pilote = scanner.next();
        boolean reussi = rallyeAutomobile.supprimer(pilote);
        if (reussi) {
            System.out.println("Le pilote " + pilote + " a ete disqualifie");
        } else {
            System.out.println("Le test n a pas reussi car");
            if (rallyeAutomobile.estDisqualifie(pilote)){
                System.out.println("Le pilote "+ pilote + " a deja ete disqualifie" );
            return;
            }
            if (rallyeAutomobile.estArrive(pilote)){
                System.out.println("Le pilote a deja franchi la ligne d arrive");
                return;
            }
            if (!rallyeAutomobile.contient(pilote)){
                System.out.println("Le pilote "+ pilote +" n est pas present dans le rallye");
            }


        }

    }

    public static void donnerLaPositionPilote() {
        System.out.println("Position du pilote : ");
        String pilote = scanner.next();
        int indice = rallyeAutomobile.donnerPositionDunPilote(pilote);
        if (indice != -1) {
            System.out.println("Le pilote " + pilote + " est a la position " + indice);

        } else {
            System.out.println("Le test n a pas reussi car ");
            if (rallyeAutomobile.estDisqualifie(pilote)){
                System.out.println("Le pilote "+ pilote +" est disqualifie");
                return;
            }
            if (rallyeAutomobile.contient(pilote)){
                System.out.println("Le pilote n'est pas dans le rallye");
                return;
            }
            if (rallyeAutomobile.estArrive(pilote)){
                System.out.println("Le pilote a deja franchi la ligne d arrive");
            }

        }


    }

    public static void arriveeDuPiloteEnTete() {
        System.out.println("Le pilote " + rallyeAutomobile.donnerPiloteEnTete() +" a passe la ligne d arrivee!");
        rallyeAutomobile.piloteEnTeteArriver();
    }

}
