import java.util.HashMap;
import java.util.HashSet;


public class ExpressionArithmetique extends ArbreDeCaracteres {
    private HashSet<Character> ensembleDentiers ;
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
     * calcule le nombre d'additions que contient l'expression arithmetique
     * Par ex : exp1 : 1 addition
     * exp3 : 4 additions
     *
     * @return le nombre d'additions
     */
    public int nombreAdditions() {
        // TODO
        if (estVide())
            return 0;
        return nombreAdditions(racine);
    }

    private int nombreAdditions(NoeudCaractere noeud) {
        if (noeud == null)
            return 0;

        char caractere = noeud.caractere;
        if (!Character.isDigit(caractere) && caractere == '+')
            return 1+ nombreAdditions(noeud.gauche) + nombreAdditions(noeud.droit);

        return nombreAdditions(noeud.gauche) + nombreAdditions(noeud.droit);
    }


    /**
     * verifie si l'arbre ne contient que des operateurs du type passe en parametre
     * Par ex l'exp2 ne contient que des +
     *
     * @param operateur l'operateur verifie
     * @return true si l'expression arithmetique contient uniquement des operateurs du type passe en parametre, false sinon
     * @throws IllegalArgumentException si le caractere passe en parametre n'est pas un operateur
     */
    public boolean uniquementDes(char operateur) {
        if (operateur != '+' && operateur != '-' && operateur != '*' && operateur != '/')
            throw new IllegalArgumentException();
        if (estVide())
            return true;
        return uniquementsDes(racine, operateur);
    }
    private boolean uniquementsDes(NoeudCaractere noeud , char operateur){
        if (noeud == null)
            return true;

        char caractere = noeud.caractere;
        if (!Character.isDigit(caractere) && caractere != operateur)
            return false;

        return uniquementsDes(noeud.gauche, operateur) && uniquementsDes(noeud.droit, operateur);
    }


    /**
     * calcule le nombre d'entiers differents contenus dans l'expression arithmetique
     * Par ex : exp2 contient 3 entiers differents : 1, 4 et 8
     *
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

