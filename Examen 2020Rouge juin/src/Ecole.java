import java.util.HashMap;
import java.util.HashSet;

public class Ecole {

	private HashSet<String> ensembleEleves;
	private HashSet<String> ensembleInstituteurs;
	private HashMap<String, Noeud> mapClasseNoeudInstituteur;
	private Noeud tete;   // tete de la liste

	// A ne pas changer
	/**
	 * Le constructeur construit une ecole de t.length/2 classes et ses instituteurs
	 * @param tableClasseInstituteurs, la table qui contient les noms des classes et les noms des instituteurs
	 * @throws IllegalArgumentException si la table ne permet pas de construire l'ecole
	 */
	public Ecole(String[] tableClasseInstituteurs){
		// minimum une classe
		if(tableClasseInstituteurs.length==0)
			throw new IllegalArgumentException();
		// une classe a toujours un instituteur
		if(tableClasseInstituteurs.length%2!=0)
			throw new IllegalArgumentException();
		ensembleEleves = new HashSet<String>();
		ensembleInstituteurs = new HashSet<String>();
		mapClasseNoeudInstituteur = new HashMap<String, Noeud>();
		tete = new Noeud(tableClasseInstituteurs[1]);
		ensembleInstituteurs.add(tableClasseInstituteurs[1]);
		mapClasseNoeudInstituteur.put(tableClasseInstituteurs[0], tete);
		Noeud baladeur = tete;	
		for (int i = 2; i < tableClasseInstituteurs.length; i=i+2) {
			baladeur.suivant = new Noeud(tableClasseInstituteurs[i+1]);
			baladeur = baladeur.suivant;
			ensembleInstituteurs.add(tableClasseInstituteurs[i+1]);
			mapClasseNoeudInstituteur.put(tableClasseInstituteurs[i], baladeur);		
		}
		// tous les noms des instituteurs sont differents?
		if(ensembleInstituteurs.size()!=tableClasseInstituteurs.length/2)
			throw new IllegalArgumentException();
		// tous les noms des classes sont differents?
		if(mapClasseNoeudInstituteur.size()!=tableClasseInstituteurs.length/2)
			throw new IllegalArgumentException();
	}
	
	
	// A ne pas changer, va servir pour les tests
	public String toString(){
		String aRenvoyer = tete.nom;
		Noeud baladeur = tete.suivant;
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
	 * verifie si le nom correspond a un eleve de l'ecole
	 * @param nom le nom de l'eleve recherche
	 * @return true si l'eleve est present, false sinon
	 * @throws IllegalArgumentException si le parametre est null ou vide
	 */
	public boolean estEleve(String nom){
		if(nom == null || nom.length()==0)
			throw new IllegalArgumentException();

		return ensembleEleves.contains(nom);
	}
	
	
	/**
	 * verifie si le nom correspond a un instituteur
	 * @param nom le nom de l'instituteur recherche
	 * @return true si le nom correspond a un instituteur, false sinon
	 * @throws IllegalArgumentException si le parametre est null ou vide
	 */
	public boolean estInstituteur(String nom){
		if(nom == null || nom.length()==0)
			throw new IllegalArgumentException();

		return ensembleInstituteurs.contains(nom);
	}
	
	/**
	 * verifie si le nom est deja present dans la liste
	 * @param nom le nom recherche
	 * @return true si le nom correspond a un instituteur ou a un eleve deja present, false sinon
	 * @throws IllegalArgumentException si le parametre est null ou vide
	 */
	public boolean estHomonyme(String nom){
		if(nom == null || nom.length()==0)
			throw new IllegalArgumentException();

		if (estEleve(nom) || estInstituteur(nom))
			return true;
		return false;
	}
	
	/**
	 * verifie la presence de la classe dans l'ecole
	 * @param classe la classe recherchee
	 * @return true si la classe est presente, false sinon
	 * @throws IllegalArgumentException si le parametre est null ou vide
	 */
	public boolean estClasse(String classe){
		if(classe == null || classe.length()==0)
			throw new IllegalArgumentException();

		return mapClasseNoeudInstituteur.containsKey(classe);
	}
	
	
	/**
	 * ajoute un eleve dans une classe. 
	 * Le nom ne peut etre deja present (ni eleve, ni instituteur)
	 * La classe doit exister 
	 * @param nom le nom de l'eleve a ajouter
	 * @param classe la classe
	 * @return true si l'ajout a pu se faire, false sinon
	 * @throws IllegalArgumentException en cas de parametre null ou vide
	 * 
	 */
	public boolean ajouterEleve(String nom, String classe){
		if(nom == null || nom.length()==0)
			throw new IllegalArgumentException();
		if(classe == null || classe.length()==0)
			throw new IllegalArgumentException();	
		if (estEleve(nom) || estHomonyme(nom) || !estClasse(classe))
			return false;
		//instit
		Noeud noeudProf = mapClasseNoeudInstituteur.get(classe);
		//new eleve
		Noeud noeudEleve = new Noeud(nom);
		noeudEleve.suivant = noeudProf.suivant;
		noeudProf.suivant = noeudEleve;
		ensembleEleves.add(nom);
		return true;
	}
	
	/**
	 * supprime un eleve de l'ecole
	 * le nom doit etre present et ne pas etre celui d'un instituteur
	 * @param nom le nom de l'eleve a supprimer
	 * @return true si la suppression a pu se faire
	 * @throws IllegalArgumentException si le parametre est null ou vide
	 */
	public boolean supprimerEleve(String nom){
		if(nom == null || nom.length()==0)
			throw new IllegalArgumentException();
		if (estInstituteur(nom) || !estEleve(nom))
			return false;
		Noeud noeud = tete;
		while (!noeud.suivant.nom.equals(nom)){
			noeud = noeud.suivant;
		}
		ensembleEleves.remove(nom);
		noeud.suivant = noeud.suivant.suivant;
		return true;
	}
	
	/**
	 * renvoie sous forme d'une chaine de caractere tous les eleves (pas l'instituteur) appartenant a une classe donnee
	 * le delimitateur entre chaque eleve est un espace
	 * Un espace au debut ou a la fin de la chaine est tolere
	 * @param classe la classe
	 * @return une chaine de caracteres des eleves de la classe
	 * @throws IllegalArgumentException si le parametre est null ou vide
	 */
	public String donnerClasse(String classe){
		if(classe == null || classe.length()==0)
		throw new IllegalArgumentException();
		String classeEntiere ="";
		if (!estClasse(classe))
			return classeEntiere;
		Noeud noeud = mapClasseNoeudInstituteur.get(classe);
		// on ne prends pas l'instit
		noeud = noeud.suivant;
		while (noeud != null && !estInstituteur(noeud.nom)){
			classeEntiere += noeud.nom +" ";
			noeud= noeud.suivant;
		}
		return classeEntiere;
	}

	// Classe interne Noeud
	private class Noeud{
		
		private String nom;
		private Noeud suivant;
		
		public Noeud(String nom) {
			this.nom = nom;
		}

		public Noeud(String nom, Noeud suivant) {
			super();
			this.nom = nom;
			this.suivant = suivant;
		}		
	}
}
