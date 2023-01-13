import java.util.HashMap;

/**
 * 
 * @author 	ABID Brahim
 * 
 * 
 */
public class Entrepot {

	private HashMap<Integer,Societe> mapSocietesPresente;
	private Hangar [] tousLesHangars;
	private int nombreHangarsOccuppees;
	private EnsembleVoituresAutorisees ensembleVoituresAutorisees;

	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		ensembleVoituresAutorisees = new EnsembleVoituresAutorisees();
		if (nombreHangars<=0)
			throw new IllegalArgumentException();
		mapSocietesPresente = new HashMap<>(nombreHangars);
		tousLesHangars = new Hangar[nombreHangars];
		for (int i = 0; i < nombreHangars; i++) {
			tousLesHangars[i] = new Hangar(i);

		}
		nombreHangarsOccuppees = 0 ;
	
	}
	
	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire : 
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 * @param numeroSociete
	 * @param nomSociete
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	
	public int attribuerHangar(int numeroSociete, String nomSociete) {
		if (nombreHangarsOccuppees == tousLesHangars.length)
			return -1;
		Societe societe ;
		if (!mapSocietesPresente.containsKey(numeroSociete)){
			societe = new Societe(numeroSociete,nomSociete);

			mapSocietesPresente.put(numeroSociete,societe);
		}else{
			societe = mapSocietesPresente.get(numeroSociete);

		}
		int numeroHangarConseillee = numeroSociete%tousLesHangars.length;

		for (int i = numeroHangarConseillee; i < tousLesHangars.length; i++) {
			if (tousLesHangars[i].getSociete()==null){
				tousLesHangars[i].setSociete(societe);
				societe.ajouterHangar(i);
				nombreHangarsOccuppees++;
				return i;
			}

		}
		for (int i = 0; i < numeroHangarConseillee; i++) {
			if (tousLesHangars[i].getSociete()==null){
				tousLesHangars[i].setSociete(societe);
				societe.ajouterHangar(i);
				nombreHangarsOccuppees++;
				return i;

			}
		}

		throw new RuntimeException();
		// Pour une meilleure repartition des hangars occupes dans l'entrepot, 
		// veuillez suivre les indications donnees dans l'enonce!
		

	}
	
	

	
	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		return mapSocietesPresente.get(numeroSociete);
	}


	/**
	 * @param numeroHangar le numero du hangar
	 * @return true si le hangar a ete libere , false sinon
	 */
	public boolean libererHangar(int numeroHangar){
		if (numeroHangar<0 || numeroHangar> tousLesHangars.length)
			return false;
		if (tousLesHangars[numeroHangar].getSociete() == null)
			return false;
		tousLesHangars[numeroHangar].setSociete(null);
		return true;

	}

	public boolean estAutorisee(String plaque){
		return ensembleVoituresAutorisees.voitureAutorisee(plaque);
	}



}
