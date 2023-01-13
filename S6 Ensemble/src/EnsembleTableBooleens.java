
// implementation de l'interface Ensemble via un tableau de booleens

public class EnsembleTableBooleens<E> implements Ensemble<E> {

    private boolean[] table;
    private int taille;


    // capacite = nombre d'elements de l'univers
    public EnsembleTableBooleens(int capacite) {
        table = new boolean[capacite];
        taille = 0;
    }

    public int taille() {
        return taille;
    }

    public boolean estVide() {
        return taille == 0;
    }


    public boolean contient(E element) {
        int indice = element.hashCode() ;
        return table[indice];
    }

    public boolean ajouter(E element) {

        int indice = element.hashCode();
        if (table[indice]) {
            return false;
        }
        table[indice] = true;
        taille++;
        return true;
    }

    public boolean enlever(E element) {
        int indice = element.hashCode();
        if (!table[indice]) {
            return false;
        }
        table[indice] = false;
        taille--;
        return true;
    }

}