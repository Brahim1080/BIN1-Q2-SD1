import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Troupe {

    private HashSet<String> ensembleScouts;
    private HashSet<String> ensembleCP; // CP = chef de patrouille
    private HashMap<String, Noeud> mapPatrouilleNoeudCP;
    private Noeud tete; // tete de la liste de scouts
    // N'ajoutez pas d'autres attributs


    // A ne pas changer

    /**
     * Le constructeur construit une troupe de t.length/2 patrouilles et uniquement les CPs
     *
     * @param tablePatrouilleCP, la table qui contient les noms des patrouilles et les noms des CPs
     * @throws IllegalArgumentException si la table ne permet pas de construire la troupe
     */
    public Troupe(String[] tablePatrouilleCP) {
        // minimum une patrouille
        if (tablePatrouilleCP.length == 0)
            throw new IllegalArgumentException();
        // une patrouille a toujours un CP
        if (tablePatrouilleCP.length % 2 != 0)
            throw new IllegalArgumentException();
        ensembleScouts = new HashSet<String>();
        ensembleCP = new HashSet<String>();
        mapPatrouilleNoeudCP = new HashMap<String, Noeud>();
        tete = new Noeud(tablePatrouilleCP[1]);
        ensembleScouts.add(tablePatrouilleCP[1]);
        ensembleCP.add(tablePatrouilleCP[1]);
        mapPatrouilleNoeudCP.put(tablePatrouilleCP[0], tete);
        Noeud baladeur = tete;
        for (int i = 2; i < tablePatrouilleCP.length; i = i + 2) {
            baladeur.suivant = new Noeud(tablePatrouilleCP[i + 1]);
            baladeur = baladeur.suivant;
            ensembleScouts.add(tablePatrouilleCP[i + 1]);
            ensembleCP.add(tablePatrouilleCP[i + 1]);
            mapPatrouilleNoeudCP.put(tablePatrouilleCP[i], baladeur);
        }
        // tous les noms des scouts sont differents?
        if (ensembleScouts.size() != tablePatrouilleCP.length / 2)
            throw new IllegalArgumentException();
        // tous les noms des patrouilles sont differents?
        if (mapPatrouilleNoeudCP.size() != tablePatrouilleCP.length / 2)
            throw new IllegalArgumentException();
    }


    // A ne pas changer, va servir pour les tests
    public String toString() {
        String aRenvoyer = tete.scout;
        Noeud baladeur = tete.suivant;
        int cpt = 0;
        while (baladeur != null) {
            aRenvoyer += " " + baladeur.scout;
            baladeur = baladeur.suivant;
            cpt++;
            if (cpt == 100)
                return "boucle infinie";
        }
        return aRenvoyer;
    }

    /**
     * verifie la presence du scout dans la troupe
     *
     * @param scout le scout recherche
     * @return true si le scout est present, false sinon
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean estScout(String scout) {
        if (scout == null || scout.length() == 0)
            throw new IllegalArgumentException();
        // TODO
        return ensembleScouts.contains(scout);

    }


    /**
     * verifie si le scout est un CP
     *
     * @param scout le scout recherche
     * @return true si le scout est un CP, false sinon
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean estCP(String scout) {
        if (scout == null || scout.length() == 0)
            throw new IllegalArgumentException();

        return ensembleCP.contains(scout);
    }

    /**
     * verifie la presence de la patrouille dans la troupe
     *
     * @param patrouille la patrouille recherchee
     * @return true si la patrouille est presente, false sinon
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean estPatrouille(String patrouille) {
        if (patrouille == null || patrouille.length() == 0)
            throw new IllegalArgumentException();

        return mapPatrouilleNoeudCP.containsKey(patrouille);
    }


    /**
     * ajoute un scout dans une patrouille.
     * Le scout ne peut pas deja etre present dans la troupe
     * La patrouille doit exister
     *
     * @param scout      le scout a ajouter
     * @param patrouille la patrouille
     * @return true si l'ajout a pu se faire, false sinon
     * @throws IllegalArgumentException en cas de parametre null ou vide
     */
    public boolean ajouterScout(String scout, String patrouille) {
        if (scout == null || scout.length() == 0)
            throw new IllegalArgumentException();
        if (patrouille == null || patrouille.length() == 0)
            throw new IllegalArgumentException();
        if (!mapPatrouilleNoeudCP.containsKey(patrouille))
            return false;
        if (ensembleScouts.contains(scout))
            return false;
        Noeud noeudCP = mapPatrouilleNoeudCP.get(patrouille);

        Noeud noeudScout = new Noeud(scout);
        ensembleScouts.add(scout);
        noeudScout.suivant = noeudCP.suivant;
        noeudCP.suivant = noeudScout;
        return true;
    }

    /**
     * supprime un scout de la troupe
     * le scout doit etre present et ne pas etre un CP
     *
     * @param scout le scout a supprimer
     * @return true si la suppression a pu se faire
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public boolean supprimerScout(String scout) {
        if (scout == null || scout.length() == 0)
            throw new IllegalArgumentException();
        if (ensembleCP.contains(scout) || !ensembleScouts.contains(scout))
            return false;

        ensembleScouts.remove(scout);
        Noeud noeud = tete;
        //tant que le suivant n'est pas le scout a supprimer
        while (!noeud.suivant.scout.equals(scout)) {
            noeud = noeud.suivant;
        }
        noeud.suivant = noeud.suivant.suivant;


        return true;
    }

    /**
     * renvoie sous forme d'une chaine de caractere tous les scouts(CP compris) appartenant a une patrouille donnee
     * Si la patrouile n'existe pas, renvoie la chaine vide
     * le delimitateur entre chaque scout est un espace
     * un espace est tolere en debut ou fin de chaine renvoyee
     *
     * @return une chaine de caracteres de scouts
     * @throws IllegalArgumentException si le parametre est null ou vide
     */
    public String donnerPatrouille(String patrouille) {
        if (patrouille == null || patrouille.length() == 0)
            throw new IllegalArgumentException();
        // TODO ---
        if (!estPatrouille(patrouille))
            return "";
        Noeud noeud = mapPatrouilleNoeudCP.get(patrouille);
        Noeud noeudChefPatrouille = noeud;
        String listePatrouille = " ";

        while (noeud != null) {

            if(estCP(noeud.scout) && noeud!=noeudChefPatrouille)
                break;
            listePatrouille += noeud.scout + " ";
            noeud = noeud.suivant;


        }
        System.out.println("\nlistePatrouille = " + listePatrouille);
        return listePatrouille;
    }

    // Classe interne Noeud
    private class Noeud {

        private String scout;
        private Noeud suivant;

        public Noeud(String scout) {
            this.scout = scout;
        }

        public Noeud(String scout, Noeud suivant) {
            super();
            this.scout = scout;
            this.suivant = suivant;
        }
    }
}
