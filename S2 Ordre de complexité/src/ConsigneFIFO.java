import java.util.ArrayDeque;

/**
 * @author Brahim Abid
 *
 */

public class ConsigneFIFO {
	
	private ArrayDeque<Casier> casiersLibres;
	private Casier[] tousLesCasiers;
	
	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public ConsigneFIFO(int nombreCasiers){
		if (nombreCasiers <= 0) {
			throw new IllegalArgumentException();
		}
		tousLesCasiers = new Casier[nombreCasiers];
		casiersLibres = new ArrayDeque<>(nombreCasiers);
		for (int i = 0; i < nombreCasiers; i++) {
			Casier casier = new Casier(i);
			tousLesCasiers[i] = casier;
			casiersLibres.addLast(casier);
		}
	}

	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		return !casiersLibres.isEmpty();
	
	}

	
	/**
	 * attribue un casier libre selon le principe FIFO
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		if(motDePasse==null||motDePasse.equals(""))
			throw new IllegalArgumentException();
		if(casiersLibres.isEmpty())
			return -1;
		Casier casier = casiersLibres.removeFirst();
		casier.setMotDePasse(motDePasse);
		return casier.getNumero();
	
	}

	
	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le numero de casier existe et le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		if(motDePasse==null||motDePasse.equals(""))
			throw new IllegalArgumentException();
		if(numeroCasier<0 || numeroCasier >= tousLesCasiers.length)
			return false;
		Casier casier = tousLesCasiers[numeroCasier];
		if(!casier.getMotDePasse().equals(motDePasse))
			return false;
		casier.setMotDePasse("");
		casiersLibres.addLast(casier);
		return true;
	
	}
}
