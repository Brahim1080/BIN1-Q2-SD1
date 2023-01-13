import java.util.ArrayList;
/**
 *
 * @author ABID Brahim
 *
 */
public class EnsembleTrieImpl<E> implements EnsembleTrie<E> {

    private Noeud racine;
    private int taille;

    public EnsembleTrieImpl() {
        racine = null;
        taille = 0;
    }

    public boolean estVide() {
        return racine == null;
    }

    public int taille() {
        return taille;
    }

    public E min() {
        if (taille() == 1)
            return racine.element;
        return min(racine);

    }

    private E min(Noeud noeud) {
        if (noeud == null)
            return null;
        if (noeud.gauche == null)
            return noeud.element;
        return min(noeud.gauche);
    }


    public boolean contient(E element) {

        //Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
        if (this.estVide())
            return false;
        if (racine.element == element)
            return true;

        return contient(racine, element);
    }

    private boolean contient(Noeud noeud, E element) {
        if (noeud == null)
            return false;
        if (noeud.element == element)
            return true;
        if (((Comparable<E>) noeud.element).compareTo(element) < 0)
            return contient(noeud.droit, element);

        return contient(noeud.gauche, element);

    }

    public boolean ajouter(E element) {
        if (racine == null) {
            racine = new Noeud(element);
            taille++;
            System.out.println("**noeud ajoute = " + racine.element);
            System.out.println("**taille = " + taille);
            return true;
        }
        if (contient(element))
            return false;
        //Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
        return ajouter(racine, element , racine);
    }
    private boolean ajouter(Noeud noeud, E element , Noeud parent) {
        if (noeud == null) {
            noeud = new Noeud(element);
            taille++;
            /*if(parent.gauche == null)
                parent.gauche = noeud ;
            else
                parent.droit = noeud;*/
            if (((Comparable<E>)noeud.element).compareTo(parent.element) > 0){
                parent.droit= noeud;

            }else parent.gauche= noeud;
            System.out.println("**noeud ajoute = " + noeud.element);
            System.out.println("**taille = " + taille);
            return true;
        }

        if (((Comparable<E>)noeud.element).compareTo(element) < 0)
            return ajouter(noeud.droit, element , noeud);

        return ajouter(noeud.gauche, element , noeud);
    }

    public E predecesseur(E element) {
        //TODO
        // Suggestion :
        // remplir une "arrayList" via un parcours en in-ordre
        // le predecesseur de l'element est l'element qui se trouve juste avant lui dans l'arrayList !
        // cette methode peut donc appeler la methode "private" remplirListe() qui suit
        ArrayList<E> liste = new ArrayList<>();
        remplirListe(racine,liste);
        if (!liste.contains(element))
            return null;
        int indexElement = liste.indexOf(element);
        if (indexElement==0)
            return null;


        return liste.get(indexElement-1);
    }

    private void remplirListe(Noeud noeud, ArrayList<E> liste) {
        // suggestion de methode a appeler par la methode predecesseur()
        if (noeud== null)
            return;
        remplirListe(noeud.gauche,liste);
        liste.add(noeud.element);
        remplirListe(noeud.droit,liste);

    }

    // A NE PAS MODIFIER!!!
    // VA SERVIR POUR LES TESTS!!!
    public String toString() {
        return "[ " + toString(racine) + " ]";
    }

    private String toString(Noeud n) {
        if (n == null)
            return "";
        if (n.gauche == null && n.droit == null)
            return "" + n.element;
        if (n.gauche == null)
            return " [ ] " + n.element + " [ " + toString(n.droit) + " ] ";
        if (n.droit == null)
            return " [ " + toString(n.gauche) + " ] " + n.element + " [ ] ";
        return " [ " + toString(n.gauche) + " ] " + n.element + " [ " + toString(n.droit) + " ] ";
    }

    // A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
    // permet de construire l'ensembleTrie de l'enonce

    public EnsembleTrieImpl(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        Noeud nG = new Noeud(null, e2, new Noeud(e5));
        Noeud nG1 = new Noeud(new Noeud(e7), e4, new Noeud(e6));
        Noeud nD = new Noeud(nG1, e3, null);
        racine = new Noeud(nG, e1, nD);
        taille = 7;
    }


    public class Noeud {

        private E element;
        private Noeud gauche;
        private Noeud droit;

        private Noeud(E element) {
            this.element = element;
            this.gauche = null;
            this.droit = null;
        }

        private Noeud(Noeud gauche, E element, Noeud droit) {
            this.element = element;
            this.gauche = gauche;
            this.droit = droit;
        }
    }

}
