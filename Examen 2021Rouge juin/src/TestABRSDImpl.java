import java.util.Scanner;


public class TestABRSDImpl {
	
	private static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		
		System.out.println("************************");
		System.out.println("Programme Test ABRSDImpl");
		System.out.println("************************");
		int choix= 0;
	
		do {
			System.out.println();
			System.out.println("1 ->  Tester la methode elementLePlusPetit()");
			System.out.println("2 ->  Tester la methode insere()");
			System.out.println("3 ->  Tester la methode elementPrecedent()");
		
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch (choix) {
			
			case 1:
				testElementLePlusPetit();
				break;
			case 2:
				testInsere();
				break;
			case 3:
				testElementPrecedent();
				break;
		
			default:
				break;
			}
		} while (choix >= 1 && choix <= 3);

	}


	private static void testElementLePlusPetit() {
		System.out.println();
		System.out.println("Test elementLePlusPetit() avec l'ensemble de l'enonce");
		ABRSDImpl<String> e = new ABRSDImpl<String>("lea","anouk","zoe","sam","hugo","tim","marie");
		String nomTrouve = e.elementLePlusPetit();
		if(nomTrouve==null){
			System.out.println("Attention, votre methode a renvoye null pour l'ensemble de l'enonce");
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(!nomTrouve.equals("anouk")){
			System.out.println("Attention, votre methode a renvoye "+ nomTrouve);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println("Le test avec l'ensemble de l'enonce a reussi !");
		
		System.out.println();
		System.out.println("Test elementLePlusPetit() avec l'ensemble vide");
		ABRSDImpl<String> eVide = new ABRSDImpl<String>();
		nomTrouve = eVide.elementLePlusPetit();
		if(nomTrouve!=null){
			System.out.println("Attention, votre methode n'a pas renvoye null pour l'ensemble vide");
			System.out.println("Revoyez votre methode !");		
			return;
		}
		
		System.out.println("Le test avec l'ensemble vide a reussi !");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi !");
		
			
	}

	private static void testInsere() {
		System.out.println();
		System.out.println("Test insere() en partant de l'arbre vide et en construisant l'ensemble de l'enonce");
		System.out.println("Les ajouts se feront selon l'ordre : lea anouk zoe sam hugo tim marie");
		ABRSDImpl<String> e = new ABRSDImpl<String>();
		
		e.insere("lea");
		if(!e.toString().equals("[ lea ]")){
			System.out.println("Attention apres ajout de lea, l'arbre que vous avez obtenu est ");
			System.out.println(e.toString());
			System.out.println("Il devrait etre [ lea ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(e.taille()!=1){
			System.out.println("Attention apres ajout de lea, l'arbre que vous avez obtenu est ok et contient lea");	
			System.out.println("Mais la taille n'est pas correcte : "+ e.taille());
			System.out.println("Avez-vous pense a mettre a jour l'attribut taille ?");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println(e.toString());
		
		e.insere("anouk");
		if(!e.toString().equals("[  [ anouk ] lea [ ]  ]")){
			System.out.println("Attention apres ajout de anouk, l'arbre que vous avez obtenu est ");
			System.out.println(e.toString());
			System.out.println("Il devrait etre [  [ anouk ] lea [ ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(e.taille()!=2){
			System.out.println("Attention apres ajout de anouk, l'arbre que vous avez obtenu est ok et contient anouk lea");	
			System.out.println("Mais la taille n'est pas correcte : "+ e.taille());
			System.out.println("Avez-vous pense a mettre a jour l'attribut taille ?");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println(e.toString());
		
		e.insere("zoe");
		if(!e.toString().equals("[  [ anouk ] lea [ zoe ]  ]")){
			System.out.println("Attention apres ajout de zoe, l'arbre que vous avez obtenu est ");
			System.out.println(e.toString());
			System.out.println("Il devrait etre [  [ anouk ] lea [ zoe ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(e.taille()!=3){
			System.out.println("Attention apres ajout de anouk, l'arbre que vous avez obtenu est ok et contient anouk lea zoe");	
			System.out.println("Mais la taille n'est pas correcte : "+ e.taille());
			System.out.println("Avez-vous pense a mettre a jour l'attribut taille ?");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println(e.toString());
		
		e.insere("sam");
		if(!e.toString().equals("[  [ anouk ] lea [  [ sam ] zoe [ ]  ]  ]")){
			System.out.println("Attention apres ajout de sam, l'arbre que vous avez obtenu est ");
			System.out.println(e.toString());
			System.out.println("Il devrait etre [  [ anouk ] lea [  [ sam ] zoe [ ]  ]  ] ");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(e.taille()!=4){
			System.out.println("Attention apres ajout de sam, l'arbre que vous avez obtenu est ok et contient anouk lea sam zoe");	
			System.out.println("Mais la taille n'est pas correcte : "+ e.taille());
			System.out.println("Avez-vous pense a mettre a jour l'attribut taille ?");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println(e.toString());
		
		e.insere("hugo");
		if(!e.toString().equals("[  [  [ ] anouk [ hugo ]  ] lea [  [ sam ] zoe [ ]  ]  ]")){
			System.out.println("Attention apres ajout de hugo, l'arbre que vous avez obtenu est ");
			System.out.println(e.toString());
			System.out.println("Il devrait etre [  [  [ ] anouk [ hugo ]  ] lea [  [ sam ] zoe [ ]  ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(e.taille()!=5){
			System.out.println("Attention apres ajout de hugo, l'arbre que vous avez obtenu est ok et contient anouk hugo lea sam zoe");	
			System.out.println("Mais la taille n'est pas correcte : "+ e.taille());
			System.out.println("Avez-vous pense a mettre a jour l'attribut taille ?");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println(e.toString());
		
		e.insere("tim");
		if(!e.toString().equals("[  [  [ ] anouk [ hugo ]  ] lea [  [  [ ] sam [ tim ]  ] zoe [ ]  ]  ]")){
			System.out.println("Attention apres ajout de tim, l'arbre que vous avez obtenu est ");
			System.out.println(e.toString());
			System.out.println("Il devrait etre [  [  [ ] anouk [ hugo ]  ] lea [  [  [ ] sam [ tim ]  ] zoe [ ]  ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println(e.toString());
		
		e.insere("marie");
		if(!e.toString().equals("[  [  [ ] anouk [ hugo ]  ] lea [  [  [ marie ] sam [ tim ]  ] zoe [ ]  ]  ]")){
			System.out.println("Attention apres ajout de marie, l'arbre que vous avez obtenu est ");
			System.out.println(e.toString());
			System.out.println("Il devrait etre [  [  [ ] anouk [ hugo ]  ] lea [  [  [ marie ] sam [ tim ]  ] zoe [ ]  ]  ]");
			System.out.println();
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println(e.toString());
		
		System.out.println();
		System.out.println("Tous les tests ont reussi !");
		
	}

	
	private static void testElementPrecedent() {
		System.out.println();
		System.out.println("Test elementPrecedent() avec l'ensemble de l'enonce");
		ABRSDImpl<String> e = new ABRSDImpl<String>("lea","anouk","zoe","sam","hugo","tim","marie");
		String nom, nomPrec, nomTrouve;
		nom = "hugo";
		nomPrec = "anouk";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve==null){
			System.out.println("Attention, votre methode a renvoye null");
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(!nomTrouve.equals(nomPrec)){
			System.out.println("Attention, votre methode a renvoye "+ nomTrouve);
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}	
		
		nom = "lea";
		nomPrec = "hugo";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve==null){
			System.out.println("Attention, votre methode a renvoye null");
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(!nomTrouve.equals(nomPrec)){
			System.out.println("Attention, votre methode a renvoye "+ nomTrouve);
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}	
		
		nom = "marie";
		nomPrec = "lea";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve==null){
			System.out.println("Attention, votre methode a renvoye null");
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(!nomTrouve.equals(nomPrec)){
			System.out.println("Attention, votre methode a renvoye "+ nomTrouve);
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}	
		
		nom = "sam";
		nomPrec = "marie";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve==null){
			System.out.println("Attention, votre methode a renvoye null");
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(!nomTrouve.equals(nomPrec)){
			System.out.println("Attention, votre methode a renvoye "+ nomTrouve);
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}	
		
		nom = "tim";
		nomPrec = "sam";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve==null){
			System.out.println("Attention, votre methode a renvoye null");
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(!nomTrouve.equals(nomPrec)){
			System.out.println("Attention, votre methode a renvoye "+ nomTrouve);
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		
		nom = "zoe";
		nomPrec = "tim";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve==null){
			System.out.println("Attention, votre methode a renvoye null");
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		if(!nomTrouve.equals(nomPrec)){
			System.out.println("Attention, votre methode a renvoye "+ nomTrouve);
			System.out.println("Le elementPrecedent de "+ nom + " est "+ nomPrec);
			System.out.println("Revoyez votre methode !");		
			return;
		}	
		
		nom = "anouk";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve!=null){	
			System.out.println("anouk n'a pas de elementPrecedent");
			System.out.println("Attention, votre methode n'a pas renvoye null");
			System.out.println("Votre methode a renvoye "+ nomTrouve);
			System.out.println("Revoyez votre methode !");		
			return;
		}
			
		nom = "bob";
		nomTrouve = e.elementPrecedent(nom);
		if(nomTrouve!=null){
			System.out.println("bob n'a pas de elementPrecedent, car il n'est pas dans l'ensemble");
			System.out.println("Attention, votre methode n'a pas renvoye null");
			System.out.println("Votre methode a renvoye "+ nomTrouve);
			System.out.println("Revoyez votre methode !");		
			return;
		}
		System.out.println("Tous les tests avec l'ensemble de l'enonce ont reussi !");
		
		System.out.println();
		
		
		System.out.println("Test elementPrecedent() avec l'ensemble vide");
		ABRSDImpl<String> eVide = new ABRSDImpl<String>();
		nom = "lea";
		if(eVide.elementPrecedent(nom)!=null){	
			System.out.println("anouk n'appartient pas a l'ensemble et n'a donc pas de elementPrecedent");
			System.out.println("Attention, votre methode n'a pas renvoye null");
			System.out.println("Votre methode a renvoye "+ nomTrouve);
			System.out.println("Revoyez votre methode !");
			return;
		}
		
		System.out.println("Le test avec l'ensemble vide a reussi !");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

}

