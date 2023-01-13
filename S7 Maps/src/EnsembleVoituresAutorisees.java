import java.util.HashMap;
/**
 *
 * @author 	ABID Brahim
 *
 *
 */
public class EnsembleVoituresAutorisees {
	private HashMap<String,Proprietaire> voituresAutorisees;
	

	/**
	 * construit un ensemble vide
	 */
	public EnsembleVoituresAutorisees(){
		voituresAutorisees = new HashMap<>();
	
	}

	/**
	 * ajoute une voiture a condition que celle-ci ne soit pas deja presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @param proprietaire le proprietaire de la voiture a ajouter
	 * @return true si la voiture n'etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(String plaque, Proprietaire proprietaire){
		if (voituresAutorisees.containsKey(plaque))
			return false;
		voituresAutorisees.put(plaque, proprietaire);
		return true;

	
	}


	/**
	 * retire une voiture a condition que celle-ci soit presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(String plaque){
		if (!voituresAutorisees.containsKey(plaque))
			return false;

		voituresAutorisees.remove(plaque);
		return true;
		// TODO
		
	}


	
	/**
	 * verifie si la voiture est autorisee car presente dans l'ensemble
	 * @param plaque la plaque de la voiture a verifier
	 * @return true si la voiture est presente dans l'ensemble, false sinon
	 */
	public boolean voitureAutorisee(String plaque){

		return voituresAutorisees.containsKey(plaque);
		// TODO
		
	}
	
	/**
	 * renvoie le proprietaire de la voiture
	 * @param plaque la plaque de la voiture recherchee
	 * @return le proprietaire ou null si la plaque n'est pas dans l'ensemble
	 */
	public Proprietaire donnerProprietaire(String plaque){
		if (!voituresAutorisees.containsKey(plaque))
			return null;

		return voituresAutorisees.get(plaque);


	}
	
	public String toString(){

		return null;
		// TODO
	}
}
