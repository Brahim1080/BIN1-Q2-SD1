
public class TestEcole {
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println("\n"+messageErreur+". Attendu="+attendu+" reçu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println("\n"+messageErreur+". Attendu="+attendu+" reçu="+recu);
			System.exit(0);			
		}
	}
	
	public static void main(String args[]){	
	
		System.out.print("Voici l'ecole au depart : ");
		String[] tClasseInstit = {"1A","1Ainstit","1B","1Binstit","6A","6Ainstit"};
		Ecole ecole = new Ecole(tClasseInstit);
		System.out.println(ecole.toString());
		
		System.out.println();
		System.out.println("D'abord des tests qui ne relevent pas de cas particuliers :");
		
		System.out.print("test1 ajout 1Ael1 :");
		assertEquals("test1 ko : booleen renvoye ko ", true,ecole.ajouterEleve("1Ael1","1A"));
		assertEquals("test1 ko : contenu ko ","1Ainstit 1Ael1 1Binstit 6Ainstit",formater(ecole.toString()));
		assertEquals("test1 ko : estEleve ko ",true,ecole.estEleve("1Ael1"));
		System.out.println(" ok");
		
		System.out.print("test2 ajout 1Ael2 :");
		assertEquals("test2 ko : booleen renvoye ko ", true,ecole.ajouterEleve("1Ael2","1A"));
		assertEquals("test2 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 6Ainstit",formater(ecole.toString()));
		assertEquals("test2 ko : estEleve ko ",true,ecole.estEleve("1Ael2"));
		System.out.println(" ok");
		
		System.out.print("test3 ajout 6Ael1 :");
		assertEquals("test3 ko : booleen renvoye ko ", true,ecole.ajouterEleve("6Ael1","6A"));
		assertEquals("test3 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 6Ainstit 6Ael1",formater(ecole.toString()));
		assertEquals("test3 ko : estEleve ko ",true,ecole.estEleve("6Ael1"));
		System.out.println(" ok");
		
		System.out.print("test4 ajout 1Bel1 :");
		assertEquals("test4 ko : booleen renvoye ko ", true,ecole.ajouterEleve("1Bel1","1B"));
		assertEquals("test4 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael1",formater(ecole.toString()));
		System.out.println(" ok");
		
		System.out.print("test5 ajout 1Ael3 :");
		assertEquals("test5 ko : booleen renvoye ko ", true,ecole.ajouterEleve("1Ael3","1A"));
		assertEquals("test5 ko : contenu ko ","1Ainstit 1Ael3 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael1",formater(ecole.toString()));
		System.out.println(" ok");
		
		System.out.print("test6 ajout 6Ael2 :");
		assertEquals("test6 ko : booleen renvoye ko ", true,ecole.ajouterEleve("6Ael2","6A"));
		assertEquals("test6 ko : contenu ko ","1Ainstit 1Ael3 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2 6Ael1",formater(ecole.toString()));
		System.out.println(" ok");
		
		System.out.print("test7 suppression 6Ael1 :");
		assertEquals("test7 ko : booleen renvoye ko ", true,ecole.supprimerEleve("6Ael1"));
		assertEquals("test7 ko : contenu ko ","1Ainstit 1Ael3 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2",formater(ecole.toString()));
		assertEquals("test7 ko : estEleve ko ",false,ecole.estEleve("6Ael1"));
		
		System.out.println(" ok");
		
		System.out.print("test8 suppression 1Ael3 :");
		assertEquals("test8 ko : booleen renvoye ko ", true,ecole.supprimerEleve("1Ael3"));
		assertEquals("test8 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2",formater(ecole.toString()));
		assertEquals("test7 ko : estEleve ko ",false,ecole.estEleve("1Ael3"));
		System.out.println(" ok");
		
		System.out.print("test9 classe 1B");
		assertEquals("test9 ko : contenu ko ","1Bel1",formater(ecole.donnerClasse("1B")));
		System.out.println(" ok");
		
		System.out.print("test10 classe 1A");
		assertEquals("test10 ko : contenu ko ","1Ael2 1Ael1",formater(ecole.donnerClasse("1A")));
		System.out.println(" ok");
		
		System.out.print("test11 classe 6A");
		assertEquals("test11 ko : contenu ko ","6Ael2",formater(ecole.donnerClasse("6A")));
		System.out.println(" ok");
		
		System.out.println();
		System.out.println("Maintenant des tests qui relevent de cas particuliers :");

		System.out.print("test12 ajout 1Ael1 (eleve existant):");
		assertEquals("test12 ko : booleen renvoye ko ", false,ecole.ajouterEleve("1Ael1","1A"));
		assertEquals("test12 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2",formater(ecole.toString()));
		assertEquals("test12 ko : estEleve ko ",true,ecole.estEleve("1Ael1"));
		System.out.println(" ok");
		
		System.out.print("test13 ajout 3C1 (classe inexistante):");
		assertEquals("test13 ko : booleen renvoye ko ", false,ecole.ajouterEleve("3Cel1","3C"));
		assertEquals("test13 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2",formater(ecole.toString()));
		assertEquals("test13 ko : estEleve ko ",false,ecole.estEleve("3Cel1"));
		System.out.println(" ok");
		
		System.out.print("test14 suppression 3Bel1 (eleve inexistant):");
		assertEquals("test14 ko : booleen renvoye ko ", false,ecole.supprimerEleve("3Bel1"));
		assertEquals("test14 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2",formater(ecole.toString()));
		assertEquals("test14 ko : estEleve ko ",false,ecole.estEleve("3Bel1"));
		System.out.println(" ok");
		
		System.out.print("test15 suppression 6Ainstit (Instit!):");
		assertEquals("test15 ko : booleen renvoye ko ", false,ecole.supprimerEleve("6Ainstit"));
		assertEquals("test15 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2",formater(ecole.toString()));
		assertEquals("test15 ko : estEleve ko ",true,ecole.estInstituteur("6Ainstit"));
		System.out.println(" ok");
		
		System.out.print("test16 classe 4A (inexistante)");
		assertEquals("test16 ko : contenu ko ","",ecole.donnerClasse("4A"));
		System.out.println(" ok");
		
		System.out.print("test17 ajout 1Ainstit (Instit!):");
		assertEquals("test17 ko : booleen renvoye ko ", false,ecole.ajouterEleve("1Ainstit","1A"));
		assertEquals("test17 ko : contenu ko ","1Ainstit 1Ael2 1Ael1 1Binstit 1Bel1 6Ainstit 6Ael2",formater(ecole.toString()));
		assertEquals("test17 ko : estInstituteur ko ",true,ecole.estInstituteur("1Ainstit"));
		System.out.println(" ok");
		
		System.out.println();
		System.out.println("tous les tests ont reussi");

		
	}
	
	// supprime un espace eventuel en debut ou fin de chaine
	public static String formater(String str){
		if(str==null)
			return null;
		if(str.length()==0)
			return str;
		if(str.charAt(0)==' '){
			str = str.substring(1);
		}
		if(str.charAt(str.length()-1)==' '){
			str = str.substring(0,str.length()-1);
		}	
		return str;	
	}
}
