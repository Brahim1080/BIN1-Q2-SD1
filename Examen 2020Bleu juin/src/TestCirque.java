import java.util.ArrayList;


public class TestCirque {
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
				System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
				System.exit(0);
				
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
			System.exit(0);		
		}
	}
	
	public static void main(String[] args) {
		
		
		Cirque cirque = new Cirque(10,3);		
		assertEquals("Au depart ko","[null, null, null, null, null, null, null, null, null, null]", cirque.toString());
		
		System.out.println("Reservations enfants - au depart : cirque vide - 10 places - 3 enfants");
		System.out.println("test 1 : 3 enfants libres - reservation 2 enfants - la reservation doit reussir");
		ArrayList<Integer> l1 = cirque.reserverEnfant("a", 2);
		assertEquals("test 1 ko","[0, 1]", l1.toString());
		assertEquals("test 1 ko","[a, a, null, null, null, null, null, null, null, null]", cirque.toString());
		
		System.out.println("test 2 : 1 enfant libre - reservation 2 enfants - la reservation doit echouer");
		ArrayList<Integer> l2 = cirque.reserverEnfant("b", 2);
		assertEquals("test 2 ko",null,l2);
		assertEquals("test 2 ko","[a, a, null, null, null, null, null, null, null, null]", cirque.toString());
		
		System.out.println("test 3 : 1 enfant libre - reservation 1 enfant - la reservation doit reussir");
		ArrayList<Integer> l3 = cirque.reserverEnfant("c", 1);
		assertEquals("test 3 ko","[2]",l3.toString());
		assertEquals("test 3 ko","[a, a, c, null, null, null, null, null, null, null]", cirque.toString());
		
		System.out.println("les tests de reservations d'enfants ont reussi");
		
		cirque = new Cirque(10,3);
		System.out.println();
		System.out.println("Reservations adultes au depart : cirque vide - 10 places - 3 enfants");
		System.out.println("test 4 : reservation adulte (4,5,7) - la reservation doit reussir");
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(5);
		l4.add(7);
		assertEquals("test 4 ko",true,cirque.reserverAdulte("a",l4 ));
		assertEquals("test 4 ko","[null, null, null, null, a, a, null, a, null, null]", cirque.toString());	
		
		System.out.println("test 5 : reservation adulte (3) - la reservation doit reussir");
		ArrayList<Integer> l5 = new ArrayList<Integer>();
		l5.add(3);
		assertEquals("test 5 ko",true,cirque.reserverAdulte("b",l5 ));
		assertEquals("test 5 ko","[null, null, null, b, a, a, null, a, null, null]", cirque.toString());
		
		
		System.out.println("test 6 : reservation adulte (2) - la reservation doit echouer (place enfant)");
		ArrayList<Integer> l6 = new ArrayList<Integer>();
		l6.add(2);
		assertEquals("test 6 ko",false,cirque.reserverAdulte("c",l6 ));
		assertEquals("test 6 ko","[null, null, null, b, a, a, null, a, null, null]", cirque.toString());
		
		
		System.out.println("test 7 : reservation adulte (5) - la reservation doit echouer (place deja reservee)");
		ArrayList<Integer> l7 = new ArrayList<Integer>();
		l7.add(5);
		assertEquals("test 7 ko",false,cirque.reserverAdulte("c",l7 ));
		assertEquals("test 7 ko","[null, null, null, b, a, a, null, a, null, null]", cirque.toString());
		
		System.out.println("test 8 : reservation adulte (5) - la reservation doit echouer (pas de reservation partielle)");
		ArrayList<Integer> l8 = new ArrayList<Integer>();
		l8.add(6);
		l8.add(7);
		assertEquals("test 8 ko",false,cirque.reserverAdulte("c",l8 ));
		assertEquals("test 8 ko","[null, null, null, b, a, a, null, a, null, null]", cirque.toString());
		
		
		System.out.println("test 9 : reservation adulte (6,8,9) - la reservation doit reussir");
		ArrayList<Integer> l9 = new ArrayList<Integer>();
		l9.add(6);
		l9.add(8);
		l9.add(9);
		assertEquals("test 9 ko",true,cirque.reserverAdulte("c",l9 ));
		assertEquals("test 9 ko","[null, null, null, b, a, a, c, a, c, c]", cirque.toString());
		
//		System.out.println("test 10 : reservation adulte (10) - la reservation doit echouer (pas 10)");
//		ArrayList<Integer> l10 = new ArrayList<Integer>();
//		l10.add(10);
//		assertEquals("test 10 ko",false,cirque.reserverAdulte("d",l10 ));
//		assertEquals("test 10 ko","[null, null, null, b, a, a, c, a, c, c]", cirque.toString());
	
		System.out.println("test 11 : reservation adulte (-1) - la reservation doit echouer (pas -1)");
		ArrayList<Integer> l11 = new ArrayList<Integer>();
		l11.add(-1);
		assertEquals("test 11 ko",false,cirque.reserverAdulte("d",l11 ));
		assertEquals("test 11 ko","[null, null, null, b, a, a, c, a, c, c]", cirque.toString());
		
		
		System.out.println("les tests de reservations d'adultes ont reussi");
		
		System.out.println();
		System.out.println("Reservations automatiques - au depart cirque vide : 3 places");
			
		cirque = new Cirque(3,0);
		cirque.changerPhase();
		
		System.out.println("test 12 : reservation 0? - a");
		assertEquals("test 12 ko",0,cirque.attribuerAutomatiquementPlace("a"));
		assertEquals("test 12 ko","[a, null, null]", cirque.toString());
		
		System.out.println("test 13 : reservation 1? - b");
		assertEquals("test 13 ko",1,cirque.attribuerAutomatiquementPlace("b"));
		assertEquals("test 13 ko","[a, b, null]", cirque.toString());
		
		System.out.println("test 14 : reservation 2? - c");
		assertEquals("test 14 ko",2,cirque.attribuerAutomatiquementPlace("c"));
		assertEquals("test 14 ko","[a, b, c]", cirque.toString());
		
		System.out.println("test 14 : plus de place");
		assertEquals("test 14 ko",-1,cirque.attribuerAutomatiquementPlace("d"));
		assertEquals("test 14 ko","[a, b, c]", cirque.toString());
		
		System.out.println();
		System.out.println("Reservations automatiques - au depart cirque 10 places avec quelques reservations");
		System.out.println("10 places dont 3 enfants. Les places 0, 1, 4, 5, 6, 7 et 8 sont occupees via phase 1");
		System.out.println("Les places libres sont : 2, 3 et 9");
		
		cirque = new Cirque(10,3);	
		cirque.reserverEnfant("a", 2);
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);	
		cirque.reserverAdulte("b",l);
		System.out.println("Les reservations se sont faites via les methodes de la phase 1.");
		assertEquals("probleme rencontre lors de ces reservations","[a, a, null, null, b, b, b, b, b, null]", cirque.toString());
		
		cirque.changerPhase();
		
		System.out.println("test 14 : reservation 2? - c");
		assertEquals("test 14 ko",2,cirque.attribuerAutomatiquementPlace("c"));
		assertEquals("test 14 ko","[a, a, c, null, b, b, b, b, b, null]", cirque.toString());

		System.out.println("test 15 : reservation 3? - d");
		assertEquals("test 15 ko",3,cirque.attribuerAutomatiquementPlace("d"));
		assertEquals("test 15 ko","[a, a, c, d, b, b, b, b, b, null]", cirque.toString());
		
		System.out.println("test 16 : reservation 9? - e");
		assertEquals("test 16 ko",9,cirque.attribuerAutomatiquementPlace("e"));
		assertEquals("test 16 ko","[a, a, c, d, b, b, b, b, b, e]", cirque.toString());
		
		System.out.println("test 17 : plus de place");
		assertEquals("test 17 ko",-1,cirque.attribuerAutomatiquementPlace("f"));
		assertEquals("test 17 ko","[a, a, c, d, b, b, b, b, b, e]", cirque.toString());
		
		System.out.println("les tests de reservations automatiques ont reussi");
		System.out.println();
		System.out.println("Tous les tests ont reussi");
	}	
}
