/**
 * @author Brahim Abid
 *
 */

public class Consigne{
	Pile<Casier> casiersLibres;
	Casier[] tousLesCasiers;
	
	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public Consigne(int nombreCasiers){
		if (nombreCasiers<=0)
			throw new IllegalArgumentException();

		tousLesCasiers = new Casier[nombreCasiers];

		casiersLibres = new PileImpl<Casier>(nombreCasiers);

		for (int i = 0; i < nombreCasiers; i++) {
			Casier c = new Casier(i);
			casiersLibres.push(c);
			tousLesCasiers[i]=c;
		}

		
	}

	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		if (casiersLibres.taille() > 0){
			return true;
		}
		return false;
	}

	
	/**
	 * attribue un casier libre
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException();
		if (casiersLibres.estVide())
			return -1;

		int numeroCasierLibre = casiersLibres.pop().getNumero();


		tousLesCasiers[numeroCasierLibre].setMotDePasse(motDePasse);

		return numeroCasierLibre;
	}

	
	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le numero de casier existe et le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException();

		if (numeroCasier >= tousLesCasiers.length || numeroCasier < 0 ) {
			return false;
		}

		if (!tousLesCasiers[numeroCasier].getMotDePasse().equals(motDePasse) ||
				tousLesCasiers[numeroCasier].getMotDePasse().equals(""))
			return false;


		casiersLibres.push(tousLesCasiers[numeroCasier]);
		tousLesCasiers[numeroCasier].setMotDePasse("");
		return true;
	}

}
