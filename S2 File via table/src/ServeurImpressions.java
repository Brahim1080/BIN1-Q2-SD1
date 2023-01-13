import java.io.File;
/**
 * @author Brahim Abid
 *
 */
public class ServeurImpressions{

	private FileAttenteImpressions[] fileAttenteImpressions;


	/**
	 * construit une table avec 10 files FileAttenteImpressions
	 */
	public ServeurImpressions() {
		fileAttenteImpressions = new FileAttenteImpressions[10];
		for (int i = 0; i < fileAttenteImpressions.length; i++) {
			fileAttenteImpressions[i]=  new FileAttenteImpressions();
		}
	}
	
	/**
	 * verifie si toutes les files sont vides
	 * @return true si toutes les files sont vides, false sinon
	 */
	public boolean estVide(){
		for (int i = 0; i < fileAttenteImpressions.length ; i++) {
			if (!fileAttenteImpressions[i].estVide() && fileAttenteImpressions[i] != null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ajoute la demande d impression en fin de la file de priorite correspondante
	 * @param demande la demande a ajouter
	 * @throws IllegalArgumentException si la demande est null
	 */
	public void ajouter(DemandeImpressionAvecPriorite demande){
		if (demande == null)
			throw new IllegalArgumentException();

		fileAttenteImpressions[demande.getPriorite()].ajouter(demande);
	}
	
	/**
	 * retire l'impression en tete de file de priorite la plus haute qui est non vide
	 * @return l'impression qui a ete retiree
	 * @throws FileVideException si aucune demande d impression dans la file
	 */
	public DemandeImpressionAvecPriorite retirer()throws FileVideException{
		if (this.estVide())
			throw new FileVideException();

		for (int i = fileAttenteImpressions.length - 1 ; i >= 0 ; i--) {
			if (!fileAttenteImpressions[i].estVide()){
				DemandeImpressionAvecPriorite demande = (DemandeImpressionAvecPriorite) fileAttenteImpressions[i].retirer();
				return demande;
			}
		}

		return null;
	}

	
	
}


