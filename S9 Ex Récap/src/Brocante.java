import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


public class Brocante {
	
	private int phase = 1;
	
	// suivez l'implementation imposee dans l'enonce
	private Emplacement[] tableEmplacements;
	private HashMap<String, Integer> mapRiverains;
	private HashMap<String, Exposant> mapExposants;

	private ArrayDeque<Emplacement> pileEmplacementsLibres;
	
	
	/**
	 * initialise une brocante avec nombre emplacements
	 * @param nombreEmplacements le nombre d'emplacements
	 * @param tableRiverains la table des riverains 
	 * @throws IllegalArgumentException si le nombre d'emplacements est negatif ou nul ou si la table des riverains est null
	 */
	public Brocante(int nombreEmplacements, String[] tableRiverains){
		if (nombreEmplacements<= 0 || tableRiverains == null)  throw new IllegalArgumentException();
		tableEmplacements = new Emplacement[nombreEmplacements];
		for (int i = 0; i < tableEmplacements.length ; i++) {
			tableEmplacements[i] = new Emplacement(i);

		}
		mapRiverains = new HashMap<>();
		mapExposants = new HashMap<>();
		for (int i = 0; i < tableRiverains.length; i++) {
			mapRiverains.put(tableRiverains[i],0 );
		}
		pileEmplacementsLibres = new ArrayDeque<Emplacement>();

	}

	/**
	 * reserve l'emplacement qui porte le numero passe en parametre au demandeur passe en parametre
	 * La reservation reussit si
	 *     l'emplacement est libre
	 *     le demandeur est bien un riverain
	 *     le riverain n'a pas encore 3 emplacements
	 * @param demandeur le riverain qui demande un emplacement
	 * @param numeroEmplacement le numero de l'emplacement souhaite
	 * @return true si la reservation a reussi, false sinon
	 * @throws IllegalArgumentException si le numero de l'emplacement n'existe pas
	 * @throws IllegalStateException si on n'est pas en phase 1
	 */
	public boolean reserver(Exposant demandeur,int numeroEmplacement){
		if ( numeroEmplacement < 0 || numeroEmplacement> tableEmplacements.length)
			throw new IllegalStateException();

		if (phase !=1)
			throw new IllegalArgumentException();


		if (!mapRiverains.containsKey(demandeur.getNom()))
			return false;

		Integer nombreEmplacements = mapRiverains.get(demandeur.getNom());

		if (nombreEmplacements < 3 ){
			mapRiverains.put(demandeur.getNom(), ++nombreEmplacements);
			mapExposants.put(demandeur.getNom(), demandeur);
			demandeur.ajouterEmplacement(tableEmplacements[numeroEmplacement]);
			tableEmplacements[numeroEmplacement].setExposant(demandeur);
			return true;

		}
		return false;
		//Attention pour augmenter le nombre d'emplacements
		//Solution ko:
		//Integer nombreEmplacements = mapRiverains.get(demandeur);
		//mapRiverains.put(demandeur, nombreEmplacements++);
		//Solutions ok:

		//ou:
		//Integer nombreEmplacements = mapRiverains.get(demandeur);
		//nombreEmplacements++;
		//mapRiverains.put(demandeur, nombreEmplacements);
	}
	
	/**
	 * a comme effet de passer de la phase 1 a la phase 2
	 * si deja en phase 2, rien ne doit etre fait
	 */
	public void changerPhase(){
		phase++;

		for (int i = 0; i < tableEmplacements.length; i++) {
			if (tableEmplacements[i] == null){
				pileEmplacementsLibres.push(tableEmplacements[i]);
			}
		}
		//Pensez a initialiser la pile!!!
	
	}
	
	/**
	 * attribue automatiquement un emmplacement libre au demandeur passe en parametre
	 * @param demandeur le demandeur d'un emplacement
	 * @return le numero de l'emplacement attribue ou -1 si plus d'emplacement libre
	 * @throws IllegalStateException si on n'est pas en phase 2
	 */
	public int attribuerAutomatiquementEmplacement(Exposant demandeur){
		if (phase!=2)
			throw new IllegalArgumentException();
		if (pileEmplacementsLibres.isEmpty())
			return -1;
		int numeroEmpl = pileEmplacementsLibres.pop().getNumero();
		int nbrEmplacement = mapRiverains.get(demandeur);
		mapRiverains.put(demandeur.getNom(),++nbrEmplacement);
		mapExposants.put(demandeur.getNom(), demandeur);
		demandeur.ajouterEmplacement(tableEmplacements[numeroEmpl]);
		tableEmplacements[numeroEmpl].setExposant(demandeur);

		return numeroEmpl;
	
	}
	public boolean estUnRiverain(String nom){
		return mapRiverains.containsKey(nom);
	}

	public int nombreEmplacementsRiverain(String nom){
		return mapRiverains.get(nom);
	}

	public boolean estLibre(int numeroEmplacement){
		return tableEmplacements[numeroEmplacement]==null;
	}


	public boolean emplacementLibre(){
		return !pileEmplacementsLibres.isEmpty();
	}

	public Exposant getExposant(String nom){
		return mapExposants.get(nom);
	}
	public  Iterator<Exposant> tousLesExposants(){
		return mapExposants.values().iterator();
	}


	/**
	 * renvoie, sous forme d'une chaine de caracteres, tous les numeros des emplacements et leurs eventuels occupants
	 */
	public String toString(){
		// Va servir pour debugger
		String aRenvoyer = "";
		aRenvoyer = aRenvoyer + "\ntableEmplacements" + Arrays.toString(tableEmplacements);
		aRenvoyer = aRenvoyer + "\nmapRiverains" + mapRiverains.toString();
		aRenvoyer = aRenvoyer + "\npileEmplacementsLibres" + pileEmplacementsLibres.toString();
		return aRenvoyer;
		// A modifier lorsque toute l'application sera au point!
	}

}
