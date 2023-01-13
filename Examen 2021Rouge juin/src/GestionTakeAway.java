import java.util.Scanner;

public class GestionTakeAway {

	private static Scanner scanner = new Scanner(System.in);
	private static TakeAway takeAway;

	public static void main(String[] args) {

		System.out.println("*******************************************************");
		System.out.println("Gestion des reservations des menus de dimanche prochain");
		System.out.println("*******************************************************");
		System.out.println();
		System.out.print("Entrez le nombre total de menus : ");
		int nombreTotalMenus= scanner.nextInt();
		scanner.nextLine();
		takeAway = new TakeAway(nombreTotalMenus);
		System.out.println();
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> afficher quelques informations sur l'etat des reservations");
			System.out.println("2 -> mettre un client dans la file d'attente");
			System.out.println("3 -> traiter le client en tete de la file d'attente");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				afficherInfo();
				break;
			case 2:
				mettreEnAttente();
				break;
			case 3:
				traiterClient();
				break;
			}

		} while (takeAway.getNombreMenusRestants()>0);
		System.out.println("Fin des reservations");
		System.out.println("Tous les menus sont reserves");	
	}

	private static void afficherInfo() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.println(takeAway);


	}

	private static void mettreEnAttente() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le client : ");
		String client = scanner.nextLine();
		if(takeAway.placerDansFileAttente(client)){
			System.out.println("Le client a ete mis en attente");
		}else{
			System.out.println("Le client n'a pas ete mis en attente");
		}

	}

	private static void traiterClient() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		String client = takeAway.selectionnerClientSuivant();
		if(client==null){
			System.out.println("Il n'y a actuellement aucun client en attente");
		}else{
			System.out.println("Le client traite est "+ client);
			System.out.println("Il reste actuellement "+ takeAway.getNombreMenusRestants() + " menus a reserver");
			System.out.println("Entrez le nombre de menus que vous desirez ( ou 0 pour arreter) : ");
			System.out.println("(Si vous avez deja fait une reservation, ce nombre sera ajoute au nombre de menus que vous avez deja reserves)");
			int nombreMenusDemandes = scanner.nextInt();
			if(nombreMenusDemandes>0){
				try{
					// le client a deja une reservation
					// --> modifierReservation()

					if(takeAway.modifierReservation(client, nombreMenusDemandes)){
						System.out.println("La demande a ete acceptee");
						System.out.println("La reservation a ete modifiee");
					}else{
						System.out.println("La demande n'a pas ete acceptee");
					}
				}
				catch (IllegalStateException e){
				}
				try{

					// le client n'a pas encore de reservation
					// --> passerNouvelleReservation()	

					if(takeAway.passerNouvelleReservation(client, nombreMenusDemandes)){
						System.out.println("La demande a ete acceptee");
						System.out.println("Une reservation a ete creee");
					}else{
						System.out.println("La demande n'a pas ete acceptee");
					}
				}
				catch (IllegalStateException e){
				}
			}

		}

	}

}
