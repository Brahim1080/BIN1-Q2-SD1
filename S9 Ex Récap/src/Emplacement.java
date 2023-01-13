public class Emplacement {
    private int numero;
    private Exposant exposant;

    public Emplacement(int numero) {
        this.numero = numero;
        ;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Exposant getExposant() {
        return exposant;
    }

    public void setExposant(Exposant exposant) {
        this.exposant = exposant;
    }
}
