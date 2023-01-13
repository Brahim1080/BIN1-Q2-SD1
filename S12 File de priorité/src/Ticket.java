public class Ticket implements Comparable<Ticket>{
    private static int numeroAttribue ;
    private int numero;
    private String email;
    private String descriptif;
    private int priorite;

    public Ticket( String email, String descriptif, int priorite) {
        this.numero = ++numeroAttribue;
        this.email = email;
        this.descriptif = descriptif;
        this.priorite = priorite;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    @Override
    public int compareTo(Ticket o) {
        return 0;
    }
}
