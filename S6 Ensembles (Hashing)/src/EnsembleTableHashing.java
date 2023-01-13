/**
 * implementation de l'interface Ensemble via une table de listes
 * @author Brahim Abid
 *
 */

public class EnsembleTableHashing<E> implements Ensemble<E>{
	
	private ListeSimpleImpl<E>[] tableListes;
	private int taille;
	private double loadFactor;  //pour le defi 

	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite){	
		tableListes = new ListeSimpleImpl[capacite];
		for (int i = 0; i < tableListes.length; i++) {
			tableListes[i] = new ListeSimpleImpl<>();
		}

	}
	
	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite, double loadFactor){	
		// pour le  defi
		this(capacite);
		this.loadFactor = loadFactor;
	}


	public boolean estVide(){
		return taille == 0;
	}

	
	public int taille(){
		return taille;
	}

	
	public boolean contient(E element){
		int hash = Math.abs(element.hashCode())%tableListes.length;

		if (tableListes[hash].contient(element)){
			return true;
		}

		// Attention la methode hashCode() renvoie un entier, mais pas necessairement 
		// compris entre 0 et tailleTable
		// Cet entier pourrait meme etre negatif
		// solutions : Math.abs  -  %tailleTable
		return false;
		
	}

	
	public boolean ajouter(E element) {
		int hash = Math.abs(element.hashCode())% tableListes.length;
		if (tableListes[hash].contient(element)){
			return false;
		}
		taille++;
		tableListes[hash].insererEnTete(element);
		return true;
	
	}

	public boolean enlever(E element) {

		int hash = Math.abs(element.hashCode())% tableListes.length;
		if (!tableListes[hash].contient(element)){
			return false;
		}
		taille--;
		tableListes[hash].supprimer(element);
		 return true;
	
	}
	
	
	public String toString(){
	
		// Pour le debug cette methode renvoie le contenu de la structure de donnees utilisee
		// on y voit apparaitre une table avec les differentes listes, meme celles qui sont vides!
		// la methode proposee est utilisee par la classe de tests pour le défi

		// Cette methode devrait renvoyer uniquement les donnees comprises dans l'ensemble
		// Ex supplementaire 
		
		
		String aRenvoyer="";
		for (int i = 0; i < tableListes.length; i++) {
			aRenvoyer += "\ntable"+i+tableListes[i];
		}
		return aRenvoyer;
	}



}

