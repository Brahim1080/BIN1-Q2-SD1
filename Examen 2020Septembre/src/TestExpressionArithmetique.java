import java.util.Scanner;


public class TestExpressionArithmetique {

	private final static Scanner scanner = new Scanner(System.in);

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
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	public static ExpressionArithmetique exp (int i){
		if(i==1){
			ExpressionArithmetique ag = new ExpressionArithmetique('3');
			ExpressionArithmetique ad = new ExpressionArithmetique('2');
			ExpressionArithmetique a = new ExpressionArithmetique('-', ag, ad);
			a = new ExpressionArithmetique('-', new ExpressionArithmetique(), a);
			ag = new ExpressionArithmetique('9');
			ad = new ExpressionArithmetique('3');
			ad = new ExpressionArithmetique('-', ag, ad);
			ag = new ExpressionArithmetique('4');
			ad = new ExpressionArithmetique('*', ag, ad);
			a = new ExpressionArithmetique('+', a, ad);
			return a;
		}		
		if(i==2){
			ExpressionArithmetique ag = new ExpressionArithmetique('8');
			ExpressionArithmetique ad = new ExpressionArithmetique('2');
			ExpressionArithmetique a = new ExpressionArithmetique('-', ag, ad);
			a = new ExpressionArithmetique('-', new ExpressionArithmetique(), a);
			ag = new ExpressionArithmetique('9');
			ad = new ExpressionArithmetique('3');
			ad = new ExpressionArithmetique('-', ag, ad);
			ag = new ExpressionArithmetique('4');
			ad = new ExpressionArithmetique('*', ag, ad);
			a = new ExpressionArithmetique('+', a, ad);
			return a;
		}
		if(i==3){
			ExpressionArithmetique a = exp(1);
			a = new ExpressionArithmetique('-',new ExpressionArithmetique(),a);
			return a;
		}
		return null;	
	}
	

	public static void main(String[] args) {

		System.out.println("****************************************************");
		System.out.println("Programme Test pour la classe ExpressionArithmetique");
		System.out.println("****************************************************");

		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode nombreMoins()");
			System.out.println("2 -> Tester la methode entiersTousDifferents()");

			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testNombreMoins();
				break;
			case 2:
				testEntiersTousDifferents();
				break;

			default:
				break;
			}

		} while (choix >= 1 && choix <= 2);

	}

	private static void testNombreMoins() {
		ExpressionArithmetique exp1 = exp(1);
		ExpressionArithmetique exp3 = exp(3);
		assertEquals("test exp1 nombre moins unaire: ko",1,exp1.nombreMoins(1));
		assertEquals("test exp1 nombre moins binaire: ko",2,exp1.nombreMoins(2));	
		assertEquals("test exp3 nombre moins unaire: ko",2,exp3.nombreMoins(1));
		assertEquals("test exp3 nombre moins binaire: ko",2,exp3.nombreMoins(2));
		try {
			exp1.nombreMoins(3);
			System.out.println("Attention, IllegalArgumentException non prevue");
			System.exit(0);	
		} catch (IllegalArgumentException e) {			
		}		
		System.out.println("Tous les tests ont reussi");
	}

	private static void testEntiersTousDifferents() {
		ExpressionArithmetique exp1 = exp(1);
		ExpressionArithmetique exp2 = exp(2);
		assertEquals("test exp1 tous differents: ko",false,exp1.entiersTousDifferents());
		assertEquals("test exp2 tous differents: ko",true,exp2.entiersTousDifferents());
		System.out.println("Tous les tests ont reussi");
	}

}
