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
			ExpressionArithmetique a = new ExpressionArithmetique('-',ag,ad);			
			ag = new ExpressionArithmetique('9');
			ad = new ExpressionArithmetique('3');		
			ad = new ExpressionArithmetique('/',ag,ad);
			ag = new ExpressionArithmetique('4');
			ad = new ExpressionArithmetique('*',ag,ad);
			a = new ExpressionArithmetique('+',a,ad);		
			return a;
		}
		if(i==2){
			ExpressionArithmetique bg = new ExpressionArithmetique('4');
			ExpressionArithmetique bd = new ExpressionArithmetique('1');
			bd = new ExpressionArithmetique('-',bg,bd);
			bg = new ExpressionArithmetique('8');		
			bg = new ExpressionArithmetique('*',bg,bd);
			bd = new ExpressionArithmetique('4');
			bg = new ExpressionArithmetique('/',bg,bd);
			bd = new ExpressionArithmetique('1');
			bd = new ExpressionArithmetique('-',bg,bd);
			bg = new ExpressionArithmetique('4');
			ExpressionArithmetique b = new ExpressionArithmetique('+',bg,bd);
			return b;	
		}
		if(i==3){
			ExpressionArithmetique ag = new ExpressionArithmetique('3');
			ExpressionArithmetique ad = new ExpressionArithmetique('2');
			ExpressionArithmetique a = new ExpressionArithmetique('+',ag,ad);			
			ag = new ExpressionArithmetique('9');
			ad = new ExpressionArithmetique('3');		
			ad = new ExpressionArithmetique('+',ag,ad);
			ag = new ExpressionArithmetique('4');
			ad = new ExpressionArithmetique('+',ag,ad);
			a = new ExpressionArithmetique('+',a,ad);		
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
			System.out.println("1 -> Tester la methode nombreOperations()");
			System.out.println("2 -> Tester la methode uniquementDes()");
			System.out.println("3 -> Tester la methode nombreEntiersDifferents()");

			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testNombreOperations();
				break;
			case 2:
				testUniquementDes();
				break;
			case 3:
				testNombreEntiersDifferents();
				break;

			default:
				break;
			}

		} while (choix >= 1 && choix <= 3);

	}

	private static void testNombreOperations() {
		// TODO Auto-generated method stub
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 : ko",4,exp1.nombreOperations());
		ExpressionArithmetique exp2 = exp(2);
		assertEquals("test exp2 ko",5,exp2.nombreOperations());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
	}
	
	private static void testUniquementDes() {
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 - uniquement des + ko",false,exp1.uniquementDes('+'));
		ExpressionArithmetique exp3 = exp(3);
		assertEquals("test exp3 - uniquement des +  ko",true,exp3.uniquementDes('+'));
		assertEquals("test exp3 - uniquement des /  ko",false,exp3.uniquementDes('/'));
		try{
			exp3.uniquementDes('$');
			System.out.println("test exp3 ko, $ n'est pas un operateur, il fallait lancer une exception");
			System.exit(0);
		}catch(IllegalArgumentException e){
			
		}
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
	}
	
	private static void testNombreEntiersDifferents() {
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 ko",4,exp1.nombreEntiersDifferents());
		ExpressionArithmetique exp2 = exp(2);
		assertEquals("test exp2 ko",3,exp2.nombreEntiersDifferents());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
		
	}





}
