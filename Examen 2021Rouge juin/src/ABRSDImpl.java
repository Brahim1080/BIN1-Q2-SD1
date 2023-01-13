import java.util.ArrayList;

public class ABRSDImpl<E> implements ABRSD<E> {

    private Noeud racine;
    private int taille;

    public ABRSDImpl() {
        racine = null;
        taille = 0;
    }

    public boolean estVide() {
        return racine == null;
    }

    public int taille() {
        return taille;
    }


    public E elementLePlusPetit() {
        //TODO
        //Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
        if (estVide())
            return null;
        if (taille == 1)
            return racine.element;

        return elementLePlusPetit(racine);
    }

    public E elementLePlusPetit(Noeud noeud) {
        if (noeud.gauche == null)
            return noeud.element;
        return elementLePlusPetit(noeud.gauche);
    }


    public boolean insere(E element) {
        //TODO
        //Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
        System.out.println("element  A AJOUTER = " + element);
        if (taille == 0) {
            racine = new Noeud(element);
            taille++;
            return true;
        }

        return insere(racine, element, racine);
    }

    private boolean insere(Noeud noeud, E element, Noeud parent) {
        if (noeud == null) {
            noeud = new Noeud(element);
            System.out.println("noeud = " + noeud.element);
            System.out.println("Ajout a bien ete fait ");
            taille++;
            if ((((Comparable<E>) element).compareTo(parent.element)) > 0) {
                parent.droit = noeud;
            } else parent.gauche = noeud;
            return true;
        }


        E element2 = noeud.element;
        System.out.println("element compare = " + element2);
        if ((((Comparable<E>) element).compareTo(element2) > 0))
            return insere(noeud.droit, element, noeud);
        if ((((Comparable<E>) element).compareTo(element2) < 0))
            return insere(noeud.gauche, element, noeud);
        System.out.println("ELEMENT DEJA PRESENT");
        return false;

    }


    public E elementPrecedent(E element) {
        //TODO
        // Suggestion :
        // remplir une "arrayList" via un parcours en in-ordre
        // l'element precedent est l'element qui se trouve juste avant lui dans l'arrayList !
        // cette methode peut donc appeler la methode "private" remplirArrayList() qui suit
        ArrayList<E> list = new ArrayList<>();
        remplirArrayList(racine,list);
        if (!list.contains(element))
            return null;
        int indexElement = list.indexOf(element);

        if (indexElement==0)
            return null;

        return list.get(indexElement-1);
    }

    private void remplirArrayList(Noeud noeud, ArrayList<E> liste) {
        // suggestion de methode a appeler par la methode elementPrecedent()
        if (noeud== null)
            return;
        remplirArrayList(noeud.gauche,liste);
        liste.add(noeud.element);
        remplirArrayList(noeud.droit,liste);
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
    // permet de construire l'ABRSD de l'enonce

    public ABRSDImpl(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
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
