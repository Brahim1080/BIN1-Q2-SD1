import java.util.Scanner;

public class GestionTickets {
    //private static MonScanner scanner = new MonScanner("exam2021bleu.txt");
    private static Scanner scanner = new Scanner(System.in);
    private static FileTickets fileTickets = new FileTickets();
    public static void main(String[] args) {
        int choix = 0;
        do {
            System.out.println("***************************************"+
                    "\nGestion Ticket" +
                                "\n***************************************");
            System.out.println();
            System.out.println("1 : Ajout ticket\n" +
                    "2 : Retrait ticket priorité max\n" +
                    "3 : Afficher tous les tickets\n" +
                    "4 : Afficher les tickets selon les priorités (défi)");

            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    ajoutTicket();
                    break;
                case 2:
                    retraitTicketPrioriteMax();
                    break;
                case 3:
                    afficherToutTicket();
                    break;
            }

        } while (choix== 0);



    }
    public static void ajoutTicket(){

    }
    public static void retraitTicketPrioriteMax(){

    }
    public static void afficherToutTicket(){

    }
    public static void afficherLesTicketsSelonPriorite(){

    }
}
