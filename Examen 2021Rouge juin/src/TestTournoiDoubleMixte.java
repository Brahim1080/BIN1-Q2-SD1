import java.util.Scanner;

public class TestTournoiDoubleMixte{
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
			
				System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
		
			System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	/**
	 * Cette methode appelle la methode assertEquals avec un message d'erreur adequat
	 * @param numeroMessage le numero du message a afficher en cas d'erreur
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(int numeroMessage, Object attendu, Object recu) {
		String[] message = new String[10];
		message[0]="Test ko, la methode n'a pas renvoye ce qui etait attendu";
		message[1]="Test ko, apres appel de la methode, le nombre d'elements dans le map n'est pas celui attendu";
		message[2]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens -->";
		message[3]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens <--";
		message[4]="Test ko, apres appel de la methode, la liste a ete modifiee";
		assertEquals(message[numeroMessage],attendu,recu);
	}
	
	public static void main(String[] args) {
		System.out.println("*****************************************************");
		System.out.println("Programme Test pour la classe ListeTournoiDoubleMixte");
		System.out.println("*****************************************************");
		int choix = 0;
		do {	
			System.out.println("1 -> Tester la methode nombreEtudiantsBloc()");
			System.out.println("2 -> Tester la methode sontTousEnInfo()");			
			System.out.println("3 -> Tester la methode donnerPartenaire()");
			System.out.println("4 -> Tester la methode ajouterCouple()");	
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testNombreEtudiantsBloc();
				break;
			case 2:
				testTousEnInfo();
				break;		
			case 3:
				testDonnerPartenaire();
				break;
			case 4:
				testAjouterCouple();
				break;

			default:
				break;
			}
		} while (choix >= 1 && choix <= 4 );	
		System.out.println();
		System.out.println("Fin des tests");
	}


	private static void testNombreEtudiantsBloc() {
		ListeTournoiDoubleMixte listeTournoi ;
		System.out.println();
	
		Etudiant[] tableTestee = new Etudiant[6];
		tableTestee[0] = new Etudiant("adam",'M',"INFO",1);
		tableTestee[1] = new Etudiant("eve",'F',"INFO",1);
		tableTestee[2] = new Etudiant("william",'M',"INFO",1);
		tableTestee[3] = new Etudiant("kate",'F',"INFO",1);
		tableTestee[4] = new Etudiant("serge",'M',"INFO",1);
		tableTestee[5] = new Etudiant("jane",'F',"INFO",1);
		
		System.out.println();
		System.out.println("Test1 : liste testee : adam(INFO 1) eve(INFO 1) william(INFO 1) kate(INFO 1) serge(INFO 1) jane(INFO 1) --> bloc 1");
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, 6 , listeTournoi.donnerNombreEtudiantsBloc(1));
		assertEquals(4, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam(INFO 1) eve(INFO 1) william(INFO 1) kate(INFO 1) serge(INFO 1) jane(INFO 1) --> bloc 2");
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, 0 , listeTournoi.donnerNombreEtudiantsBloc(2));
		assertEquals(4, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : liste testee : adam(INFO 1) eve(INFO 1) william(INFO 1) kate(INFO 2) serge(INFO 1) jane(INFO 3) --> bloc 1");
		tableTestee[3] = new Etudiant("kate",'F',"INFO",2);
		tableTestee[5] = new Etudiant("jane",'F',"INFO",3);
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, 4 , listeTournoi.donnerNombreEtudiantsBloc(1));
		System.out.println("Test ok");	
		
		System.out.println();
		System.out.println("Test4 : liste testee : liste vide --> bloc 1");
		listeTournoi = new ListeTournoiDoubleMixte();	
		assertEquals(0, 0 , listeTournoi.donnerNombreEtudiantsBloc(1));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
		
	}

	private static void testTousEnInfo() {
		ListeTournoiDoubleMixte listeTournoi ;
		System.out.println();
	
		Etudiant[] tableTestee = new Etudiant[6];
		tableTestee[0] = new Etudiant("adam",'M',"INFO",1);
		tableTestee[1] = new Etudiant("eve",'F',"INFO",1);
		tableTestee[2] = new Etudiant("william",'M',"INFO",1);
		tableTestee[3] = new Etudiant("kate",'F',"INFO",1);
		tableTestee[4] = new Etudiant("serge",'M',"INFO",1);
		tableTestee[5] = new Etudiant("jane",'F',"INFO",1);
		
		System.out.println();
		System.out.println("Test1 : liste testee : adam(INFO 1) eve(INFO 1) william(INFO 1) kate(INFO 1) serge(INFO 1) jane(INFO 1)");
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, true, listeTournoi.sontTousEnSectionInfo());
		assertEquals(4, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam(INFO 1) eve(INFO 1) william(INFO 1) kate(DIET 2) serge(INFO 1) jane(INFO 1)");
		tableTestee[3] = new Etudiant("kate",'F',"DIET",2);
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, false, listeTournoi.sontTousEnSectionInfo());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test3 : liste testee : adam(IMAG 1) eve(INFO 1) william(INFO 1) kate(INFO 1) serge(INFO 1) jane(INFO 1)");
		tableTestee[0] = new Etudiant("adam",'M',"IMAG",1);
		tableTestee[3] = new Etudiant("kate",'F',"INFO",1);
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, false, listeTournoi.sontTousEnSectionInfo());
		System.out.println("Test ok");
			
		System.out.println();
		System.out.println("Test4 : liste testee : adam(INFO 1) eve(INFO 1) william(INFO 1) kate(INFO 1) serge(INFO 1) jane(IMAG 1)");
		tableTestee[0] = new Etudiant("adam",'M',"INFO",1);
		tableTestee[5] = new Etudiant("jane",'F',"IMAG",1);
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, false, listeTournoi.sontTousEnSectionInfo());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : liste testee : liste vide");
		listeTournoi = new ListeTournoiDoubleMixte();	
		assertEquals(0, true, listeTournoi.sontTousEnSectionInfo());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
	}


	private static void testDonnerPartenaire() {
		ListeTournoiDoubleMixte listeTournoi ;
		System.out.println();
			
		Etudiant[] tableTestee = new Etudiant[6];
		tableTestee[0] = new Etudiant("adam",'M',"INFO",1);
		tableTestee[1] = new Etudiant("eve",'F',"INFO",1);
		tableTestee[2] = new Etudiant("william",'M',"INFO",1);
		tableTestee[3] = new Etudiant("kate",'F',"INFO",1);
		tableTestee[4] = new Etudiant("serge",'M',"INFO",1);
		tableTestee[5] = new Etudiant("jane",'F',"INFO",1);
		
		Etudiant kate = new Etudiant("kate",'F',"INFO",1);
		Etudiant william = new Etudiant("william",'M',"INFO",1);
		Etudiant eve = new Etudiant("eve",'F',"INFO",1);
		Etudiant adam = new Etudiant("adam",'M',"INFO",1);
		Etudiant jane = new Etudiant("jane",'F',"INFO",1);
		Etudiant serge = new Etudiant("serge",'M',"INFO",1);
		Etudiant pierre = new Etudiant("pierre",'M',"INFO",1);
		
		
		System.out.println();
		System.out.println("Test1 : liste testee : adam eve william kate serge jane : donnerPartenaire william");
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);	
		assertEquals(0, kate, listeTournoi.donnerPartenaire(william));
		assertEquals(4, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam eve william kate serge jane : donnerPartenaire kate");	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		assertEquals(0, william, listeTournoi.donnerPartenaire(kate));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : liste testee : adam eve william kate serge jane : donnerPartenaire serge");	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		assertEquals(0, jane, listeTournoi.donnerPartenaire(serge));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test4 : liste testee : adam eve william kate serge jane : donnerPartenaire eve");	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		assertEquals(0, adam, listeTournoi.donnerPartenaire(eve));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : liste testee : adam eve william kate serge jane : donnerPartenaire pierre");	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		assertEquals(0, null, listeTournoi.donnerPartenaire(pierre));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testAjouterCouple() {
		
		ListeTournoiDoubleMixte listeTournoi ;
		System.out.println();
			
		Etudiant[] tableTestee = new Etudiant[6];
		tableTestee[0] = new Etudiant("adam",'M',"INFO",1);
		tableTestee[1] = new Etudiant("eve",'F',"INFO",1);
		tableTestee[2] = new Etudiant("william",'M',"INFO",1);
		tableTestee[3] = new Etudiant("kate",'F',"INFO",1);
		tableTestee[4] = new Etudiant("serge",'M',"INFO",1);
		tableTestee[5] = new Etudiant("jane",'F',"INFO",1);
			
		System.out.println();
		System.out.println("Test1 : liste testee : adam eve william kate serge jane : ajouterCouple philippe mathilde");
	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		
		assertEquals(0, true, listeTournoi.ajouterCouple(new Etudiant("philippe", 'M', "INFO",1),new Etudiant("mathilde",'F',"INFO",1)));
		assertEquals(1, 8, listeTournoi.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane,philippe,mathilde)", listeTournoi.teteQueue());
		assertEquals(3, "(mathilde,philippe,jane,serge,kate,william,eve,adam)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam eve william kate serge jane : ajouterCouple mathilde philippe");
	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		
		assertEquals(0, true, listeTournoi.ajouterCouple(new Etudiant("mathilde",'F',"INFO",1),new Etudiant("philippe", 'M', "INFO",1)));
		assertEquals(1, 8, listeTournoi.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane,philippe,mathilde)", listeTournoi.teteQueue());
		assertEquals(3, "(mathilde,philippe,jane,serge,kate,william,eve,adam)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test3 : liste testee : adam eve william kate serge jane : ajouterCouple william marie");
	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		
		assertEquals(0, false, listeTournoi.ajouterCouple(new Etudiant("william",'M',"INFO",1),new Etudiant("marie", 'F', "INFO",1)));
		assertEquals(1, 6, listeTournoi.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test4 : liste testee : adam eve william kate serge jane : ajouterCouple pierre jane");
	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		
		assertEquals(0, false, listeTournoi.ajouterCouple(new Etudiant("pierre",'M',"INFO",1),new Etudiant("jane", 'F', "INFO",1)));
		assertEquals(1, 6, listeTournoi.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : liste testee : adam eve william kate serge jane : ajouterCouple pierre paul");
	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		
		assertEquals(0, false, listeTournoi.ajouterCouple(new Etudiant("pierre",'M',"INFO",1),new Etudiant("paul", 'M', "INFO",1)));
		assertEquals(1, 6, listeTournoi.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test6 : liste testee : adam eve william kate serge jane : ajouterCouple anne marie");
	
		listeTournoi = new ListeTournoiDoubleMixte(tableTestee);
		
		assertEquals(0, false, listeTournoi.ajouterCouple(new Etudiant("anne",'F',"INFO",1),new Etudiant("marie", 'F', "INFO",1)));
		assertEquals(1, 6, listeTournoi.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeTournoi.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test7 : liste testee : liste vide : ajouterCouple philippe mathilde");
		
		listeTournoi = new ListeTournoiDoubleMixte();
		
		assertEquals(0, true, listeTournoi.ajouterCouple(new Etudiant("philippe",'M',"INFO",1),new Etudiant("mathilde", 'F', "INFO",1)));
		assertEquals(1, 2, listeTournoi.taille());
		assertEquals(2, "(philippe,mathilde)", listeTournoi.teteQueue());
		assertEquals(3, "(mathilde,philippe)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test8 : liste testee : liste vide : ajouterCouple mathilde philippe");
		
		listeTournoi = new ListeTournoiDoubleMixte();
		
		assertEquals(0, true, listeTournoi.ajouterCouple(new Etudiant("mathilde", 'F', "INFO",1),new Etudiant("philippe",'M',"INFO",1)));
		assertEquals(1, 2, listeTournoi.taille());
		assertEquals(2, "(philippe,mathilde)", listeTournoi.teteQueue());
		assertEquals(3, "(mathilde,philippe)", listeTournoi.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
	}

}
