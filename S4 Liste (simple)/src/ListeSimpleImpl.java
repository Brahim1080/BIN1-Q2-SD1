import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implementation de l'interface ListeSimple avec une liste simplement chainee
 *
 * @author Brahim Abid
 */
public class ListeSimpleImpl<E> implements ListeSimple<E> {

    private Noeud tete;
    private int taille;


    public ListeSimpleImpl() {
        tete = null;
        taille = 0;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public ListeSimpleImpl(Object[] table) {
        if (table == null)
            throw new IllegalArgumentException();
        this.taille = table.length;
        for (int i = table.length - 1; i >= 0; i--) {
            E element = (E) table[i];
            this.tete = new Noeud(element, tete);
        }
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String toString() {
        String aRenvoyer = "";
        Noeud baladeur = tete;
        int cpt = 0;
        while (baladeur != null) {
            cpt++;
            if (cpt > taille) {
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
                return aRenvoyer;
            }
            aRenvoyer += " " + baladeur.element;
            baladeur = baladeur.suivant;
        }
        return aRenvoyer;
    }


    public int taille() {
        return taille;
    }

    public boolean estVide() {
        return taille == 0;
    }

    // renvoie l element contenu dans le noeud de tete
    public E premier() throws ListeVideException {
        if (this.estVide()) throw new ListeVideException();

        return (E) tete.element;
    }


    // insere un nouveau noeud en tete de liste avec l element
    public void insererEnTete(E element) {
        Noeud nouveauNoeud = new Noeud(element, tete);
        tete = nouveauNoeud;
        taille++;

    }


    // verifie la presence d un noeud contenant l element passe en parametre
    public boolean contient(E element) {
        Noeud baladeur = tete;
        while (baladeur != null) {
            if (baladeur.element.equals(element))
                return true;
            baladeur = baladeur.suivant;
        }

        return false;

    }


    // insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
    public boolean insererApres(E element, E elementAInserer) {
        Noeud baladeur = tete;
        while (baladeur != null) {
            if (baladeur.element.equals(element)) {
                Noeud nouveauNoeud = new Noeud(elementAInserer, baladeur.suivant);
                nouveauNoeud.suivant = baladeur.suivant;
                baladeur.suivant = nouveauNoeud;
                taille++;
                return true;
            }
            baladeur = baladeur.suivant;
        }
        return false;

    }


    //supprime le noeud contenant la premiere occurrence de l'element passe en parametre
    public boolean supprimer(E element) {
        if (tete == null)
            return false;
        if (element.equals(tete.element)) {
            tete = tete.suivant;
            taille--;
            return true;
        }
        Noeud baladeur = tete;
        while (baladeur.suivant != null) {
            if (baladeur.suivant.element.equals(element)) {
                baladeur.suivant = baladeur.suivant.suivant;
                taille--;
                return true;
            }
            baladeur = baladeur.suivant;

        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new IterateurImpl();
    }


    private class Noeud {
        private E element;
        private Noeud suivant;

        public Noeud(E element, Noeud suivant) {
            this.element = element;
            this.suivant = suivant;
        }
    }


    private class IterateurImpl implements Iterator {

        private Noeud noeudNext;


        // Au depart le noeud "next" est le noeud de tete
        private IterateurImpl() {
            noeudNext = tete;
        }

        @Override
        // verifie si le noeud "next" est null
        public boolean hasNext() {

            return noeudNext != null;
        }


        @Override
        // renvoie l element qui se trouve dans le noeud "next"
        // le noeud "next" passe au noeud suivant
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E elem = noeudNext.element;
            noeudNext = noeudNext.suivant;
            // pensez a consulter la JAVADOC de la classe Iterator!!!
            return  elem;
        }


        @Override
        // A NE PAS COMPLETER : Les suppressions sont interdites
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
