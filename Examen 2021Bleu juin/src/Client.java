/**
 *
 * @author ABID Brahim
 *
 */
public class Client implements Comparable<Client>{

    private String nom;
    private int priorite;


    public Client(String nom, int priorite) {
        this.nom = nom;
        this.priorite = priorite;
    }

    public int getPriorite() {
        return priorite;
    }

    public String getNom() {
        return nom;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    @Override
    public int compareTo(Client o) {
        return 0;
    }

    @Override
    public String toString() {
        return "{" +
                "nom='" + nom + '\'' +
                ", priorite=" + priorite +
                '}';
    }
}
