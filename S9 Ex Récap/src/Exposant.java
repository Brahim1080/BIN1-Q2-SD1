import java.util.Iterator;
import java.util.LinkedList;

public class Exposant {
    private String nom,GSM ,mail ;
    private LinkedList<Emplacement> listeEmplacements;

    public Exposant(String nom, String GSM, String mail) {
        this.nom = nom;
        this.GSM = GSM;
        this.mail = mail;
    }
    public Iterator<Emplacement> tousLesEmplacements(){
        return listeEmplacements.iterator() ;
    }
    public boolean ajouterEmplacement(Emplacement emplacement){
        return listeEmplacements.add(emplacement);
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGSM() {
        return GSM;
    }

    public void setGSM(String GSM) {
        this.GSM = GSM;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
