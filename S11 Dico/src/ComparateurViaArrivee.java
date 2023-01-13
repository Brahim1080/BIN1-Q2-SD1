import java.util.Comparator;
/**
 *
 * @author ABID Brahim
 *
 */
public class ComparateurViaArrivee implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        int result = o1.getDateArrive().compareTo(o2.getDateArrive());
        return result;
    }
}
