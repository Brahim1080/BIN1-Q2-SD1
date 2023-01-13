import java.util.HashMap;
import java.util.HashSet;


public class ExpressionArithmetique extends ArbreDeCaracteres { 
	private  HashSet<Character> ensembleDentiers;
	/**
	 * Cree une expression arithmetique a partir d'un arbre de caracteres
	 * @param a
	 */
	public ExpressionArithmetique (ArbreDeCaracteres a) {
		super(a);
	}

	public ExpressionArithmetique (char c) {
		super(c);
	}
	
	public ExpressionArithmetique (char c, ArbreDeCaracteres ag, ArbreDeCaracteres ad) {
		super(c, ag, ad);
	}
	
	
	/**
	 * calcule le nombre d'operations correspondant au type d'operateur passe en parametre que contient l'expression arithmetique
	 * Par ex : exp1 : + --> 1
	 *                 / --> 1
	 *                 ...
	 *          exp3 : + --> 4 
	 * @param operateur l'operateur verifie
	 * @return le nombre d'operations
	 * @throws IllegalArgumentException si le caractere passe en parametre n'est pas un operateur (+,-,*,/)
	 */
	public int nombreOperations(char operateur)  {
		if (operateur != '+' && operateur != '-' && operateur != '*' && operateur != '/')
			throw new IllegalArgumentException();
		return nombreOperations(racine, operateur);
	}

	private int nombreOperations(NoeudCaractere noeud , char operateur) {
		if (noeud == null)
			return 0;

		char caractere = noeud.caractere;
		if (!Character.isDigit(caractere) && caractere == operateur)
			return 1+ nombreOperations(noeud.gauche,operateur) + nombreOperations(noeud.droit,operateur);

		return nombreOperations(noeud.gauche, operateur) + nombreOperations(noeud.droit, operateur);
	}
	
	/**
	 * verifie si l'arbre ne contient que des additions
	 * Par ex l'exp3 ne contient que des +
	 * @return true si l'expression arithmetique contient uniquement des additions, false sinon
	 */
	public boolean uniquementDesAdditions(){
		if (estVide())
			return true;
		return uniquementDesAdditions(racine);
	}
	 private boolean uniquementDesAdditions(NoeudCaractere noeud){
		if (noeud== null)
			return true;
		char caractere = noeud.caractere;
		if (!Character.isDigit(caractere) && caractere!='+')
			return false;
		return uniquementDesAdditions(noeud.gauche) && uniquementDesAdditions(noeud.droit);
	 }
	

	
	/**
	 * calcule le nombre d'entiers differents contenus dans l'expression arithmetique
	 * Par ex : exp2 contient 3 entiers differents : 1, 4 et 8
	 * @return le nombre d'entiers differents
	 */
	public int nombreEntiersDifferents() {
		// piste de solution:
		// utilisez un ensemble (HashSet<Character>) dans lequel seront places les entiers contenus dans l'arbre
		// Grace a la caracteristique d'unicite d'un ensemble, ceux-ci n'y figureront qu'une fois
		// La taille de l'ensemble obtenu correspondra au nombre recherche
		// TODO
		if (estVide())
			return 0;

		ensembleDentiers = new HashSet<>();
		return nombreEntiersDifferents(racine);
	}
	private int nombreEntiersDifferents(NoeudCaractere noeud){
		if (noeud == null)
			return 0;
		char caractere = noeud.caractere;

		if (Character.isDigit(caractere)){
			if (!ensembleDentiers.contains(caractere)){
				ensembleDentiers.add(caractere);
				return 1 + nombreEntiersDifferents(noeud.gauche) + nombreEntiersDifferents(noeud.droit);
			}
		}
		return  nombreEntiersDifferents(noeud.gauche) + nombreEntiersDifferents(noeud.droit);
	}

} 

