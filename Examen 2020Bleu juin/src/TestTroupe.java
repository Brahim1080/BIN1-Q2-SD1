
public class TestTroupe {
	
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
	
		System.out.print("Voici la troupe au depart : ");
		String[] tPatCP = {"loups","loupCP","castors","castorCP","aigles","aigleCP"};
		Troupe troupe = new Troupe(tPatCP);
		System.out.println(troupe.toString());
		
		System.out.println();
		System.out.println("D'abord des tests qui ne relevent pas de cas particuliers :");
		
		System.out.print("test1 ajout loup1 :");
		assertEquals("test1 ko : booleen renvoye ko ", true,troupe.ajouterScout("loup1","loups"));
		assertEquals("test1 ko : contenu ko ","loupCP loup1 castorCP aigleCP",formater(troupe.toString()));
		assertEquals("test1 ko : estScout ko ",true,troupe.estScout("loup1"));
		System.out.println(" ok");
		
		System.out.print("test2 ajout loup2 :");
		assertEquals("test2 ko : booleen renvoye ko ", true,troupe.ajouterScout("loup2","loups"));
		assertEquals("test2 ko : contenu ko ","loupCP loup2 loup1 castorCP aigleCP",formater(troupe.toString()));
		assertEquals("test2 ko : estScout ko ",true,troupe.estScout("loup2"));
		System.out.println(" ok");
		
		System.out.print("test3 ajout aigle1 :");
		assertEquals("test3 ko : booleen renvoye ko ", true,troupe.ajouterScout("aigle1","aigles"));
		assertEquals("test3 ko : contenu ko ","loupCP loup2 loup1 castorCP aigleCP aigle1",formater(troupe.toString()));
		assertEquals("test3 ko : estScout ko ",true,troupe.estScout("aigle1"));
		System.out.println(" ok");
		
		System.out.print("test4 ajout castor1 :");
		assertEquals("test4 ko : booleen renvoye ko ", true,troupe.ajouterScout("castor1","castors"));
		assertEquals("test4 ko : contenu ko ","loupCP loup2 loup1 castorCP castor1 aigleCP aigle1",formater(troupe.toString()));
		System.out.println(" ok");
		
		System.out.print("test5 ajout loup3 :");
		assertEquals("test5 ko : booleen renvoye ko ", true,troupe.ajouterScout("loup3","loups"));
		assertEquals("test5 ko : contenu ko ","loupCP loup3 loup2 loup1 castorCP castor1 aigleCP aigle1",formater(troupe.toString()));
		System.out.println(" ok");
		
		System.out.print("test6 ajout aigle2 :");
		assertEquals("test6 ko : booleen renvoye ko ", true,troupe.ajouterScout("aigle2","aigles"));
		assertEquals("test6 ko : contenu ko ","loupCP loup3 loup2 loup1 castorCP castor1 aigleCP aigle2 aigle1",formater(troupe.toString()));
		System.out.println(" ok");
		
		System.out.print("test7 suppression aigle1 :");
		assertEquals("test7 ko : booleen renvoye ko ", true,troupe.supprimerScout("aigle1"));
		assertEquals("test7 ko : contenu ko ","loupCP loup3 loup2 loup1 castorCP castor1 aigleCP aigle2",formater(troupe.toString()));
		assertEquals("test7 ko : estScout ko ",false,troupe.estScout("aigle1"));
		
		System.out.println(" ok");
		
		System.out.print("test8 suppression loup3 :");
		assertEquals("test8 ko : booleen renvoye ko ", true,troupe.supprimerScout("loup3"));
		assertEquals("test8 ko : contenu ko ","loupCP loup2 loup1 castorCP castor1 aigleCP aigle2",formater(troupe.toString()));
		assertEquals("test7 ko : estScout ko ",false,troupe.estScout("loup3"));
		System.out.println(" ok");
		
		System.out.print("test9 patrouille castors");
		assertEquals("test9 ko : contenu ko ","castorCP castor1",formater(troupe.donnerPatrouille("castors")));
		System.out.println(" ok");
		
		System.out.print("test10 patrouille loups");
		assertEquals("test10 ko : contenu ko ","loupCP loup2 loup1",formater(troupe.donnerPatrouille("loups")));
		System.out.println(" ok");
		
		System.out.print("test11 patrouille aigles");
		assertEquals("test11 ko : contenu ko ","aigleCP aigle2",formater(troupe.donnerPatrouille("aigles")));
		System.out.println(" ok");
		
		System.out.println();
		System.out.println("Maintenant des tests qui relevent de cas particuliers :");

		System.out.print("test12 ajout loup1 (scout existant):");
		assertEquals("test12 ko : booleen renvoye ko ", false,troupe.ajouterScout("loup1","loups"));
		assertEquals("test12 ko : contenu ko ","loupCP loup2 loup1 castorCP castor1 aigleCP aigle2",formater(troupe.toString()));
		assertEquals("test12 ko : estScout ko ",true,troupe.estScout("loup1"));
		System.out.println(" ok");
		
		System.out.print("test13 ajout lion1 (patrouille inexistante):");
		assertEquals("test13 ko : booleen renvoye ko ", false,troupe.ajouterScout("lion1","lions"));
		assertEquals("test13 ko : contenu ko ","loupCP loup2 loup1 castorCP castor1 aigleCP aigle2",formater(troupe.toString()));
		assertEquals("test13 ko : estScout ko ",false,troupe.estScout("lion1"));
		System.out.println(" ok");
		
		System.out.print("test14 suppression lion1 (scout inexistant):");
		assertEquals("test14 ko : booleen renvoye ko ", false,troupe.supprimerScout("lion1"));
		assertEquals("test14 ko : contenu ko ","loupCP loup2 loup1 castorCP castor1 aigleCP aigle2",formater(troupe.toString()));
		assertEquals("test14 ko : estScout ko ",false,troupe.estScout("lion1"));
		System.out.println(" ok");
		
		System.out.print("test15 suppression aigleCP (CP!):");
		assertEquals("test15 ko : booleen renvoye ko ", false,troupe.supprimerScout("aigleCP"));
		assertEquals("test15 ko : contenu ko ","loupCP loup2 loup1 castorCP castor1 aigleCP aigle2",formater(troupe.toString()));
		assertEquals("test15 ko : estScout ko ",true,troupe.estScout("aigleCP"));
		System.out.println(" ok");
		
		System.out.print("test16 patrouille lions (inexistante)");
		assertEquals("test16 ko : contenu ko ","",troupe.donnerPatrouille("lions"));
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
