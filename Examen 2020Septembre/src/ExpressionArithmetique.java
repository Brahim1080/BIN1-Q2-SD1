import java.util.HashMap;
import java.util.HashSet;


public class ExpressionArithmetique extends ArbreDeCaracteres {

    public ExpressionArithmetique() {
        super();
    }

    private HashSet<Character> ensemblesEntiers;

    /**
     * Cree une expression arithmetique a partir d'un arbre de caracteres
     *
     * @param a
     */
    public ExpressionArithmetique(ArbreDeCaracteres a) {
        super(a);
    }

    public ExpressionArithmetique(char c) {
        super(c);
    }

    public ExpressionArithmetique(char c, ArbreDeCaracteres ag, ArbreDeCaracteres ad) {
        super(c, ag, ad);
    }

    /**
     * calcule le nombre d'operateurs moins presents dans l'expression arithmetique
     * si le parametre est 1, c'est le nombre de moins unaire qui sera renvoye
     * si le parametre est 2, c'est le nombre de moins binaire qui sera renvoye
     *
     * @param i permet de distinguer l'operateur unaire de l'operateur binaire (1 ou 2)
     * @return le nombre calcule
     * @throws IllegalArgumentException si le parametre est invalide
     */
    public int nombreMoins(int i) {
        if (i > 2 || i < 1)
            throw new IllegalArgumentException();
        if (i == 1)
            return nombreMoinsUnaire(racine);
        return nombreMoinsBinaire(racine);
    }

    private int nombreMoinsUnaire(NoeudCaractere noeud) {
        if (noeud == null)
            return 0;
        char caractere = noeud.caractere;
        if (caractere == '-' && !Character.isDigit(noeud.droit.caractere))
            return 1 + nombreMoinsUnaire(noeud.gauche) + nombreMoinsUnaire(noeud.droit);
		return nombreMoinsUnaire(noeud.gauche) + nombreMoinsUnaire(noeud.droit);
    }

    private int nombreMoinsBinaire(NoeudCaractere noeud) {
        if (noeud == null)
            return 0;
        char caractere = noeud.caractere;
        if (caractere == '-' && Character.isDigit(noeud.droit.caractere) && Character.isDigit(noeud.droit.caractere))
            return 1 + nombreMoinsBinaire(noeud.gauche) + nombreMoinsBinaire(noeud.droit);
        return nombreMoinsBinaire(noeud.gauche) + nombreMoinsBinaire(noeud.droit);
    }


    /**
     * verifie si tous les entiers contenus dans l'expression arithmetiques sont differents
     *
     * @return true si tous les entiers sont differents, false sinon
     */
    public boolean entiersTousDifferents() {
        // contrainte de programmation :
        // utilisez un ensemble (HashSet<Character>) dans lequel seront places au fur et a mesure les entiers contenus dans l'arbre
        // A chaque entier rencontre, il suffira de verifier s'il n'est pas deja dans l'ensemble
        ensemblesEntiers = new HashSet<>();
        return entiersTousDifferents(racine);

    }

    private boolean entiersTousDifferents(NoeudCaractere noeud) {
        if (noeud == null)
            return true;
        char caractere = noeud.caractere;
        if (Character.isDigit(caractere)) {
            if (ensemblesEntiers.contains(caractere))
                return false;
            else ensemblesEntiers.add(caractere);
        }
        return entiersTousDifferents(noeud.gauche) && entiersTousDifferents(noeud.droit);
    }


} 

