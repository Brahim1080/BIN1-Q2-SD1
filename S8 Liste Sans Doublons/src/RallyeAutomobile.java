import java.util.HashSet;
/**
 *
 * @author ABID Brahim
 *
 *
 */
public class RallyeAutomobile {
    private ListeSD<String> listeDePilotes;
    private HashSet<String> ensemblesDisqualifies;
    private ListeSD<String> listePiloteArrives;
    /**
     * @param lesPilotes
     *  Construit un rallye comportant la liste de pilote passee en parametre
     */
    public RallyeAutomobile(String[] lesPilotes) {
        ensemblesDisqualifies = new HashSet<String>();
        listeDePilotes = new ListeSDImpl<String>();
        listePiloteArrives = new ListeSDImpl<>();
        for (String pilote : lesPilotes) {
            listeDePilotes.insererEnQueue(pilote);
        }

    }
    public boolean estPremier(String pilote){
        return listeDePilotes.premier().equals(pilote);
    }
    public boolean supprimer(String pilote){
        if (!listeDePilotes.contient(pilote)){
            return false;
        }
        ensemblesDisqualifies.add(pilote);
        return listeDePilotes.supprimer(pilote);
    }

    public boolean contient (String pilote){
        return listeDePilotes.contient(pilote);
    }

    public String donnerPiloteEnTete(){
        return listeDePilotes.premier();
    }

    public boolean estFini(){
        return listeDePilotes.taille()==0;
    }

    public boolean depasser(String pilote ){
        if (!listeDePilotes.contient(pilote))
            return false;
        String pilote2 = listeDePilotes.donnerPrecedent(pilote);
        if (pilote2 == null){
            return false;
        }

        return listeDePilotes.permuter(pilote, pilote2);
    }

    public boolean piloteEnTeteArriver(){
        listePiloteArrives.insererEnQueue(listeDePilotes.premier());
        return listeDePilotes.supprimer(listeDePilotes.premier());
    }
    public boolean estArrive(String pilote){
        return listePiloteArrives.contient(pilote);
    }
    public String afficherFinDeCourse(){
        return listePiloteArrives.toString();
    }
    public String afficherTouteLaCourse(){
        return listeDePilotes.toString();
    }

    public int donnerPositionDunPilote(String piloteAChercher){
        if (!listeDePilotes.contient(piloteAChercher))
            return -1;
        int position = 0 ;
        for (String pilote: listeDePilotes) {
            position++;
            if (pilote.equals(piloteAChercher)){
                return position;
            }
        }

        throw new RuntimeException();

    }
    public boolean estDisqualifie(String pilote){
        return ensemblesDisqualifies.contains(pilote);
    }


}
