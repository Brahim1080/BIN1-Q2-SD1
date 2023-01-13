import java.util.HashMap;
import java.util.HashSet;

public class Bloc {

    private HashSet<String> ensembleEtudiants;
    private HashSet<String> ensembleDelegues;
    private HashMap<String, Noeud> mapSerieNoeudDelegue;
    private Noeud tete; //tete de la liste des etudiants

    // A ne pas changer

    /**
     * Le constructeur construit un bloc de t.length/2 series et uniquement les delegues
     *
     * @param tableSerieDelegue, la table qui contient les noms des series et les noms des delegues
     * @throws IllegalArgumentException si la table ne permet pas de construire la bloc
     */
    public Bloc(String[] tableSerieDelegue) {
        // minimum une serie
        if (tableSerieDelegue.length == 0)
            throw new IllegalArgumentException();
        // une serie a toujours un delegue
        if (tableSerieDelegue.length % 2 != 0)
            throw new IllegalArgumentException();
        ensembleEtudiants = new HashSet<String>();
        ensembleDelegues = new HashSet<String>();
        mapSerieNoeudDelegue = new HashMap<String, Noeud>();
        tete = new Noeud(tableSerieDelegue[1]);
        ensembleEtudiants.add(tableSerieDelegue[1]);
        ensembleDelegues.add(tableSerieDelegue[1]);
        mapSerieNoeudDelegue.put(tableSerieDelegue[0], tete);
        Noeud baladeur = tete;
        for (int i = 2; i < tableSerieDelegue.length; i = i + 2) {
            baladeur.suivant = new Noeud(tableSerieDelegue[i + 1]);
            baladeur = baladeur.suivant;
            ensembleEtudiants.add(tableSerieDelegue[i + 1]);
            ensembleDelegues.add(tableSerieDelegue[i + 1]);
            mapSerieNoeudDelegue.put(tableSerieDelegue[i], baladeur);
        }
        // tous les noms des etudiants sont differents?
        if (ensembleEtudiants.size() != tableSerieDelegue.length / 2)
            throw new IllegalArgumentException();
        // tous les noms des series sont differents?
        if (mapSerieNoeudDelegue.size() != tableSerieDelegue.length / 2)
            throw new IllegalArgumentException();
    }


    // A ne pas changer, va servir pour les tests
    public String toString() {
        String aRenvoyer = tete.etudiant;
        Noeud baladeur = tete.suivant;
        int cpt = 0;
        while (baladeur != null) {
            aRenvoyer += " " + baladeur.etudiant;
            baladeur = baladeur.suivant;
            cpt++;
            if (cpt == 100)
                return "boucle infinie";
        }
        return aRenvoyer;
    }

    /**
     * verifie la presence d'un etudiant dans le bloc
     *
     * @param etudiant l'etudiant recherche
     * @return true si l'etudiant est present, false sinon
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean estEtudiant(String etudiant) {
        if (etudiant == null || etudiant.length() == 0)
            throw new IllegalArgumentException();
        return ensembleEtudiants.contains(etudiant);
    }


    /**
     * verifie si l'etudiant est un delegue
     *
     * @param etudiant l'etudiant recherche
     * @return true si l'etudiant est un delegue, false sinon
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean estDelegue(String etudiant) {
        if (etudiant == null || etudiant.length() == 0)
            throw new IllegalArgumentException();
        return ensembleDelegues.contains(etudiant);
    }

    /**
     * verifie la presence de la serie dans le bloc
     *
     * @param serie la serie recherchee
     * @return true si la serie est presente, false sinon
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean estSerie(String serie) {
        if (serie == null || serie.length() == 0)
            throw new IllegalArgumentException();
        return mapSerieNoeudDelegue.containsKey(serie);
    }


    /**
     * ajoute un etudiant dans une serie.
     * L'etudiant ne peut pas deja etre present dans le bloc
     * La serie doit exister
     *
     * @param etudiant l'etudiant a ajouter
     * @param serie    la serie
     * @return true si l'ajout a pu se faire, false sinon
     * @throws IllegalArgumentException en cas de parametre null ou vide
     */
    public boolean ajouterEtudiant(String etudiant, String serie) {
        if (etudiant == null || etudiant.length() == 0)
            throw new IllegalArgumentException();
        if (serie == null || serie.length() == 0)
            throw new IllegalArgumentException();
        if (estEtudiant(etudiant) || !estSerie(serie))
            return false;
        Noeud noeudDelegue = mapSerieNoeudDelegue.get(serie);
        Noeud noeudNvEtudiant = new Noeud(etudiant);

        noeudNvEtudiant.suivant = noeudDelegue.suivant;
        noeudDelegue.suivant = noeudNvEtudiant;
        ensembleEtudiants.add(etudiant);
        return true;
    }

    /**
     * supprime un etudiant du bloc
     * l'etudiant doit etre present et ne pas etre un delegue
     *
     * @param etudiant l'etudiant a supprimer
     * @return true si la suppression a pu se faire
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean supprimerEtudiant(String etudiant) {
        if (etudiant == null || etudiant.length() == 0)
            throw new IllegalArgumentException();
        if (!estEtudiant(etudiant) || estDelegue(etudiant))
            return false;
        Noeud noeud = tete;

        while (!noeud.suivant.etudiant.equals(etudiant))
            noeud = noeud.suivant;

        noeud.suivant = noeud.suivant.suivant;
        ensembleEtudiants.remove(etudiant);

        return true;

    }

    /**
     * renvoie sous forme d'une chaine de caractere tous les etudiants appartenant a une serie donnee
     * le delimitateur entre chaque etudiant est un espace
     * un espace est tolere en debut ou fin de chaine renvoyee
     *
     * @param serie la serie
     * @return une chaine de caracteres de etudiants
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public String donnerSerie(String serie) {
        if (serie == null || serie.length() == 0)
            throw new IllegalArgumentException();

        if (!estSerie(serie))
            return "";
        Noeud noeud = mapSerieNoeudDelegue.get(serie);
        String listSerie = "";
        Noeud delegue = noeud;
        while (noeud != null ){
            if (estDelegue(noeud.etudiant) && noeud!= delegue)
                break;
            listSerie += noeud.etudiant + " ";
            noeud =  noeud.suivant;

        }



        return listSerie;
    }

    // Classe interne Noeud
    private class Noeud {

        private String etudiant;
        private Noeud suivant;

        public Noeud(String etudiant) {
            this.etudiant = etudiant;
        }

        public Noeud(String etudiant, Noeud suivant) {
            super();
            this.etudiant = etudiant;
            this.suivant = suivant;
        }
    }
}
