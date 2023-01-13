import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Brocante {
	
	// suivez l'implementation imposee dans l'enonce
	
	private int phase = 1; //
	private String[] tableEmplacements; //table des reservations
	private int premEmplacementAuto; // pour la phase 1
	private ArrayDeque<Integer> fileEmplacementsLibres; //pour la phase 2
	private HashMap<Integer, Integer> mapCodes; //cle = code, valeur = numero emplacement	
	
	// vous pouvez ajouter des attributs si cela peut vous aider
	
			
	
	/**
	 * initialise la brocante
	 * @param nombreTotalEmplacements
	 * @param tableCodes la table avec les codes pour reserver les emplacements des riverains
	 * @throws IllegalArgumentException si un des parametres ne permet pas d'initialiser la brocante  
	 */
	public Brocante(int nombreTotalEmplacements, int[]tableCodes){
		if(nombreTotalEmplacements<=0)
			throw new IllegalArgumentException();
		if(tableCodes==null||tableCodes.length>nombreTotalEmplacements)
			throw new IllegalArgumentException();
		// TODO
		
	}
	
	
	/**
	 * confirme une place reservee a un riverain et enregistre son nom dans la table de reservation
	 * la reservation peut echouer si le code n'est pas connu ou si la reservation a deja ete faite
	 * si le riverain avait deja confirme son emplacement, aucune action n'est faite (pas de changement eventuel de nom)
	 * @param nom le nom du riverain
	 * @param code le code que le riverain a recu 
	 * @return true si la reservation a ete faite, false sinon
	 * @throws IllegalArgumentException si le nom est null ou vide
	 * @throws IllegalStateException si on n'est pas en phase 1
	 */
	public boolean reserverRiverain(String nom, int code){
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();
		if(phase!=1)
			throw new IllegalStateException();
	
		// TODO
	    return false;
	}
	
	
	
	/**
	 * reserve un ou plusieurs emplacements de facon automatique
	 * lors de cette phase ce sont les emplacements libres non attribues aux riverains qui peuvent etre atttribues
	 * la reservation reussit s'il y a suffisament d'emplacements libres
	 * ATTENTION : PAS de reservation partielle (tout ou rien)
	 * @param nom le nom de la personne qui demande des emplacements
	 * @param nombreEmplacementsDemandes
	 * @return la liste des numeros reserves ou null si la reservation a echoue
	 * @throws IllegalArgumentException si le nom est null ou vide ou si le nombre d'emplacements est negatif ou nul
	 * @throws IllegalStateException si on n'est pas en phase 1
	 */
	public ArrayList<Integer> reserverAuto1(String nom, int nombreEmplacementsDemandes){	
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();
		if(nombreEmplacementsDemandes<=0)
			throw new IllegalArgumentException();
		if(phase!=1)
			throw new IllegalStateException();
		
		// TODO
		return null;
			
	}


	/**
	 * a comme effet de passer de la phase 1 a la phase 2
	 * si deja en phase 2, rien ne doit etre fait
	 */
	public void changerPhase(){

		//TODO
		//Pensez a initialiser la file!!!		
	
	}

	
	/**
	 * reserve un ou plusieurs emplacements de facon automatique
	 * lors de cette phase tous les emplacements libres peuvent etre atttribues
	 * la reservation reussit s'il y a suffisament d'emplacements libres
	 * ATTENTION : PAS de reservation partielle (tout ou rien)
	 * @param nom le nom de la personne qui demande des emplacements
	 * @param nombreEmplacementsDemandes
	 * @return la liste des numeros reserves ou null si la reservation a echoue
	 * @throws IllegalArgumentException si le nom est null ou vide ou si le nombre d'emplacements est negatif ou nul
	 * @throws IllegalStateException si on n'est pas en phase 2
	 */
	public ArrayList<Integer> reserverAuto2(String nom, int nombreEmplacementsDemandes){	
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();
		if(nombreEmplacementsDemandes<=0)
			throw new IllegalArgumentException();
		if(phase!=2)
			throw new IllegalStateException();
		
		// TODO
		return null;
	}

		
	
	// Va servir pour debugger
	/**
	 * renvoie, sous forme d'une chaine de caracteres, la table des emplacements
	 */
	public String toString(){
		return Arrays.toString(tableEmplacements);
		// vous pouvez modifier cette methode comme vous voulez
		// MAIS cette methode ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
	}
	
}
