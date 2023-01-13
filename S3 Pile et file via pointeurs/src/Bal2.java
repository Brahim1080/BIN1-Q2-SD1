public class Bal2 {
    /**
     * Cette classe retient dans une liste les etudiants inscrits au bal
     * La liste contient d abord les hommes, ensuite les femmes
     * Dans chacune des sous-listes, l'ordre suit l'ordre des inscriptions
     *
     * @author Brahim Abid
     *
     */

    private NoeudEtudiant tete;
    private NoeudEtudiant derM;
    private NoeudEtudiant derF;

    /**
     * construit un bal avec aucun participant
     */
    public Bal2(){
        derF = new NoeudEtudiant(null);
        tete = new NoeudEtudiant(null,derF);
        derM=tete;


        // construit une liste avec 2 noeuds bidons
        // les elements de ces noeuds bidons sont a null
    }

    public String toString(){
        String aRenvoyer = "";
        NoeudEtudiant baladeur = tete;
        while(baladeur!=null){
            if(baladeur.etudiant!=null) {
                aRenvoyer += " " + baladeur.etudiant.getPrenom();
            }
            baladeur = baladeur.suivant;
        }
        return aRenvoyer;
    }

    /**
     * ajoute l etudiant dans la liste en tenant compte de l'ordre prevu
     * @param etudiant l etudiant a ajouter
     * @throws IllegalArgumentException si l etudiant est null
     */
    public void ajouterEtudiant(Etudiant etudiant){
        if(etudiant==null)
            throw new IllegalArgumentException("etudiant null");
        NoeudEtudiant noeudEtudiant = new NoeudEtudiant(etudiant);
        if (etudiant.getSexe() == 'M'){
            noeudEtudiant.suivant = derM.suivant;
            derM.suivant= noeudEtudiant;
            derM = noeudEtudiant;
        } else if (etudiant.getSexe() == 'F'){
            derF.suivant = noeudEtudiant;
            derF = noeudEtudiant;
        }
    }

    // classe interne
    private class NoeudEtudiant{

        private Etudiant etudiant;
        private NoeudEtudiant suivant;

        public NoeudEtudiant(){
            this.etudiant = null;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant){
            this.etudiant = etudiant;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant, NoeudEtudiant suivant){
            this.etudiant = etudiant;
            this.suivant = suivant;
        }

    }
}


