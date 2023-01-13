import java.util.Comparator;
/**
 *
 * @author ABID Brahim
 *
 */
public class ComparateurViaNom implements Comparator<Etudiant> {
    public int compare(Etudiant etudiant1, Etudiant etudiant2) {
        int result = etudiant1.getNom().compareTo(etudiant2.getNom());
        if (result==0){
            result = etudiant1.getPrenom().compareTo(etudiant2.getPrenom());
        }

        return result;

    }
}
