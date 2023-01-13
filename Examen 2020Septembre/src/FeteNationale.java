import java.util.HashMap;
import java.util.HashSet;

public class FeteNationale{

	
	private HashMap<String, Noeud> mapNomNoeud;
	private Noeud premierNoir; 
	private Noeud premierJaune;
	private Noeud premierRouge;
	
	// N'ajoutez pas d'autres attributs
		

	// A ne pas changer	
	/**
	 * Le constructeur construit une liste qui contient 3 participants de 3 couleurs differentes
	 * @param nomNoir le nom du premier participant noir
	 * @param nomJaune le nom du premier participant jaune
	 * @param nomRouge le nom du premier participant rouge
	 */
	public FeteNationale(String nomNoir, String nomJaune, String nomRouge){
		mapNomNoeud = new HashMap<String, FeteNationale.Noeud>();
		premierNoir = new Noeud(nomNoir);
		premierJaune = new Noeud(nomJaune);
		premierRouge = new Noeud(nomRouge);
		premierNoir.suivant=premierJaune;
		premierJaune.precedent=premierNoir;
		premierJaune.suivant= premierRouge;
		premierRouge.precedent=premierJaune;
		mapNomNoeud.put(nomNoir, premierNoir);
		mapNomNoeud.put(nomJaune, premierJaune);
		mapNomNoeud.put(nomRouge, premierRouge);
	}
	
	 
	// A ne pas changer, va servir pour les tests
	public String toString(){
		String aRenvoyer = "";
		Noeud baladeur = premierNoir;
		int cpt = 0;
		while(baladeur!=null){
			aRenvoyer += " "+baladeur.nom;
			baladeur = baladeur.suivant;
			cpt++;
			if(cpt==100)
				return "boucle infinie";			
		}
		return aRenvoyer;
	}
	
	
	/**
	 * ajoute un participant dans la liste en fonction de sa couleur
	 * apres ajout la liste doit toujours etre triee par couleur
	 * @param nom le nom du participant a ajouter
	 * @param couleur la couleur du participant a ajouter (n,j ou r)
	 * @throws IllegalArgumentException si le nom est null ou vide et/ou si la couleur n'est pas valide 
	 * @throws DejaPresentException si le participant est deja present dans la liste
	 * 
	 */
	
	public void ajouterParticipant(String nom, char couleur){
		if (nom == null || nom.equals("") ){
			System.out.println("NUll ou vide");
			throw new IllegalArgumentException();
		}
		if (couleur != 'n' && couleur != 'j' && couleur != 'r'){
			System.out.println("IllegalArgumentException");
			throw new  IllegalArgumentException();
		}
		if (mapNomNoeud.containsKey(nom)){
			System.out.println("Deja present");
			throw new DejaPresentException();

		}
		Noeud noeud;
		Noeud nouveauNoeud = new Noeud(nom);
		if (couleur == 'n'){
			noeud = premierNoir;
			premierNoir = nouveauNoeud;
		} else {
			if (couleur== 'j'){
				noeud = premierJaune;
				premierJaune = nouveauNoeud;
			}else{
				noeud= premierRouge;
				premierRouge = nouveauNoeud;
			}

		}
		noeud.precedent= nouveauNoeud;
		nouveauNoeud.suivant = noeud;
		mapNomNoeud.put(nom,nouveauNoeud);
	}
	
	
	/**
	 * renvoie la couleur du participant
	 * @param nom le nom du participant recherche
	 * @return une couleur
	 * @throws IllegalArgumentException si le nom est null ou vide
	 * @throws NonPresentException si le participant ne se trouve pas dans la liste
	 */
	public char donnerCouleur(String nom){
		if (nom == null || nom.equals("") ){
			System.out.println("NUll ou vide");
			throw new IllegalArgumentException();
		}
		if (!mapNomNoeud.containsKey(nom))
			throw new NonPresentException();
		Noeud noeud = mapNomNoeud.get(nom);
		// Indication : partez du participant et revenez en arriere dans le chainage
		return nom.charAt(0);
	}
	
	

	// Classe interne Noeud
	private class Noeud{
		
		private Noeud precedent;
		private String nom;
		private Noeud suivant;
		
		public Noeud(String nom) {
			this.nom = nom;
		}

		public Noeud(Noeud precedent, String nom, Noeud suivant) {
			this.nom = nom;
			this.precedent = precedent;
			this.suivant = suivant;
		}		
	}
}
