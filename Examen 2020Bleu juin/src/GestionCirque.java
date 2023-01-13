import java.util.ArrayList;
import java.util.Scanner;


public class GestionCirque {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Cirque cirque;

	public static void main(String[] args) {	
		
		System.out.println("*************************************************");
		System.out.println("Gestion des reservations d'un spectacle de cirque");
		System.out.println("*************************************************");
	    System.out.println();
		System.out.println("Configuration du spectacle");
		System.out.println("--------------------------");
		System.out.print("Entrez le nombre total de places : ");
		int nombreTotalPlaces = scanner.nextInt();
		System.out.print("Entrez le nombre de places reservees pour les enfants : ");
		int nombrePlacesEnfants = scanner.nextInt();
		scanner.nextLine();
		cirque = new Cirque(nombreTotalPlaces, nombrePlacesEnfants);
		System.out.println();
		
		
		System.out.println("Phase 1");
		System.out.println("-------");
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> afficher la table des reservations");
			System.out.println("2 -> reserver des places de type enfant");
			System.out.println("3 -> reserver des places de type adulte");
			System.out.println("4 -> passer en phase 2");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				afficherTout();
				break;
			case 2:
				reserverEnfant();
				break;
			case 3:
				reserverAdulte();
				break;
			}
		} while (choix >= 1 && choix <= 3);
		
		cirque.changerPhase();
		System.out.println();
		System.out.println();
		
		System.out.println("Phase 2");
		System.out.println("-------");
		choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> afficher la table des reservations");
			System.out.println("2 -> reserver une place");
			System.out.println("3 -> terminer phase 2");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				afficherTout();			
				break;
			case 2:
				reserverAutomatiquement();
				break;
			}

		} while (choix >= 1 && choix <= 2);
		
		System.out.println("Fin des reseservations!");
	}

	private static void reserverEnfant() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();
		System.out.print("Entrez le nombre de places : ");
		int nombrePlaces = scanner.nextInt();
		ArrayList<Integer>	liste = cirque.reserverEnfant(nom, nombrePlaces);
		if(liste==null){
			System.out.println("La reservation a echoue!");
		}else{
			System.out.println("Voici les places reservees : "+liste);
		}
		
	}
	
	private static void reserverAdulte() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();
		System.out.println("Entrez le nombre de places : ");
		int nombrePlaces = scanner.nextInt();
		ArrayList<Integer>	liste = new ArrayList<Integer>();
		for (int i = 0; i < nombrePlaces; i++) {
			System.out.print("Entrez un numero de place : ");
			int numero = scanner.nextInt();
			liste.add(numero);
		}
		scanner.nextLine();
		if(cirque.reserverAdulte(nom, liste)){
			System.out.println("La reservation a reussi!");
		}else{
			System.out.println("La reservation a echoue!");
		}
	}

	private static void reserverAutomatiquement() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();
		int numero = cirque.attribuerAutomatiquementPlace(nom);	
		if(numero==-1){
			System.out.println("La reservation a echoue!");
		}else{
			System.out.println("Voici la place reservee : "+numero);
		}	
	}

	
	private static void afficherTout() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.println(cirque);		
	}

}


