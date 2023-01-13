/**
 *
 * @author ABID Brahim
 *
 */
public class ArbreDEntiersPlus extends ArbreDEntiers {

	public ArbreDEntiersPlus () {
		super();
	}

	public ArbreDEntiersPlus (ArbreDEntiersPlus sousArbreGauche, int entier, ArbreDEntiersPlus sousArbreDroit) {
		super(sousArbreGauche, entier, sousArbreDroit);
	}

	public ArbreDEntiersPlus (int entier) {
		super(new ArbreDEntiersPlus(),entier,new ArbreDEntiersPlus());
	}
	
	public int hauteur () {
		if (racine==null)
			return 0;

		return hauteur(racine);
	}
	private int hauteur (NoeudEntier noeud) {
		if (noeud== null ) {
			return 0;
		}
		if (noeud==racine){
			if (noeud.gauche != null)
				return hauteur(noeud.gauche) ;
			return hauteur(noeud.droit);
		}
		if (noeud.droit !=null)
			return 1 + hauteur(noeud.droit);
		return 1+hauteur(noeud.gauche) ;
	}

	public boolean estCompletementRempli () {
		//TODO
		// Ex supplementaire
		//La definition (non recursive!) de cette methode est donnee dans l'enonce
		return false;
	}

	public boolean estComplet () {
		//TODO
		// Ex supplementaire
		//La definition recursive! de cette methode est donnee dans l'enonce
		return false;
	}	

}
