import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author ABID Brahim
 *
 */
public class ArbreDEntiers implements Iterable<Integer> {
    protected NoeudEntier racine;
    protected int taille;

    public ArbreDEntiers() {
        this.racine = null;
        this.taille = 0;
    }

    public ArbreDEntiers(int entier) {
        this.racine = new NoeudEntier(entier);
        this.taille = 1;
    }

    public ArbreDEntiers(ArbreDEntiers gauche, int entier, ArbreDEntiers droit) {
        this.racine = new NoeudEntier(gauche.racine, entier, droit.racine);
        this.taille = 1 + gauche.taille + droit.taille;
    }

    public boolean estVide() {
        return this.racine == null;
    }

    public int taille() {
        return taille;
    }

    public Iterator<Integer> preIterateur() {
        return new PreIterateur(this);
    }

    public Iterator<Integer> postIterateur() {
        return new PostIterateur(this);

    }

    // iterateur in ordre
    public Iterator<Integer> iterator() {
        return new InIterateur(this);

    }

    public Iterator<Integer> iterateurParNiveau() {
        return new ParNivIterateur(this);

    }


    protected class NoeudEntier {
        protected int entier;
        protected NoeudEntier gauche;
        protected NoeudEntier droit;

        private NoeudEntier(int entier) {
            this.entier = entier;
            this.gauche = null;
            this.droit = null;
        }

        private NoeudEntier(NoeudEntier g, int entier, NoeudEntier d) {
            this.entier = entier;
            this.gauche = g;
            this.droit = d;
        }
    }

    private class PreIterateur implements Iterator<Integer> {

        private ArrayDeque<Integer> fileDEntiers;

        public PreIterateur(ArbreDEntiers a) {
            fileDEntiers = new ArrayDeque<Integer>(taille);
            remplirFile(a.racine);
        }

        private void remplirFile(NoeudEntier n) {
            if (n == null)
                return;
            fileDEntiers.add(n.entier);
            remplirFile(n.gauche);
            remplirFile(n.droit);

        }

        public boolean hasNext() {
            return !fileDEntiers.isEmpty();

        }

        public Integer next() {
            return fileDEntiers.removeFirst();

        }
    }

    private class PostIterateur implements Iterator<Integer> {

        private ArrayDeque<Integer> fileDEntiers;

        public PostIterateur(ArbreDEntiers a) {
            fileDEntiers = new ArrayDeque<Integer>(taille);
            remplirFile(a.racine);
        }

        private void remplirFile(NoeudEntier n) {
            if (n == null)
                return;
            remplirFile(n.gauche);
            remplirFile(n.droit);
            fileDEntiers.add(n.entier);

        }

        public boolean hasNext() {
            return !fileDEntiers.isEmpty();

        }

        public Integer next() {
            return fileDEntiers.removeFirst();

        }
    }
    private class InIterateur implements Iterator<Integer> {

        private ArrayDeque<Integer> fileDEntiers;

        public InIterateur(ArbreDEntiers a) {
            fileDEntiers = new ArrayDeque<Integer>(taille);
            remplirFile(a.racine);
        }

        private void remplirFile(NoeudEntier n) {
            if (n == null)
                return;
            remplirFile(n.gauche);
            fileDEntiers.add(n.entier);
            remplirFile(n.droit);


        }

        public boolean hasNext() {
            return !fileDEntiers.isEmpty();

        }

        public Integer next() {
            return fileDEntiers.removeFirst();

        }
    }
    private class ParNivIterateur implements Iterator<Integer> {

        private ArrayDeque<NoeudEntier> fileDEnoeud;

        public ParNivIterateur(ArbreDEntiers a) {
            fileDEnoeud = new ArrayDeque<NoeudEntier>(taille);
            if (a.racine != null){
                fileDEnoeud.add(racine);
            }

        }

//        private void remplirFile(NoeudEntier n) {
//            if (n == null)
//                return;
//            remplirFile(n.gauche);
//            fileDEntiers.add(n.entier);
//            remplirFile(n.droit);
//
//
//        }

        public boolean hasNext() {
            return !fileDEnoeud.isEmpty();

        }

        public Integer next() {
            NoeudEntier noeud = fileDEnoeud.removeFirst();
            if (noeud.gauche !=null){
                fileDEnoeud.add(noeud.gauche);

            }
            if (noeud.droit != null){
                fileDEnoeud.add(noeud.droit);
            }
            return noeud.entier;

        }
    }
}
