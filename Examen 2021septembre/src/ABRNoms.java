import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ABRNoms implements Iterable<String> {

    private NoeudNom racine;
    private HashSet<String> ensembleDejaRencontre;
    private HashSet<String> ensembleHomonyme;

    public ABRNoms() {
        racine = null;
    }

    // A NE PAS MODIFIER!!!
    // VA SERVIR POUR LES TESTS!!!

    /**
     * insere le nom (Apres insertion l'arbre est toujours un ABR)
     *
     * @param nom le nom a inserer
     */
    public void insere(String nom) {
        racine = insere(racine, nom);
    }

    private NoeudNom insere(NoeudNom noeud, String nom) {
        if (noeud == null) {
            return new NoeudNom(nom);
        } else {
            if (nom.compareTo(noeud.nom) < 0)
                noeud.gauche = insere(noeud.gauche, nom);
            else
                noeud.droit = insere(noeud.droit, nom);
        }
        return noeud;
    }

    /**
     * calcule le nombre de noms commencant par la lettre passee en parametre
     * un meme nom sera comptabilise autant de fois qu'il y est
     * dans l'exemple de l'enonce, le nombre de noms commencant par 'l' est 5
     *
     * @param lettre la lettre recherchee
     * @return le nombre de noms commencant par la lettre passee en parametre
     * @throws IllegalArgumentException si la lettre n'est pas une lettre minuscule comprise entre 'a' et 'z'
     */
    public int nombreNomsCommencantPar(char lettre) {

        //Attention a l'efficacite de cette methode
        //Il n'est pas necessaire de parcourir tout l'arbre pour trouver ce nombre
        //l'arbre est un ABR
        if (lettre < 'a' || lettre > 'z')
            throw new IllegalArgumentException();
        if (racine == null)
            return 0;
        System.out.println("Lettre recherche :" + lettre);
        //pour obtenir la premiere lettre, utilisez la methode charAt()
        return nombreNomsCommencantPar(racine, lettre);
    }

    private int nombreNomsCommencantPar(NoeudNom noeud, char lettre) {
        if (noeud == null) {
            return 0;
        }

        char noeudNom = noeud.nom.charAt(0);
        System.out.println("Nom " + noeud.nom);
        if (noeudNom > lettre)
            return nombreNomsCommencantPar(noeud.gauche, lettre);

        if (noeudNom < lettre)
            return nombreNomsCommencantPar(noeud.droit, lettre);

        return 1 + nombreNomsCommencantPar(noeud.droit, lettre) + nombreNomsCommencantPar(noeud.gauche, lettre);
    }


    /**
     * construit l'ensemble des noms rencontres plus d'une fois
     * dans l'exemple de l'enonce, l'ensemble des homonymes est : lea , leo et tim
     *
     * @return un ensemble avec les homonymes
     */
    public HashSet<String> ensembleHomonymes() {
        //piste de solution :
        //Au fur et a mesure du parcours de l'arbre vous allez remplir 2 ensembles : l'ensemble avec les noms deja rencontres
        //et l'ensemble des homonymes
        //pour chaque nom rencontre, vous le placerez dans l'ensemble des homonymes si au moment ou il est rencontre,
        //celui-ci fait deja partie de l'ensemble des noms rencontres
        ensembleDejaRencontre = new HashSet<>();
        ensembleHomonyme = new HashSet<>();
        if (racine == null)
            return ensembleHomonyme;
        return ensembleHomonymes(racine);
    }

    private HashSet<String> ensembleHomonymes(NoeudNom noeud) {
        if (noeud == null)
            return null;
        String nom = noeud.nom;
        //si jamais rencontre alors ajout dans deja rencontre
        if (!ensembleDejaRencontre.contains(nom)) {
            ensembleDejaRencontre.add(nom);
        }else{
            //sinon => deja rencontre alors ajout dans liste homonyme
            ensembleHomonyme.add(nom);
        }
        ensembleHomonymes(noeud.droit);
        ensembleHomonymes(noeud.gauche);
        return ensembleHomonyme;
    }


    /**
     * l'iterateur permet de parcourir les noms selon l'ordre alpabetique ascendant (a --> z)
     *
     * @return un iterateur "ascendant"
     */
    public Iterator<String> iterator() {
        return new Iterateur();
    }

    /**
     * l'iterateur permet de parcourir les noms selon l'ordre alpabetique descendant (z --> a)
     * dans l'exemple de l'enonce, l'iterateur renverra les noms dans ce ordre :
     * tim tim leo leo leo lea laure anouk
     *
     * @return un iterateur "descendant"
     */
    public Iterator<String> descendingIterator() {
        return new DescendingIterator();
    }

    // classe interne
    public class NoeudNom {

        private String nom;
        private NoeudNom gauche;
        private NoeudNom droit;

        private NoeudNom(String string) {
            this.nom = string;
            this.gauche = null;
            this.droit = null;
        }

    }

    private class Iterateur implements Iterator<String> {

        private ArrayDeque<String> fileNoms;

        public Iterateur() {
            fileNoms = new ArrayDeque<String>();
            remplirFile(racine);
        }

        private void remplirFile(NoeudNom n) {
            if (n == null) return;
            remplirFile(n.gauche);
            fileNoms.addLast(n.nom);
            remplirFile(n.droit);
        }

        public boolean hasNext() {
            return !fileNoms.isEmpty();
        }

        public String next() {
            if (fileNoms.isEmpty())
                throw new NoSuchElementException();
            return fileNoms.removeFirst();
        }
    }

    private class DescendingIterator implements Iterator<String> {

        private ArrayDeque<String> fileNoms;

        public DescendingIterator() {
            fileNoms = new ArrayDeque<String>();
            remplirFile(racine);
        }

        private void remplirFile(NoeudNom n) {
            if (n == null) return;
            remplirFile(n.droit);
            fileNoms.addLast(n.nom);
            remplirFile(n.gauche);

        }

        public boolean hasNext() {
            return !fileNoms.isEmpty();
        }

        public String next() {
            if (fileNoms.isEmpty())
                throw new NoSuchElementException();
            return fileNoms.removeFirst();
        }
    }


}
