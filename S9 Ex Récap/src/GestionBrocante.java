import java.util.Scanner;


public class GestionBrocante {
	
	//private static Scanner scanner = new Scanner(System.in);
	private static MonScanner scanner = new MonScanner("lancement.txt") ;
	private static Brocante brocante;

	public static void main(String[] args) {	
		
		System.out.println("**********************");
		System.out.println("gestion d'une brocante");
		System.out.println("**********************");
	    System.out.println();
		System.out.println("configuration de la brocante");
		System.out.println("----------------------------");
		System.out.print("Entrez le nombre d'emplacements : ");
		int nombreEmplacements = scanner.nextInt();
		System.out.print("Entrez le nombre de riverains : ");
		int nombreRiverains = scanner.nextInt();
		scanner.nextLine();
		String[] tableRiverains = new String[nombreRiverains];
		for (int i = 0; i < tableRiverains.length; i++) {
			System.out.print("Entrez le nom du riverain "+ (i+1) + ": ");
			tableRiverains[i] = scanner.nextLine();
		}
		brocante = new Brocante(nombreEmplacements, tableRiverains);
		System.out.println();
		
		
		System.out.println("Phase 1");
		System.out.println("-------");
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> reserver un emplacement");
			System.out.println("2 -> afficher la brocante");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				reserverPhase1();
				break;
			case 2:
				afficherTout();
				break;
			}

		} while (choix >= 1 && choix <= 2);
		
		brocante.changerPhase();
		System.out.println();
		System.out.println();
		
		System.out.println("Phase 2");
		System.out.println("-------");
		choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> reserver un emplacement");
			System.out.println("2 -> afficher la brocante");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				reserverPhase2();
				break;
			case 2:
				afficherTout();
				break;
			}

		} while (choix >= 1 && choix <= 2);
		
		System.out.println("Fin de la brocante!");
	}

	private static void reserverPhase1() {
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();
		scanner.nextLine();

		if (brocante.estUnRiverain(nom)){
			System.out.println("Entrez le GSM");
			String GSM= scanner.nextLine();
			System.out.println("Entrez un mail");
			String mail = scanner.nextLine();

			Exposant exposant = new Exposant(nom,GSM,mail);
			System.out.print("Entrez le numero de l'emplacement : ");
			int numero = scanner.nextInt();
			brocante.reserver(exposant,numero);
		}
		

		
	}

	private static void reserverPhase2() {
		brocante.changerPhase();
		if (brocante.emplacementLibre()){

			System.out.println("Entrez le nom : ");
			String nom = scanner.nextLine();
			System.out.println("Entrez le GSM");
			String GSM= scanner.nextLine();
			System.out.println("Entrez un mail");
			String mail = scanner.nextLine();

			Exposant exposant = new Exposant(nom,GSM,mail);
			brocante.attribuerAutomatiquementEmplacement(exposant);
		}else{
			System.out.println("Plus d'emplacement libre");
		}

	}

	private static void afficherTout() {
		System.out.println(brocante);		
	}

}
