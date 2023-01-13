public class Connexion {
   
	Ensemble<Login> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGIN
	
	public Connexion(){
		ensembleDesConnectes = new EnsembleTableBooleens<>(3000);
	}

	public int nombreDeConnectes(){
		// A COMPLETER
		return ensembleDesConnectes.taille();
	}
	
	// ajoute le login s'il n'est pas encore connecte
	public boolean connecter(Login login){
		return ensembleDesConnectes.ajouter(login);
		// A COMPLETER

	}
	
	// retire le login s'il est connecte
	public boolean deconnecter(Login login){
		return ensembleDesConnectes.enlever(login);
		// A COMPLETER

	}

	public boolean estConnecte(Login login){
		// A COMPLETER
		return ensembleDesConnectes.contient(login);
	}
	
	

	
}

