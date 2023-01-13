
public class TestBloc {
	
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
	
		System.out.print("Voici le bloc au depart : ");
		String[] tSerieDeleg = {"2I1","2I1deleg","2I2","2I2deleg","2I3","2I3deleg"};
		Bloc bloc = new Bloc(tSerieDeleg);
		System.out.println(bloc.toString());
		
		System.out.println();
		System.out.println("D'abord des tests qui ne relevent pas de cas particuliers :");
		
		System.out.print("test1 ajout 2I1et1 :");
		assertEquals("test1 ko : booleen renvoye ko ", true,bloc.ajouterEtudiant("2I1et1","2I1"));
		assertEquals("test1 ko : contenu ko ","2I1deleg 2I1et1 2I2deleg 2I3deleg",formater(bloc.toString()));
		assertEquals("test1 ko : estEtudiant ko ",true,bloc.estEtudiant("2I1et1"));
		System.out.println(" ok");
		
		System.out.print("test2 ajout 2I1et2 :");
		assertEquals("test2 ko : booleen renvoye ko ", true,bloc.ajouterEtudiant("2I1et2","2I1"));
		assertEquals("test2 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I3deleg",formater(bloc.toString()));
		assertEquals("test2 ko : estEtudiant ko ",true,bloc.estEtudiant("2I1et2"));
		System.out.println(" ok");
		
		System.out.print("test3 ajout 2I3et1 :");
		assertEquals("test3 ko : booleen renvoye ko ", true,bloc.ajouterEtudiant("2I3et1","2I3"));
		assertEquals("test3 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I3deleg 2I3et1",formater(bloc.toString()));
		assertEquals("test3 ko : estEtudiant ko ",true,bloc.estEtudiant("2I3et1"));
		System.out.println(" ok");
		
		System.out.print("test4 ajout 2I2et1 :");
		assertEquals("test4 ko : booleen renvoye ko ", true,bloc.ajouterEtudiant("2I2et1","2I2"));
		assertEquals("test4 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et1",formater(bloc.toString()));
		System.out.println(" ok");
		
		System.out.print("test5 ajout 2I1et3 :");
		assertEquals("test5 ko : booleen renvoye ko ", true,bloc.ajouterEtudiant("2I1et3","2I1"));
		assertEquals("test5 ko : contenu ko ","2I1deleg 2I1et3 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et1",formater(bloc.toString()));
		System.out.println(" ok");
		
		System.out.print("test6 ajout 2I3et2 :");
		assertEquals("test6 ko : booleen renvoye ko ", true,bloc.ajouterEtudiant("2I3et2","2I3"));
		assertEquals("test6 ko : contenu ko ","2I1deleg 2I1et3 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et2 2I3et1",formater(bloc.toString()));
		System.out.println(" ok");
		
		System.out.print("test7 suppression 2I3et1 :");
		assertEquals("test7 ko : booleen renvoye ko ", true,bloc.supprimerEtudiant("2I3et1"));
		assertEquals("test7 ko : contenu ko ","2I1deleg 2I1et3 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et2",formater(bloc.toString()));
		assertEquals("test7 ko : estEtudiant ko ",false,bloc.estEtudiant("2I3et1"));
		
		System.out.println(" ok");
		
		System.out.print("test8 suppression 2I1et3 :");
		assertEquals("test8 ko : booleen renvoye ko ", true,bloc.supprimerEtudiant("2I1et3"));
		assertEquals("test8 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et2",formater(bloc.toString()));
		assertEquals("test7 ko : estEtudiant ko ",false,bloc.estEtudiant("2I1et3"));
		System.out.println(" ok");
		
		System.out.print("test9 serie 2I2");
		assertEquals("test9 ko : contenu ko ","2I2deleg 2I2et1",formater(bloc.donnerSerie("2I2")));
		System.out.println(" ok");
		
		System.out.print("test10 serie 2I1");
		assertEquals("test10 ko : contenu ko ","2I1deleg 2I1et2 2I1et1",formater(bloc.donnerSerie("2I1")));
		System.out.println(" ok");
		
		System.out.print("test11 serie 2I3");
		assertEquals("test11 ko : contenu ko ","2I3deleg 2I3et2",formater(bloc.donnerSerie("2I3")));
		System.out.println(" ok");
		
		System.out.println();
		System.out.println("Maintenant des tests qui relevent de cas particuliers :");

		System.out.print("test12 ajout 2I1et1 (etudiant existant):");
		assertEquals("test12 ko : booleen renvoye ko ", false,bloc.ajouterEtudiant("2I1et1","2I1"));
		assertEquals("test12 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et2",formater(bloc.toString()));
		assertEquals("test12 ko : estEtudiant ko ",true,bloc.estEtudiant("2I1et1"));
		System.out.println(" ok");
		
		System.out.print("test13 ajout 3I1et1 (serie inexistante):");
		assertEquals("test13 ko : booleen renvoye ko ", false,bloc.ajouterEtudiant("3I1et1","3I1"));
		assertEquals("test13 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et2",formater(bloc.toString()));
		assertEquals("test13 ko : estEtudiant ko ",false,bloc.estEtudiant("3I1et1"));
		System.out.println(" ok");
		
		System.out.print("test14 suppression 2I1etX (etudiant inexistant):");
		assertEquals("test14 ko : booleen renvoye ko ", false,bloc.supprimerEtudiant("2I1etX"));
		assertEquals("test14 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et2",formater(bloc.toString()));
		assertEquals("test14 ko : estEtudiant ko ",false,bloc.estEtudiant("2I1etX"));
		System.out.println(" ok");
		
		System.out.print("test15 suppression 2I3deleg (delegue!):");
		assertEquals("test15 ko : booleen renvoye ko ", false,bloc.supprimerEtudiant("2I3deleg"));
		assertEquals("test15 ko : contenu ko ","2I1deleg 2I1et2 2I1et1 2I2deleg 2I2et1 2I3deleg 2I3et2",formater(bloc.toString()));
		assertEquals("test15 ko : estEtudiant ko ",true,bloc.estEtudiant("2I3deleg"));
		System.out.println(" ok");
		
		System.out.print("test16 serie 3I1 (inexistante)");
		assertEquals("test16 ko : contenu ko ","",bloc.donnerSerie("3I1"));
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
