
public class TestFeteNationale {
	
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
	
		System.out.print("Voici la liste au depart : ");
		FeteNationale liste = new FeteNationale("n1","j1","r1");
		System.out.println(liste.toString());
		System.out.println();
		
		try{
			System.out.print("couleur n1 ? ");
			assertEquals("test ko", 'n', liste.donnerCouleur("n1"));
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, n1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		try{
			System.out.print("couleur j1 ? ");
			assertEquals("test ko", 'j', liste.donnerCouleur("j1"));
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, j1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		try{
			System.out.print("couleur r1 ? ");
			assertEquals("test ko", 'r', liste.donnerCouleur("r1"));
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, r1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		try{
			System.out.print("couleur x ? ");
			liste.donnerCouleur("x");
			System.out.println("test ko, x n'est pas present dans la liste, il fallait une exception");
			System.exit(0);
		}catch(NonPresentException e){
			System.out.println("ok");
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println();
		
		
		System.out.println();
		
		try{
			System.out.print("ajout n2 ? ");
			liste.ajouterParticipant("n2",'n');
			assertEquals("test ko", " n2 n1 j1 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, n2 est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n1 ? ");
			if(liste.donnerCouleur("n1")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n2 ? ");
			if(liste.donnerCouleur("n2")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, n2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println();
		
		try{
			System.out.print("ajout n2 (deja present) ? ");
			liste.ajouterParticipant("n2",'n');
			System.out.println("test ko, n2 est deja present dans la liste, il fallait une exception");
			System.exit(0);
		}catch(DejaPresentException e){
			System.out.println("ok");
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		System.out.println();
		
		
		try{
			System.out.print("ajout n3 ? ");
			liste.ajouterParticipant("n3",'n');
			assertEquals("test ko", " n3 n2 n1 j1 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, n3 n'est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n1 ? ");
			if(liste.donnerCouleur("n1")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n2 ? ");
			if(liste.donnerCouleur("n2")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, n2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n3 ? ");
			if(liste.donnerCouleur("n3")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n3 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
	
		System.out.print("Voici la liste actuelle : ");
		System.out.println(liste.toString());
		System.out.println();
		
		
		try{
			System.out.print("ajout n4 ? ");
			liste.ajouterParticipant("n4",'n');
			assertEquals("test ko", " n4 n3 n2 n1 j1 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, n4 n'est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n1 ? ");
			if(liste.donnerCouleur("n1")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n2 ? ");
			if(liste.donnerCouleur("n2")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, n2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n3 ? ");
			if(liste.donnerCouleur("n3")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n3 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n4 ? ");
			if(liste.donnerCouleur("n4")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n4 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println();
		try{
			System.out.print("ajout j2 ? ");
			liste.ajouterParticipant("j2",'j');
			assertEquals("test ko", " n4 n3 n2 n1 j2 j1 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, j2 n'est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j1 ? ");
			if(liste.donnerCouleur("j1")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, j1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j2 ? ");
			if(liste.donnerCouleur("j2")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, j2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n1 ? ");
			if(liste.donnerCouleur("n1")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		System.out.print("Voici la liste actuelle : ");
		System.out.println(liste.toString());
		System.out.println();
		
		
		try{
			System.out.print("ajout j2 (deja present) ? ");
			liste.ajouterParticipant("j2",'n');
			System.out.println("test ko, j2 est deja present dans la liste, il fallait une exception");
			System.exit(0);
		}catch(DejaPresentException e){
			System.out.println("ok");
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
	
		
		System.out.println();
		try{
			System.out.print("ajout j3 ? ");
			liste.ajouterParticipant("j3",'j');
			assertEquals("test ko", " n4 n3 n2 n1 j3 j2 j1 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, j3 n'est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j1 ? ");
			if(liste.donnerCouleur("j1")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, j1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j2 ? ");
			if(liste.donnerCouleur("j2")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, j2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j3 ? ");
			if(liste.donnerCouleur("j3")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, j3 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur n2 ? ");
			if(liste.donnerCouleur("n2")!='n'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, n2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.print("Voici la liste actuelle : ");
		System.out.println(liste.toString());
		System.out.println();
		
		System.out.println();
		try{
			System.out.print("ajout j4 ? ");
			liste.ajouterParticipant("j4",'j');
			assertEquals("test ko", " n4 n3 n2 n1 j4 j3 j2 j1 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, j4 n'est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j1 ? ");
			if(liste.donnerCouleur("j1")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, j1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j2 ? ");
			if(liste.donnerCouleur("j2")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, j2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j3 ? ");
			if(liste.donnerCouleur("j3")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, j3 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur j4 ? ");
			if(liste.donnerCouleur("j4")!='j'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, j4 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.print("Voici la liste actuelle : ");
		System.out.println(liste.toString());
		System.out.println();
		
		
		
		System.out.println();
		try{
			System.out.print("ajout r2 ? ");
			liste.ajouterParticipant("r2",'r');
			assertEquals("test ko", " n4 n3 n2 n1 j4 j3 j2 j1 r2 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, r2 n'est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur r1 ? ");
			if(liste.donnerCouleur("r1")!='r'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, r1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur r2 ? ");
			if(liste.donnerCouleur("r2")!='r'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, r2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.print("Voici la liste actuelle : ");
		System.out.println(liste.toString());
		System.out.println();
		System.out.println();
		try{
			System.out.print("ajout r3 ? ");
			liste.ajouterParticipant("r3",'r');
			assertEquals("test ko", " n4 n3 n2 n1 j4 j3 j2 j1 r3 r2 r1", liste.toString());
			System.out.println(" contenu ok en suivant le chainage --> ");
		}catch(DejaPresentException e){
			System.out.println("test ko, r3 n'est pas present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur r1 ? ");
			if(liste.donnerCouleur("r1")!='r'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				System.exit(0);
			}
			System.out.println("ok");
			
		}catch(NonPresentException e){
			System.out.println("test ko, r1 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur r2 ? ");
			if(liste.donnerCouleur("r2")!='r'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, r2 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			System.out.print("couleur r3 ? ");
			if(liste.donnerCouleur("r3")!='r'){
				System.out.println("test ko");
				System.out.println("verifiez la methode donnerCouleur()");
				System.out.println("verifiez le chainage <-- dans la methode ajouterParticipant()");
				
				System.exit(0);
			}
			System.out.println("ok");
		}catch(NonPresentException e){
			System.out.println("test ko, r3 est present dans la liste, il ne fallait pas d'exception");
			System.exit(0);
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			System.out.println("test ko, verifiez le chainage <--");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println();
		try{
			System.out.print("ajout r2 (deja present) ? ");
			liste.ajouterParticipant("r2",'n');
			System.out.println("test ko, r2 est deja present dans la liste, il fallait une exception");
			System.exit(0);
		}catch(DejaPresentException e){
			System.out.println("ok");
		}catch(Exception e){
			System.out.println("test ko, exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("tous les tests ont reussi");

		
	}
	
	
}
