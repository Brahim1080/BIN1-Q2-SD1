import java.util.HashMap;
import java.util.Iterator;

public class ListeConcoursTango {

    private Noeud tete;
    private Noeud queue;
    private HashMap<Danseur, Noeud> mapDanseurNoeud;

    public ListeConcoursTango() {
        mapDanseurNoeud = new HashMap<Danseur, Noeud>();
        tete = null;
        queue = null;
    }

    /**
     * determine le nombre de danseurs
     *
     * @return le nombre de danseurs
     */
    public int taille() {
        return mapDanseurNoeud.size();
    }

    /**
     * verifie si la liste ne contient aucun danseur
     *
     * @return true si la liste est vide, false sinon
     */
    public boolean estVide() {
        return mapDanseurNoeud.isEmpty();
    }


    /**
     * calcule le nombre de danseur appartenant a la nationalite passee en parametre
     *
     * @param nationalite la nationalite recherchee
     * @return le nombre de danseur appartenant a la nationalite recherchee
     */
    public int donnerNombreDanseursDeNationalite(String nationalite) {
        //TODO
        // contrainte : cette methode doit etre iterative

        Noeud noeud = this.tete;
        int cptNbrDanseur = 0;
        while (noeud != null) {
            if (noeud.danseur.getNationalite().equals(nationalite))
                cptNbrDanseur++;

            noeud = noeud.suivant;
        }
        return cptNbrDanseur;
    }


    /**
     * verifie si tous les danseurs ont au moins 3 annees d'experience
     *
     * @return true si tous les danseurs ont au moins 3 annees d'experience, false sinon
     */
    public boolean ontTous3AnsMinimumDExperience() {
        //TODO
        //contrainte : cette methode doit etre recursive
        if (estVide())
            return true;
        return ontTous3AnsMinimumDExperience(tete);
    }

    public boolean ontTous3AnsMinimumDExperience(Noeud noeud) {
        if (noeud == null)
            return true;
        if (noeud.danseur.getExperience() < 3)
            return false;

        return ontTous3AnsMinimumDExperience(noeud.suivant);
    }


    /**
     * donne le partenaire du danseur passe en parametre
     *
     * @param danseur le danseur dont on cherche le partenaire
     * @return le partenaire ou null si le danseur n'est pas present dans la liste
     * @throws IllegalArgumentException si le parametre est null
     */
    public Danseur donnerPartenaire(Danseur danseur) {
        if (danseur == null)
            throw new IllegalArgumentException();
        if (!mapDanseurNoeud.containsKey(danseur))
            return null;
        char sexeDuDanseur = danseur.getSexe();
        Noeud noeudDanseur = mapDanseurNoeud.get(danseur);
        if (sexeDuDanseur == 'H')
            return noeudDanseur.suivant.danseur;
        return noeudDanseur.precedent.danseur;

    }

    /**
     * ajoute les 2 danseurs en fin de liste
     * les 2 danseurs doivent etre de sexe oppose et ne peuvent pas encore etre presents dans la liste
     *
     * @param danseur1 un des danseurs du couple
     * @param danseur2 l'autre danseur du couple
     * @return true si l'ajout a pu se faire, false sinon
     * @throws IllegalArgumentException si un des parametres est null
     */
    public boolean ajouterCouple(Danseur danseur1, Danseur danseur2) {
        if (danseur1 == null || danseur2 == null)
            throw new IllegalArgumentException();
        //Si meme sexe
        if (danseur1.getSexe() == danseur2.getSexe())
            return false;
        if (mapDanseurNoeud.containsKey(danseur1) || mapDanseurNoeud.containsKey(danseur2))
            return false;
        char sexeDanseur1 = danseur1.getSexe();
        char sexeDanseur2 = danseur2.getSexe();
        Noeud noeudHomme;
        Noeud noeudFemme;

        if (sexeDanseur1 == 'H'){
            noeudHomme = new Noeud(danseur1);
            noeudFemme = new Noeud(danseur2);

        }else{
            noeudFemme = new Noeud(danseur1);
            noeudHomme = new Noeud(danseur2);
            mapDanseurNoeud.put(danseur1,noeudFemme);
            mapDanseurNoeud.put(danseur2,noeudHomme);
        }

        mapDanseurNoeud.put(noeudHomme.danseur, noeudHomme);
        mapDanseurNoeud.put(noeudFemme.danseur, noeudFemme);

        //chainage entre les deux danseurs
        noeudFemme.precedent =noeudHomme;
        noeudHomme.suivant = noeudFemme;
        if (tete == null){
            tete = noeudHomme;
            queue =noeudFemme;
        }else{
            //chainage queue avec homme
            queue.suivant=noeudHomme;
            noeudHomme.precedent= queue;
            //queue devient la femme ajouter
            queue = noeudFemme;

        }

       return true;
    }


    // pour les tests
    public ListeConcoursTango(Danseur[] tableACopier) {
        mapDanseurNoeud = new HashMap<Danseur, Noeud>();
        if (tableACopier.length == 0)
            return;
        tete = new Noeud(tableACopier[0]);
        mapDanseurNoeud.put(tableACopier[0], tete);
        Noeud prec = tete;
        for (int i = 1; i < tableACopier.length; i++) {
            Noeud nouveauNoeud = new Noeud(tableACopier[i]);
            mapDanseurNoeud.put(tableACopier[i], nouveauNoeud);
            nouveauNoeud.precedent = prec;
            prec.suivant = nouveauNoeud;
            prec = nouveauNoeud;
        }
        queue = prec;
    }

    // pour les tests
    public String teteQueue() {
        try {
            String aRenvoyer = "(";
            Noeud baladeur = tete;
            int cpt = 0;
            while (baladeur != null) {
                if (cpt == 0)
                    aRenvoyer += baladeur.danseur.getNom();
                else
                    aRenvoyer += "," + baladeur.danseur.getNom();
                baladeur = baladeur.suivant;
                cpt++;
                if (cpt == 100) {
                    return "boucle infinie";
                }
            }
            return aRenvoyer + ")";
        } catch (NullPointerException e) {
            return "nullPointerException";
        }
    }

    // pour les tests
    public String queueTete() {
        try {
            String aRenvoyer = "(";
            Noeud baladeur = queue;
            int cpt = 0;
            while (baladeur != null) {
                if (cpt == 0)
                    aRenvoyer += baladeur.danseur.getNom();
                else
                    aRenvoyer += "," + baladeur.danseur.getNom();
                baladeur = baladeur.precedent;
                cpt++;
                if (cpt == 100) {
                    return "boucle infinie";
                }
            }
            return aRenvoyer + ")";
        } catch (NullPointerException e) {
            return "nullPointerException";
        }
    }

    // Classe interne Noeud
    private class Noeud {

        private Danseur danseur;
        private Noeud suivant;
        private Noeud precedent;

        private Noeud(Danseur danseur) {
            this(null, danseur, null);
        }

        private Noeud(Noeud precedent, Danseur danseur, Noeud suivant) {
            this.danseur = danseur;
            this.suivant = suivant;
            this.precedent = precedent;
        }
    }

}
