import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class GestionBrocante {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Brocante brocante;

	public static void main(String[] args) {	
		
		System.out.println("***************************************");
		System.out.println("Gestion des reservations de la brocante");
		System.out.println("***************************************");
	    System.out.println();
		System.out.println("Configuration de la brocante");
		System.out.print("Entrez le nombre total d'emplacements : ");
		int nombreTotalEmplacements = scanner.nextInt();
		System.out.print("Entrez le nombre d'emplacements reserves pour les riverains : ");
		int nombreEmplacementsRiverains = scanner.nextInt();
		int[]tableCodes=new int[nombreEmplacementsRiverains];
		for (int i = 0; i < nombreEmplacementsRiverains; i++) {
			System.out.print("Entrez le code pour reserver l'emplacement "+i+" : ");
			tableCodes[i]=scanner.nextInt();
		}
		scanner.nextLine();
		brocante = new Brocante(nombreTotalEmplacements,tableCodes);
		System.out.println();
		
		
		System.out.println("Phase 1");
		System.out.println("-------");
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> afficher la table des reservations");
			System.out.println("2 -> confirmer un emplacement riverain");
			System.out.println("3 -> reserver des emplacements pour tous");
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
				reserverRiverain();
				break;
			case 3:
				reserver1();
				break;
			}
		} while (choix >= 1 && choix <= 3);
		
		brocante.changerPhase();
		System.out.println();
		System.out.println();
		
		System.out.println("Phase 2");
		System.out.println("-------");
		choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> afficher la table des reservations");
			System.out.println("2 -> reserver des emplacements pour tous");
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
				reserver2();
				break;
			}

		} while (choix >= 1 && choix <= 2);
		
		System.out.println("Fin des reseservations!");
	}

	private static void reserverRiverain() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();
		System.out.print("Entrez le code : ");
		int code = scanner.nextInt();
		if(brocante.reserverRiverain(nom, code)){
			System.out.println("La reservation a reussi!");
		}else{
			System.out.println("La reservation a echoue!");
		}
		
		
	}
	
	private static void reserver1() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();
		System.out.print("Entrez le nombre de places : ");
		int nombreEmplacementsDemandes = scanner.nextInt();
		ArrayList<Integer> liste = brocante.reserverAuto1(nom, nombreEmplacementsDemandes);
		if(liste!=null){
			System.out.println("La reservation a reussi!");
			System.out.println("Voici les numeros : "+liste);
		}else{
			System.out.println("La reservation a echoue!");
		}
	}

	private static void reserver2() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();
		System.out.print("Entrez le nombre de places : ");
		int nombreEmplacementsDemandes = scanner.nextInt();
		ArrayList<Integer> liste = brocante.reserverAuto2(nom, nombreEmplacementsDemandes);
		if(liste!=null){
			System.out.println("La reservation a reussi!");
			System.out.println("Voici les numeros : "+liste);
		}else{
			System.out.println("La reservation a echoue!");
		}
	}

	
	private static void afficherTout() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.println(brocante);		
	}

}


